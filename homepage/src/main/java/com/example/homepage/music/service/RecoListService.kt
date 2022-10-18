package com.example.homepage.music.service

import com.example.homepage.music.bean.RecommendedPlaylistResponse
import retrofit2.http.GET

interface RecoListService {
    @GET("personalized?limit=30")
    suspend fun getRecoList():RecommendedPlaylistResponse
}