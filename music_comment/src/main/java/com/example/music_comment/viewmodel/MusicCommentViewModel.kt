package com.example.music_comment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.musicComment.Comment
import com.example.common.network.collectNetwork
import com.example.music_comment.repository.MusicCommentRepository
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MusicCommentViewModel : BaseViewModel() {

    private val _musicCommentCount : MutableLiveData<Int> = MutableLiveData()
    val mMusicCommentCount : LiveData<Int> get() = _musicCommentCount
    val sortType : MutableLiveData<Int> = MutableLiveData(2)
    var isFinishLoadMore : MutableLiveData<Boolean> = MutableLiveData(true)

    var songId : Int = 0

    fun getMusicCommentCount(id : Int,sortType : Int){
        viewModelScope.launch {
            flow {
                emit(MusicCommentRepository.getMusicCommentList(id = id, sortType = sortType, pageNo = 1))
            }.collectNetwork {
                success { response ->
                    _musicCommentCount.postValue(response.data.totalCount)
                }
                failure {
                    _musicCommentCount.postValue(0)
                }
                toastError()
            }
        }
    }

}