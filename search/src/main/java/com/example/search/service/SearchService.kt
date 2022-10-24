package com.example.search.service

import com.example.common.bean.searchbean.*
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("/search/suggest")
    suspend fun getSearchSuggest(
        @Query("keywords") keyWords : String,
        @Query("type") type : String = "mobile") : SearchSuggestBean

    @GET("/search/hot/detail")
    suspend fun getHotSearchList() : HotSearchBean

    @GET("/search/hot")
    suspend fun getRecommendSearchList() : RecommendSearchBean

    @GET("/cloudsearch")
    suspend fun getSearchMusicResultList(
        @Query("keywords") keyWords : String,
        @Query("limit") limit : Int = 20,
        @Query("offset") offset : Int,
        @Query("type") type: Int = 1) : SearchMusicBean

    @GET("/cloudsearch")
    suspend fun getSearchMusicSheetResultList(
        @Query("keywords") keyWords : String,
        @Query("limit") limit : Int = 20,
        @Query("offset") offset : Int,
        @Query("type") type: Int = 1000) : SearchSongSheetBean

    @GET("/cloudsearch")
    suspend fun getSearchMusicVideoResultList(
        @Query("keywords") keyWords : String,
        @Query("limit") limit : Int = 20,
        @Query("offset") offset : Int,
        @Query("type") type: Int = 1004) : SearchMusicVideoBean
}