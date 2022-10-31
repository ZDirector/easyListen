package com.example.music_comment.network

import com.example.common.network.RetrofitClient
import com.example.music_comment.service.MusicCommentService

object MusicCommentNetwork {

    private val musicCommentService = RetrofitClient.retrofit.create(MusicCommentService::class.java)

    suspend fun getMusicCommentList(id : Long,sortType : Int,pageNo : Int,cursor : Long)
    = musicCommentService.getMusicCommentList(id = id, sortType = sortType, pageNo = pageNo, cursor = cursor)

    suspend fun getFloorCommentList(parentCommentId : Long,id : Long,time : Long)
    = musicCommentService.getFloorCommentList(parentCommentId = parentCommentId, id = id, time = time)

}