package com.example.video.network

import com.example.common.network.RetrofitClient
import com.example.video.service.VideoService

object VideoNetwork {

    private val videoService = RetrofitClient.retrofit.create(VideoService::class.java)

    suspend fun getMVDetail(mvId: String) = videoService.getMVDetail(mvId)

    suspend fun getMVUrl(id: String) = videoService.getMVUrl(id)

    suspend fun getMVInfo(mvId: String) = videoService.getMVInfo(mvId)

}