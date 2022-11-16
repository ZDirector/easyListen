package com.example.video.service

import com.example.common.bean.videoBean.MVInfoDataBean
import com.example.common.bean.videoBean.MVUrlBean
import com.example.common.bean.videoBean.MVVideoBean
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoService {

    /**
     * 获取mv详情
     */
    @GET("/mv/detail")
    suspend fun getMVDetail(@Query("mvid") mvId: String) : MVVideoBean

    /**
     * 获取mv播放地址
     */
    @GET("/mv/url")
    suspend fun getMVUrl(@Query("id") id: String): MVUrlBean

    /**
     * 获取MV点赞详情
     */
    @GET("/mv/detail/info")
    suspend fun getMVInfo(@Query("mvid") mvId: String): MVInfoDataBean
}