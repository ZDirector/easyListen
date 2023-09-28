package com.example.music_comment.repository

import com.example.music_comment.network.MusicCommentNetwork

object MusicCommentRepository {

    suspend fun getMusicCommentList(id : Long,sortType : Int,pageNo : Int,cursor : Long)
    = MusicCommentNetwork.getMusicCommentList(id = id, sortType = sortType, pageNo = pageNo, cursor = cursor)

    suspend fun getFloorCommentList(parentCommentId : Long,id : Long,time : Long)
            = MusicCommentNetwork.getFloorCommentList(parentCommentId, id, time)
}