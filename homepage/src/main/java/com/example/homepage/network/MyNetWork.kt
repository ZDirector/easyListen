package com.example.homepage.network

import com.example.homepage.music.service.BannerService
import com.example.homepage.music.service.RecoListService
import retrofit2.create

object MyNetWork {
    private val bannerService = ServiceCreator.retrofit.create<BannerService>()
    private val recommendedPlaylistService = ServiceCreator.retrofit.create<RecoListService>()
    suspend fun getBanner() =
        bannerService.getBanner()

    suspend fun getRecommendedList() = recommendedPlaylistService.getRecoList()
}