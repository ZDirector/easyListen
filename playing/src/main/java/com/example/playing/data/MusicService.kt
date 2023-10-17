package com.example.playing.data

import com.example.common.bean.BaseBean
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {

    @GET("song/url")
    suspend fun getMusicUrl(@Query("id") id: String): BaseBean<List<MusicUrl>>

}