package com.example.video.network

import com.example.common.network.RetrofitClient
import com.example.video.service.VideoService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object VideoNetwork {

    private val videoService = RetrofitClient.retrofit.create(VideoService::class.java)

    suspend fun getMVDetail(mvId: String) = withContext(Dispatchers.IO) {
        videoService.getMVDetail(mvId)
    }

    suspend fun getMVUrl(id: String) = withContext(Dispatchers.IO) {
        videoService.getMVUrl(id)
    }

    suspend fun getMVInfo(mvId: String) = withContext(Dispatchers.IO) {
        videoService.getMVInfo(mvId)
    }

}