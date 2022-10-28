package com.example.homepage.network

import com.example.homepage.music.service.BannerService
import com.example.homepage.music.service.RankListService
import com.example.homepage.music.service.RecoListService
import com.example.homepage.playSquare.service.SquareService
import retrofit2.create

object MyNetWork {
    private val bannerService = ServiceCreator.retrofit.create<BannerService>()
    private val recommendedPlaylistService = ServiceCreator.retrofit.create<RecoListService>()
    private val rankListService = ServiceCreator.retrofit.create<RankListService>()
    suspend fun getBanner() =
        bannerService.getBanner()

    suspend fun getRecommendedList() = recommendedPlaylistService.getRecoList()

    suspend fun getRankResponse() = rankListService.getRankListResponse()


    private val squareService = ServiceCreator.retrofit.create<SquareService>()

    suspend fun getTags() = squareService.getTags()

    suspend fun getSquareList(
        offset: Int,
        limit: Int,
        cat: String
    ) = squareService.getHighList(offset, limit, cat)
}