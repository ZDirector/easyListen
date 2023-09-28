package com.example.homepage.network

import com.example.common.network.RetrofitClient
import com.example.homepage.music.service.BannerService
import com.example.homepage.music.service.RankListService
import com.example.homepage.music.service.RecoListService
import com.example.homepage.playSquare.service.SquareService
import retrofit2.create

object MyNetWork {
    private val bannerService = RetrofitClient.retrofit.create<BannerService>()
    private val recommendedPlaylistService = RetrofitClient.retrofit.create<RecoListService>()
    private val rankListService = RetrofitClient.retrofit.create<RankListService>()
    suspend fun getBanner() =
        bannerService.getBanner()

    suspend fun getRecommendedList() = recommendedPlaylistService.getRecoList()

    suspend fun getRankResponse() = rankListService.getRankListResponse()


    private val squareService = RetrofitClient.retrofit.create<SquareService>()

    suspend fun getTags() = squareService.getTags()

    suspend fun getSquareList(
        offset: Int,
        limit: Int,
        cat: String
    ) = squareService.getHighList(offset, limit, cat)


    suspend fun getSongs(
        id :Long,
        limit: Int,
        offset: Int
    ) = squareService.getListSongs(id, limit, offset)





}