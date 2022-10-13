package com.example.homepage.network

import com.example.homepage.music.service.BannerService
import retrofit2.create

object MyNetWork {
    private val bannerService = ServiceCreator.retrofit.create<BannerService>()

    suspend fun getBanner() =
        bannerService.getBanner()
}