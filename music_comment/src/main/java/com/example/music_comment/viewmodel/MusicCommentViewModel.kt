package com.example.music_comment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.musicComment.Comment
import com.example.common.bean.musicComment.MusicCommentData
import com.example.common.network.collectNetwork
import com.example.common.utils.LogUtil
import com.example.music_comment.repository.MusicCommentRepository
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MusicCommentViewModel : BaseViewModel() {

    private val _musicCommentCount : MutableLiveData<Int> = MutableLiveData()
    val mMusicCommentCount : LiveData<Int> get() = _musicCommentCount

    private val musicCommentList = mutableListOf<Comment>()
    private val _musicCommentList : MutableLiveData<List<Comment>> = MutableLiveData()
    val mMusicCommentList : LiveData<List<Comment>> get() = _musicCommentList

    private val _currentFloorCommentList = MutableLiveData<MusicCommentData>()
    val mCurrentFloorCommentList : LiveData<MusicCommentData> get() = _currentFloorCommentList

    var songId : Long = 0
    var pageNo : Int = 1
    var sortType : Int = 2
    var commentTime = 0L
    var floorTime = 0L

    fun getMusicCommentList(){
        viewModelScope.launch {
            flow {
                emit(MusicCommentRepository.getMusicCommentList(songId, sortType = sortType, pageNo = pageNo,commentTime))
            }.collectNetwork {
                success {
                    _musicCommentCount.postValue(it.data.totalCount)
                    if (pageNo == 1) musicCommentList.clear()
                    if (it.data.comments.isNotEmpty()){
                        if (sortType == 3) commentTime = it.data.comments.last().time
                        musicCommentList.addAll(it.data.comments)
                        _musicCommentList.postValue(musicCommentList)
                    }else _musicCommentList.postValue(null)
                }
                failure {
                    _musicCommentList.postValue(null)
                }
                toastError()
            }
        }
    }

    fun getFloorCommentList(parentCommentId : Long){
        viewModelScope.launch {
            flow {
                emit(MusicCommentRepository.getFloorCommentList(parentCommentId, songId, floorTime))
            }.collectNetwork {
                success { response ->
                    if (response.data.comments.isNotEmpty()){
                        floorTime = response.data.comments.last().time
                        _currentFloorCommentList.postValue(response.data)
                    }else _currentFloorCommentList.postValue(null)
                }
                failure {
                    _currentFloorCommentList.postValue(null)
                }
                toastError()
            }
        }
    }

}