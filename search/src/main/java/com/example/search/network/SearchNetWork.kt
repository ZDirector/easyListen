package com.example.search.network

import com.example.common.network.RetrofitClient
import com.example.search.service.SearchService

object SearchNetWork {

    private val searchService = RetrofitClient.retrofit.create(SearchService::class.java)

    suspend fun getSearchSuggest(keyWords : String) = searchService.getSearchSuggest(keyWords)

    suspend fun getHotSearchList() = searchService.getHotSearchList()

    suspend fun getRecommendSearchList() = searchService.getRecommendSearchList()

    suspend fun getSearchMusicResultList(keyWords: String,offset: Int) = searchService.getSearchMusicResultList(keyWords = keyWords, offset = offset)

}