package com.example.playing.viewModel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.IMusicCommunicate
import com.example.common.IMusicService
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.doSuccess
import com.example.common.bean.searchBean.MusicBean
import com.example.common.constants.HttpConstants
import com.example.common.db.EasyListenDB
import com.example.common.music.MusicConstants
import com.example.common.music.MusicControl
import com.example.common.utils.LogUtil
import com.example.common.utils.MyApplication
import com.example.common.utils.showToast
import com.example.playing.R
import com.example.playing.data.LyricLine
import com.example.playing.data.MusicRepository
import com.example.playing.data.MusicUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PlayViewModel : BaseViewModel() {

    companion object {
        private const val TAG = "PlayViewModel"
    }

    private val mediaManager = MyApplication.instance.get()?.mediaManager
    private val repository = MusicRepository()
    private val mDao = EasyListenDB.instance.playSongListDao()
    private val listener = object : IMusicCommunicate.Stub() {

        override fun onPlayStateChanged(playStatus: Int) {
            LogUtil.d(TAG, "onPlayStateChanged: $playStatus")
            isPlaying.postValue(playStatus == MusicConstants.MPS_PLAYING)
        }

        override fun onPlayListChanged(playlist: MutableList<MusicBean>?) {
            LogUtil.d(TAG, "onPlayListChanged: $playlist")
            musicList.postValue(playlist)
        }

        override fun onCurMusicChanged(music: MusicBean?) {
            LogUtil.d(TAG, "onCurMusicChanged: $music")
            currentMusic.postValue(music)
        }

        override fun onPlayModeChanged(mode: Int) {
            LogUtil.d(TAG, "onPlayModeChanged: $mode")
            playMode.postValue(mode)
        }

        override fun onCurPlayIndexChanged(index: Int) {
            LogUtil.d(TAG, "onCurPlayIndexChanged: $index")
            currentIndex.postValue(index)
        }
    }

    val currentMusic = MutableLiveData(MusicBean())
    val currentProgress = MutableLiveData(0)
    val totalProgress = MutableLiveData(0)
    val isPlaying = MutableLiveData<Boolean>()
    val playMode = MutableLiveData<Int>()
    val musicList = MutableLiveData<MutableList<MusicBean>>()
    val currentIndex = MutableLiveData<Int>()
    val musicLyricList = MutableLiveData<MutableList<LyricLine>>()

    init {
        mediaManager?.setOnCompletionListener(object : MusicControl.OnConnectCompletionListener {
            override fun onConnectCompletion(service: IMusicService?) {
                mediaManager.resister(listener)
                sync()
            }
        })
        mediaManager?.connectService()
    }

    fun setCurMusic(music: MusicBean) {
        mediaManager?.loadCurMusic(music)
    }

    fun addMusic(music: MusicBean) {
        mediaManager?.let {
            val musicList = musicList.value ?: mutableListOf()
            musicList.forEach { musicBean ->
                if (musicBean.id == music.id) {
                    return@addMusic
                }
            }
            it.addMusic(music)
            viewModelScope.launch(Dispatchers.IO) {
                mDao.add2PlaySongList(music)
            }
        }
    }

    private fun refresh() {
        mediaManager?.let {
            totalProgress.postValue(mediaManager.duration())
            currentProgress.postValue(mediaManager.position())
        }
    }

    fun getMusicUrl(vararg ids: Long, callback: (List<MusicUrl>) -> Unit) {
        viewModelScope.launch {
            val result = repository.getMusicUrl(ids.toList())
            result.doSuccess {
                callback(result.data)
            }
        }
    }

    fun getLyric(id: Long) {
        viewModelScope.launch {
            val result = repository.getLyric(id)
            if (result.code == HttpConstants.SUCCESS) {
                musicLyricList.postValue(result.lrc.parseLyrics().toMutableList())
            } else {
                showToast(R.string.get_lyric_error)
            }
        }
    }

    private fun sync() {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                refresh()
                delay(1000)
            }
        }
    }

    fun play() {
        isPlaying.value = isPlaying.value != true
        mediaManager?.play(currentIndex.value ?: 0)
    }

    fun next() {
        mediaManager?.next()
    }

    fun previous() {
        mediaManager?.prev()
    }

    fun seekTo(progress: Int) {
        mediaManager?.seekTo(progress)
    }

    fun changePlayMode() {
        val mode = when (playMode.value) {
            MusicConstants.PLAY_MODE_LOOP -> {
                playMode.value = MusicConstants.PLAY_MODE_RANDOM
                MusicConstants.PLAY_MODE_RANDOM
            }

            MusicConstants.PLAY_MODE_RANDOM -> {
                playMode.value = MusicConstants.PLAY_MODE_SINGLE
                MusicConstants.PLAY_MODE_SINGLE
            }

            MusicConstants.PLAY_MODE_SINGLE -> {
                playMode.value = MusicConstants.PLAY_MODE_ORDER
                MusicConstants.PLAY_MODE_ORDER
            }

            MusicConstants.PLAY_MODE_ORDER -> {
                playMode.value = MusicConstants.PLAY_MODE_LOOP
                MusicConstants.PLAY_MODE_LOOP
            }

            else -> {
                playMode.value = MusicConstants.PLAY_MODE_LOOP
                MusicConstants.PLAY_MODE_LOOP
            }
        }
        mediaManager?.setPlayMode(mode)
    }

    fun removeMusic(position: Int) {
        mediaManager?.removeMusic(position)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        mediaManager?.stop()
        mediaManager?.disconnectService()
        mediaManager?.unresister()
        super.onDestroy(owner)
    }
}