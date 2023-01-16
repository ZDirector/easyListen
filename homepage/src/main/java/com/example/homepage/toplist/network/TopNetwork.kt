package com.example.homepage.toplist.network

import com.example.homepage.network.ServiceCreator
import com.example.homepage.toplist.service.TopListService
import retrofit2.create

object TopNetwork {
    private val topListService = ServiceCreator.retrofit.create<TopListService>()
    suspend fun getTopDetails() = topListService.getTopListDetail()
    suspend fun getTracks(id: Long, limit: Int) = topListService.getLimitTopListSong(id, limit)

}