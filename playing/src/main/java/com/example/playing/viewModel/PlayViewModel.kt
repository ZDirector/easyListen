package com.example.playing.viewModel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.doSuccess
import com.example.common.bean.searchBean.MusicBean
import com.example.common.db.EasyListenDB
import com.example.common.music.MusicConstants
import com.example.common.utils.LogUtil
import com.example.common.utils.MyApplication
import com.example.playing.data.MusicRepository
import com.example.playing.data.MusicUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PlayViewModel : BaseViewModel() {

    private val mediaManager = MyApplication.instance.get()?.mediaManager
    private val repository = MusicRepository()
    private val mDao = EasyListenDB.instance.playSongListDao()

    val currentMusic = MutableLiveData(MusicBean())
    val currentProgress = MutableLiveData(0)
    val totalProgress = MutableLiveData(0)
    val isPlaying = MutableLiveData<Boolean>()
    val playMode = MutableLiveData<Int>()
    val musicList = MutableLiveData<MutableList<MusicBean>>()
    val currentIndex = MutableLiveData<Int>()

    init {
        sync()
    }

    fun setCurMusic(music: MusicBean) {
        mediaManager?.curMusic = music
    }

    fun addMusic(music: MusicBean) {
        mediaManager?.let {
            val musicList = it.playlist
            musicList.forEach { musicBean ->
                if (musicBean.id == music.id) {
                    setCurMusic(musicBean)
                    return@addMusic
                }
            }
            musicList.add(music)
            it.refreshPlaylist(musicList)
            viewModelScope.launch(Dispatchers.IO) {
                mDao.add2PlaySongList(music)
            }
        }
    }

    private fun refresh() {
        mediaManager?.let {
            currentMusic.postValue(mediaManager.curMusic)
            totalProgress.postValue(mediaManager.duration())
            currentProgress.postValue(mediaManager.position())
            isPlaying.postValue(mediaManager.playState == MusicConstants.MPS_PLAYING)
            playMode.postValue(mediaManager.playMode)
            musicList.postValue(mediaManager.playlist)
            currentIndex.postValue(mediaManager.curIndex())
            LogUtil.d("PlayViewModel","refresh")
        }
    }

    fun getMusicUrl(vararg ids: Long, callback: (List<MusicUrl>) -> Unit) {
        viewModelScope.launch {
            val result = repository.getMusicUrl(ids.toList())
            result.doSuccess {
                musicList.value?.let { musicList ->
                    musicList.forEach { music ->
                        result.data.forEach { musicUrl ->
                            if (music.id == musicUrl.id) {
                                music.url = musicUrl.url
                            }
                        }
                    }
                }
                callback(result.data)
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

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        mediaManager?.disconnectService()
    }
}