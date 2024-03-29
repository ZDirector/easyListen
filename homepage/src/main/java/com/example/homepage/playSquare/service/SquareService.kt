package com.example.homepage.playSquare.service

import com.example.homepage.playSquare.bean.HighQualityResponse
import com.example.homepage.playSquare.bean.PlaylistSongsResponse
import com.example.homepage.playSquare.bean.PlaylistTagResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SquareService {
    @GET("/playlist/catlist")
    suspend fun getTags():PlaylistTagResponse

    @GET("/top/playlist")
    suspend fun getHighList(
        @Query("offset")
        offset: Int,
        @Query("limit")
        limit:Int,
        @Query("cat")
        cat:String):HighQualityResponse

    @GET("/playlist/track/all")
    suspend fun getListSongs(
        @Query("id")
        id:Long,
        @Query("limit")
        limit: Int,
        @Query("offset")
        offset: Int
    ):PlaylistSongsResponse
}