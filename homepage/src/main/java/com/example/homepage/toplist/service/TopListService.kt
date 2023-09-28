package com.example.homepage.toplist.service

import com.example.homepage.toplist.bean.TopListResponse
import com.example.homepage.toplist.bean.TrackResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TopListService {
    @GET("/toplist/detail")
    suspend fun getTopListDetail(): TopListResponse


    @GET("/playlist/track/all")
    suspend fun getLimitTopListSong(
        @Query("id") id: Long,
        @Query("limit") limit: Int?
    ):TrackResponse
}