package com.example.music_comment.network

import com.example.common.network.RetrofitClient
import com.example.music_comment.service.MusicCommentService

object MusicCommentNetwork {

    private val musicCommentService = RetrofitClient.retrofit.create(MusicCommentService::class.java)

    suspend fun getMusicCommentList(id : Int,sortType : Int,pageNo : Int) = musicCommentService.getMusicCommentList(id = id, sortType = sortType, pageNo = pageNo)

}