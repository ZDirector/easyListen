package com.example.music_comment.viewmodel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.musicComment.Comment
import com.example.common.network.collectNetwork
import com.example.common.utils.LogUtil
import com.example.music_comment.repository.MusicCommentRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class CommentFragmentViewModel : BaseViewModel() {

    private val musicCommentList = mutableListOf<Comment>()
    private val _musicCommentList : MutableLiveData<List<Comment>> = MutableLiveData()
    val mMusicCommentList : LiveData<List<Comment>> get() = _musicCommentList

    var pageNo : Int = 1
    var songId : Int = 0
    var sortType : Int = 2

    fun getMusicCommentList(){
        viewModelScope.launch {
            flow {
                emit(MusicCommentRepository.getMusicCommentList(songId, sortType = sortType, pageNo = pageNo))
            }.collectNetwork {
                success { response ->
                    if (pageNo == 1) musicCommentList.clear()
                    musicCommentList.addAll(response.data.comments)
                    _musicCommentList.postValue(musicCommentList)
                }
                failure {
                    _musicCommentList.postValue(null)
                }
                toastError()
            }
        }
    }

}