package com.example.homepage.music.service

import com.example.homepage.music.bean.RankListResponse
import retrofit2.http.GET

interface RankListService {
    @GET("/toplist/detail")
    suspend fun getRankListResponse():RankListResponse
}