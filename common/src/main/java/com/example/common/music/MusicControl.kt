package com.example.common.music

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.AudioManager.OnAudioFocusChangeListener
import android.media.MediaPlayer
import android.os.PowerManager
import android.util.Log
import com.example.common.IMusicCommunicate
import com.example.common.IMusicService
import com.example.common.bean.searchBean.MusicBean
import com.example.common.db.EasyListenDB
import com.example.common.utils.LogUtil
import com.example.common.utils.showToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Random
import kotlin.math.abs

class MusicControl(
    private val context: Context
) : MediaPlayer.OnCompletionListener {

    companion object {
        const val TAG = "MusicControl"
    }

    private val mRandom = Random().apply {
        setSeed(System.currentTimeMillis())
    }
    private var mPlayMode = MusicConstants.PLAY_MODE_LOOP // 默认列表循环
    private val mDao = EasyListenDB.instance.playSongListDao()
    private val mPlaylist: MutableList<MusicBean> = mutableListOf()
    private var mCurPlayIndex = -1
    private var mPlayState = MusicConstants.MPS_NO_FILE // 默认没有音频文件播放
    private var mPendingProgress = 0
    private var mCurMusicId = -1L
    private var mCurMusic: MusicBean? = null
    private var mPlaying = false
    private val mAudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private val mMediaPlayer = MediaPlayerProxy().apply {
        setNeedCacheAudio(true)
        setWakeMode(context, PowerManager.PARTIAL_WAKE_LOCK) // 播放音频的时候加锁，防止CPU休眠
        val attrs = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        setAudioAttributes(attrs)
        setOnCompletionListener(this@MusicControl)
    }
    private var isInit = false
    private var callback: IMusicCommunicate? = null

    fun resister(callback: IMusicCommunicate) {
        this.callback = callback
        this.callback?.onPlayStateChanged(mPlayState)
        this.callback?.onCurMusicChanged(mCurMusic)
        this.callback?.onCurPlayIndexChanged(mCurPlayIndex)
        this.callback?.onPlayListChanged(mPlaylist)
        this.callback?.onPlayModeChanged(mPlayMode)
    }

    fun unResister() {
        callback = null
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            refreshPlaylist(mDao.queryPlaySongList())
            context.getSharedPreferences("data", Context.MODE_PRIVATE).apply {
                setCurMusicId(getLong("current_music_id", -1))
                val editor = this.edit()
                editor.putLong("current_music_id", -1)
                editor.apply()
                if (mCurMusicId != -1L) {
                    prepare(seekPosById(mPlaylist, mCurMusicId))
                } else {
                    if (mPlaylist.isNotEmpty()) {
                        prepare(0)
                    }
                }
            }
            isInit = true
        }
    }

    /**
     * 保存当前播放歌曲以及进度。
     */
    fun saveLatest() {
        Log.d(TAG, "saveLatest")
        // 更新本地缓存歌曲
        val sp = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putLong("current_music_id", mCurMusicId)
        editor.apply()
        stop()

        GlobalScope.launch(Dispatchers.IO) {
            mDao.deleteAll()
            mDao.add2PlaySongList(*mPlaylist.toTypedArray())
        }
    }

    /**
     * 设置播放。
     *
     * @param playState
     */
    private fun setPlaying(playState: Int) {
        Log.d(TAG, "setPlaying: $playState")
        mPlaying = when (playState) {
            MusicConstants.MPS_PLAYING -> true
            else -> false
        }
    }

    /**
     * 设置当前播放的歌曲。
     *
     * @param music
     * @return
     */
    fun loadCurMusic(music: MusicBean) {
        Log.d(TAG, "loadCurMusic: $music")
        playById(music.id)
    }

    /**
     * 缓冲准备。
     *
     * @param pos
     * @return
     */
    private fun prepare(pos: Int): Boolean {
        mPendingProgress = 0
        mMediaPlayer.reset()
        val path: String = mPlaylist[pos].url
        if (path.isNotEmpty()) {
            try {
                Log.d(TAG, "pos : $pos prepare: $path")
                setCurIndex(pos)
                setCurMusic(mPlaylist[mCurPlayIndex])
                setCurMusicId(mCurMusic!!.id)
                setCurPlayState(MusicConstants.MPS_PREPARE)
                mMediaPlayer.setDataSource(path)
                mMediaPlayer.prepare()
            } catch (e: Exception) {
                try {
                    mMediaPlayer.setDataSource(MusicConstants.ON_403_PLAY_URL + "${mPlaylist[pos].id}.mp3")
                    mMediaPlayer.prepare()
                } catch (e: Exception) {
                    setCurPlayState(MusicConstants.MPS_INVALID)
                    if (pos < mPlaylist.size - 1) {
                        playById(mPlaylist[pos + 1].id)
                    }
                    return false
                }
            }
        } else {
            showToast("歌曲路径为空")
        }
        sendMusicPlayBroadcast()
        return true
    }

    /**
     * 根据歌曲的id来播放。
     *
     * @param id
     * @return
     */
    private fun playById(id: Long): Boolean {
        Log.d(TAG, "playById: $id")
        return if (requestFocus()) {
            val position = seekPosById(mPlaylist, id)
            if (mCurMusicId == id) {
                if (!mMediaPlayer.isPlaying) {
                    mMediaPlayer.start()
                    setCurPlayState(MusicConstants.MPS_PLAYING)
                    sendMusicPlayBroadcast()
                } else {
                    pause()
                }
                return true
            }
            if (!prepare(position)) {
                false
            } else replay()
        } else {
            false
        }
    }

    /**
     * 停止播放歌曲。
     */
    fun stop() {
        Log.d(TAG, "stop")
        if (mMediaPlayer.isPlaying) {
            mMediaPlayer.stop()
        }
    }

    private var audioFocusListener: OnAudioFocusChangeListener =
        object : OnAudioFocusChangeListener {
            override fun onAudioFocusChange(focusChange: Int) {
                when (focusChange) {
                    AudioManager.AUDIOFOCUS_LOSS_TRANSIENT -> {
                        // Pause playback
                        Log.d(TAG, "AUDIOFOCUS_LOSS_TRANSIENT")
                        pause()
                    }

                    AudioManager.AUDIOFOCUS_GAIN -> {
                        // Resume playback
                        Log.d(TAG, "AUDIOFOCUS_GAIN")
                        replay()
                    }

                    AudioManager.AUDIOFOCUS_LOSS -> {
                        Log.d(TAG, "AUDIOFOCUS_LOSS")
                        mAudioManager.abandonAudioFocus(this)
                        pause()
                    }
                }
            }
        }


    /**
     * 请求音频焦点。
     *
     * @return
     */
    private fun requestFocus(): Boolean {
        Log.d(TAG, "requestFocus")
        // Request audio focus for playback
        val result = mAudioManager.requestAudioFocus(
            audioFocusListener,  // Use the music stream.
            AudioManager.STREAM_MUSIC,  // Request permanent focus.
            AudioManager.AUDIOFOCUS_GAIN
        )
        return result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED
    }

    /**
     * 根据位置播放列表中的歌曲。
     *
     * @param pos
     * @return
     */
    fun play(pos: Int): Boolean {
        Log.d(TAG, "play: $pos")
        if (pos == -1 && pos < mPlaylist.size - 1) return false
        return playById(mPlaylist[pos].id)
    }

    /**
     * 获取当前播放歌曲的索引。
     *
     * @return
     */
    fun getCurPlayIndex(): Int {
        return mCurPlayIndex
    }

    /**
     * 保证索引在播放列表索引范围内。
     *
     * @param index
     * @return
     */
    private fun reviseIndex(index: Int): Int {
        Log.d(TAG, "reviseIndex: $index")
        var index1 = index
        if (index < 0) {
            index1 = mPlaylist.size - 1
        }
        if (index >= mPlaylist.size) {
            index1 = 0
        }
        return index1
    }

    /**
     * 获取当前歌曲播放的位置。
     *
     * @return
     */
    fun position(): Int {
        return if (mPlayState == MusicConstants.MPS_PLAYING || mPlayState == MusicConstants.MPS_PAUSE) {
            mMediaPlayer.currentPosition
        } else 0
    }

    /**
     * 获取当前歌曲的时长。
     *
     * @return 毫秒
     */
    fun duration(): Int {
        return if (mPlayState == MusicConstants.MPS_INVALID || mPlayState == MusicConstants.MPS_NO_FILE) {
            0
        } else mMediaPlayer.duration
    }

    /**
     * 跳到指定进度播放歌曲。
     *
     * @param progress
     * @return
     */
    fun seekTo(progress: Int): Boolean {
        Log.d(TAG, "seekTo: $progress")
        if (mPlayState == MusicConstants.MPS_INVALID || mPlayState == MusicConstants.MPS_NO_FILE) {
            return false
        }
        val pro = reviseSeekValue(progress)
        mMediaPlayer.seekTo(pro)
        return true
    }

    /**
     * 设置歌曲的播放模式。
     *
     * @param mode
     */
    fun setPlayMode(mode: Int) {
        LogUtil.d(TAG, "onPlayModeChanged: $mode")
        mPlayMode = mode
        callback?.onPlayModeChanged(mPlayMode)
    }

    /**
     * 清空播放列表。
     */
    fun clear() {
        mMediaPlayer.stop()
        mMediaPlayer.reset()
    }

    /**
     * 在线缓冲进度。
     *
     * @return
     */
    fun pendingProgress(): Int {
        return mPendingProgress
    }

    interface OnConnectCompletionListener {
        fun onConnectCompletion(service: IMusicService?)
    }

    /**
     * 检测当前歌曲是否正在播放中。
     *
     * @return
     */
    fun isPlaying(): Boolean {
        return mPlaying
    }

    /**
     * 暂停当前歌曲的播放。
     *
     * @return
     */
    fun pause(): Boolean {
        Log.d(TAG, "pause")
        if (mPlayState != MusicConstants.MPS_PLAYING) {
            return false
        }
        mMediaPlayer.pause()
        setCurPlayState(MusicConstants.MPS_PAUSE)
        sendMusicPlayBroadcast()
        return true
    }

    /**
     * 播放上一首。
     *
     * @return
     */
    fun prev(): Boolean {
        Log.d(TAG, "prev")
        return when (mPlayMode) {
            MusicConstants.PLAY_MODE_LOOP -> moveLeft()
            MusicConstants.PLAY_MODE_ORDER -> if (mCurPlayIndex != 0) {
                moveLeft()
            } else {
                prepare(mCurPlayIndex)
            }

            MusicConstants.PLAY_MODE_RANDOM -> {
                val index = getRandomIndex()
                setCurIndex(if (index != -1) index else 0)
                if (prepare(mCurPlayIndex)) {
                    replay()
                } else false
            }

            MusicConstants.PLAY_MODE_SINGLE -> {
                prepare(mCurPlayIndex)
                replay()
            }

            else -> false
        }
    }

    /**
     * 播放下一首。
     *
     * @return
     */
    operator fun next(): Boolean {
        Log.d(TAG, "next $mPlayMode")
        return when (mPlayMode) {
            // 列表循环
            MusicConstants.PLAY_MODE_LOOP -> moveRight()

            // 顺序播放
            MusicConstants.PLAY_MODE_ORDER -> if (mCurPlayIndex != mPlaylist.size - 1) {
                moveRight()
            } else {
                prepare(mCurPlayIndex)
            }

            // 随机播放
            MusicConstants.PLAY_MODE_RANDOM -> {
                val index = getRandomIndex()
                setCurIndex(if (index != -1) index else 0)
                if (prepare(mCurPlayIndex)) {
                    replay()
                } else false
            }

            // 单曲循环
            MusicConstants.PLAY_MODE_SINGLE -> {
                prepare(mCurPlayIndex)
                replay()
            }

            else -> false
        }
    }

    override fun onCompletion(mp: MediaPlayer) {
        if (isInit) next()
    }

    /**
     * 随机播放模式下获取播放索引。
     *
     * @return
     */
    private fun getRandomIndex(): Int {
        val size = mPlaylist.size
        return if (size == 0) {
            -1
        } else abs(mRandom.nextInt() % size)
    }

    /**
     * 修正缓冲播放的进度在合理的范围内。
     *
     * @param progress
     * @return
     */
    private fun reviseSeekValue(progress: Int): Int {
        var progress1 = progress
        if (progress < 0) {
            progress1 = 0
        } else if (progress > duration()) {
            progress1 = duration()
        }
        return progress1
    }

    /**
     * 刷新播放列表的歌曲。
     *
     * @param playlist
     */
    fun refreshPlaylist(playlist: List<MusicBean>) {
        Log.d(TAG, "onPlayListChanged : $playlist")
        mPlaylist.clear()
        mPlaylist.addAll(playlist)
        callback?.onPlayListChanged(mPlaylist)
        mPlaylist.forEachIndexed { index, item ->
            if (mCurMusicId == item.id) {
                setCurIndex(index)
                setCurMusic(item)
                return@forEachIndexed
            }
        }
        if (mPlaylist.size == 0) {
            setCurPlayState(MusicConstants.MPS_NO_FILE)
            setCurIndex(-1)
            return
        }
    }

    fun addMusic(music: MusicBean) {
        Log.d(TAG, "addMusic : $music")
        mPlaylist.add(music)
        callback?.onPlayListChanged(mPlaylist)
    }

    /**
     * 删除指定歌曲
     * @param position
     */
    fun removeMusic(position: Int) {
        Log.d(TAG, "removeMusic : $position")
        if (position > mPlaylist.size - 1) return
        val id = mPlaylist[position].id
        GlobalScope.launch(Dispatchers.IO) {
            mDao.deleteMusic(id)
        }
        mPlaylist.removeAt(position)
        if (mCurPlayIndex == position) {
            next()
        } else if (mCurPlayIndex > position) {
            mCurPlayIndex--
        }
        callback?.onPlayListChanged(mPlaylist)
    }

    /**
     * 在当前播放模式下播放上一首。
     *
     * @return
     */
    private fun moveLeft(): Boolean {
        Log.d(TAG, "moveLeft")
        if (mPlayState == MusicConstants.MPS_NO_FILE) {
            return false
        }
        mCurPlayIndex--
        setCurIndex(reviseIndex(mCurPlayIndex))
        return if (!prepare(mCurPlayIndex)) {
            false
        } else replay()
    }

    /**
     * 在当前播放模式下播放下一首。
     *
     * @return
     */
    private fun moveRight(): Boolean {
        Log.d(TAG, "moveRight")
        if (mPlayState == MusicConstants.MPS_NO_FILE) {
            return false
        }
        mCurPlayIndex++
        setCurIndex(reviseIndex(mCurPlayIndex))
        return if (!prepare(mCurPlayIndex)) {
            false
        } else replay()
    }

    /**
     * 重头开始播放当前歌曲。
     *
     * @return
     */
    fun replay(): Boolean {
        Log.d(TAG, "replay")
        return if (requestFocus()) {
            if (mPlayState == MusicConstants.MPS_INVALID || mPlayState == MusicConstants.MPS_NO_FILE) {
                return false
            }
            mMediaPlayer.start()
            setCurPlayState(MusicConstants.MPS_PLAYING)
            sendMusicPlayBroadcast()
            true
        } else {
            false
        }
    }

    /**
     * 发送音乐播放/暂停的广播。
     */
    private fun sendMusicPlayBroadcast() {
        setPlaying(mPlayState)
//        val intent = Intent(ACTION_PLAY)
//        intent.putExtra("play_state", mPlayState)
//        mContext.sendBroadcast(intent)
//        Apollo.emit(ApolloEvent.REFRESH_LOCAL_NUMS)
    }

    /**
     * 退出媒体播放。
     */
    fun exit() {
        Log.d(TAG, "exit")
        mMediaPlayer.stop()
        mMediaPlayer.release()
        setCurIndex(-1)
        mPlaylist.clear()
    }

    /**
     * 根据歌曲的ID，寻找出歌曲在当前播放列表中的位置。
     *
     * @param playlist
     * @param id
     * @return
     */
    private fun seekPosById(playlist: List<MusicBean>, id: Long): Int {
        Log.d(TAG, "seekPosById: $id")
        if (id == -1L) {
            return -1
        }
        var result = -1
        for (i in playlist.indices) {
            if (id == playlist[i].id) {
                result = i
                break
            }
        }
        return result
    }

    private fun setCurIndex(index: Int) {
        LogUtil.d(TAG, "onCurPlayIndexChanged: $index")
        mCurPlayIndex = index
        callback?.onCurPlayIndexChanged(index)
    }

    private fun setCurPlayState(state: Int) {
        LogUtil.d(TAG, "onPlayStateChanged: $state")
        mPlayState = state
        callback?.onPlayStateChanged(state)
    }

    private fun setCurMusicId(id: Long) {
        mCurMusicId = id
    }

    private fun setCurMusic(music: MusicBean) {
        LogUtil.d(TAG, "onCurMusicChanged: $music")
        mCurMusic = music
        callback?.onCurMusicChanged(music)
    }

}