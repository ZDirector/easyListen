package com.example.music_comment.repository

import com.example.music_comment.network.MusicCommentNetwork

object MusicCommentRepository {

    suspend fun getMusicCommentList(id : Int,sortType : Int,pageNo : Int)
    = MusicCommentNetwork.getMusicCommentList(id = id, sortType = sortType, pageNo = pageNo)

}