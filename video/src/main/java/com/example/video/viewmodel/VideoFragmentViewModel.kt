package com.example.video.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.videoBean.VideoData
import com.example.common.utils.MyApplication
import com.example.video.repository.VideoRepository
import com.google.android.exoplayer2.ExoPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VideoFragmentViewModel : BaseViewModel() {

    private val _videoData : MutableLiveData<VideoData> = MutableLiveData()
    val videoData : LiveData<VideoData> get() = _videoData

    var mVideoData : VideoData? = null
    var isMore = false

    fun getVideoData(id : Long){
        viewModelScope.launch {
            val mvDetail = VideoRepository.getMVDetail(id.toString())
            val mvInfo = VideoRepository.getMVInfo(id.toString())
            val mvUrl = VideoRepository.getMVUrl(id.toString())
            val videoData = VideoData(
                id,
                mvDetail.data.name,
                mvDetail.data.desc,
                mvDetail.data.artistName,
                mvDetail.data.cover,
                mvInfo.shareCount,
                mvInfo.commentCount,
                mvDetail.data.duration,
                mvDetail.data.artists,
                mvUrl.data.url,
                mvInfo.liked,
                mvInfo.likedCount,
                mvDetail.data.publishTime)
            mVideoData = videoData
            _videoData.postValue(videoData)
        }
    }

}