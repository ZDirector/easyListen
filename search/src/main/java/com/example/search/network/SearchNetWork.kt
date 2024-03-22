package com.example.search.network

import com.example.common.network.RetrofitClient
import com.example.search.service.SearchService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object SearchNetWork {

    private val searchService = RetrofitClient.retrofit.create(SearchService::class.java)

    suspend fun getSearchSuggest(keyWords: String) =
        withContext(Dispatchers.IO) { searchService.getSearchSuggest(keyWords) }

    suspend fun getHotSearchList() =
        withContext(Dispatchers.IO) { searchService.getHotSearchList() }

    suspend fun getRecommendSearchList() =
        withContext(Dispatchers.IO) { searchService.getRecommendSearchList() }

    suspend fun getSearchMusicResultList(keyWords: String, offset: Int) =
        withContext(Dispatchers.IO) {
            searchService.getSearchMusicResultList(
                keyWords = keyWords,
                offset = offset
            )
        }

    suspend fun getSearchMusicSheetResultList(keyWords: String, offset: Int) =
        withContext(Dispatchers.IO) {
            searchService.getSearchMusicSheetResultList(
                keyWords = keyWords,
                offset = offset
            )
        }

    suspend fun getSearchMusicVideoResultList(keyWords: String, offset: Int) =
        withContext(Dispatchers.IO) {
            searchService.getSearchMusicVideoResultList(
                keyWords = keyWords,
                offset = offset
            )
        }

    suspend fun getSearchUserResultList(keyWords: String, offset: Int) =
        withContext(Dispatchers.IO) {
            searchService.getSearchUserResultList(
                keyWords = keyWords,
                offset = offset
            )
        }
}