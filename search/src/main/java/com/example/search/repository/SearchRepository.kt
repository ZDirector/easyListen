package com.example.search.repository

import com.example.common.bean.searchbean.SearchHistoryBean
import com.example.common.db.EasyListenDB
import com.example.search.network.SearchNetWork

object SearchRepository {

    private const val TAG = "SearchRepository"
    private val easyListenDB = EasyListenDB.instance.searchHistoryDao()

    suspend fun getSearchSuggest(keyWords : String) = SearchNetWork.getSearchSuggest(keyWords)

    suspend fun getHotSearchList() = SearchNetWork.getHotSearchList()

    suspend fun getRecommendSearchList() = SearchNetWork.getRecommendSearchList()

    suspend fun getSearchMusicResultList(keyWords: String,offset: Int) = SearchNetWork.getSearchMusicResultList(keyWords,offset)

    suspend fun getSearchMusicSheetResultList(keyWords: String,offset: Int) = SearchNetWork.getSearchMusicSheetResultList(keyWords,offset)

    suspend fun getSearchMusicVideoResultList(keyWords: String,offset: Int) = SearchNetWork.getSearchMusicVideoResultList(keyWords,offset)

    suspend fun getSearchUserResultList(keyWords: String,offset: Int) = SearchNetWork.getSearchUserResultList(keyWords,offset)

    fun getSearchHistoryList() = easyListenDB.queryAllSearchHistory()

    fun addSearchHistory(keyWords: String) = easyListenDB.addSearchHistory(SearchHistoryBean(keyWords))

    fun delAllSearchHistory() = easyListenDB.deleteAllSearchHistory()
}