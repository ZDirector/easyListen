package com.example.video.repository

import com.example.video.network.VideoNetwork

object VideoRepository {

    suspend fun getMVDetail(mvId: String) = VideoNetwork.getMVDetail(mvId)

    suspend fun getMVUrl(id: String) = VideoNetwork.getMVUrl(id)

    suspend fun getMVInfo(mvId: String) = VideoNetwork.getMVInfo(mvId)
}