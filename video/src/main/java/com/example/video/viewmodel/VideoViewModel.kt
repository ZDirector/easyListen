package com.example.video.viewmodel

import com.example.common.baseui.BaseViewModel
import com.example.common.bean.videoBean.VideoData
import com.example.common.utils.LogUtil
import com.example.common.utils.MyApplication
import com.example.video.util.VideoLoadState
import com.google.android.exoplayer2.ExoPlayer
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow

class VideoViewModel : BaseViewModel(){

    val videoIdList : MutableList<Int> = mutableListOf()

    var currentExoPlayer : ExoPlayer? = null
    var currentPage : Int = 0
    var currentVideoData : VideoData? = null

    val proxy = MyApplication.getProxy()

    private val _videoLoadState: MutableStateFlow<VideoLoadState> = MutableStateFlow(VideoLoadState.Loading)
    val videoLoadState: StateFlow<VideoLoadState> = _videoLoadState

    val progressFlow = flow {
        while (true){
            _videoLoadState.value.run {
                // 只有在状态为正在播放才更新进度
                if (this is VideoLoadState.Playing) {
                    LogUtil.d("VideoViewModel","progressFlow")
                    emit(currentExoPlayer!!.currentPosition)
                }
            }
            delay(1000)
        }
    }.conflate()

    fun onPlayerError(errorCode : Int){
        _videoLoadState.value = VideoLoadState.Error(errorCode = errorCode)
        LogUtil.d("VideoViewModel","PlayerError")
    }

    fun onPlayerLoading(){
        _videoLoadState.value = VideoLoadState.Loading
        LogUtil.d("VideoViewModel","PlayerLoading")
    }

    fun onPlayerReady(){
        _videoLoadState.value = VideoLoadState.Playing
        LogUtil.d("VideoViewModel","PlayerReady")
    }

    fun onPlayerPause(){
        _videoLoadState.value = VideoLoadState.Pause
        LogUtil.d("VideoViewModel","PlayerPause")
    }

}