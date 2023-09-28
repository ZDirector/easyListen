package com.example.common.bean.videoBean

import com.google.gson.annotations.SerializedName

data class MVVideoBean(
    val code: Int,
    val `data`: MVDetailData
)
data class MVDetailData(
    val id: Long,
    val name: String,
    val desc: String,
    val artistName: String,
    val cover: String,
    val shareCount: Int,
    val commentCount: Int,
    val duration: Long,
    val artists: List<MVDetailArtist>?,
    val publishTime : String
)

data class MVDetailArtist(
    val name: String,
    @SerializedName("img1v1Url") val avatar: String?
)