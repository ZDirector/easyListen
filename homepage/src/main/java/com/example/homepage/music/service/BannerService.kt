package com.example.homepage.music.service

import com.example.homepage.music.bean.BannerResponse
import retrofit2.http.GET

interface BannerService {
    @GET("banner?type=1")
    suspend fun getBanner(): BannerResponse
}