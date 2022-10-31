package com.example.music_comment.service

import com.example.common.bean.musicComment.MusicCommentBean
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicCommentService {

    @GET("/comment/new")
    suspend fun getMusicCommentList(
        @Query("type") type : Int = 0,
        @Query("id") id : Int,
        @Query("sortType") sortType : Int,
        @Query("pageSize") pageSize : Int = 20,
        @Query("pageNo") pageNo : Int) : MusicCommentBean

}