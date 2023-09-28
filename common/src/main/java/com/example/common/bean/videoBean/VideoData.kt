package com.example.common.bean.videoBean

data class VideoData(
    val id: Long,
    val name: String,
    val desc: String?,
    val artistName: String?,
    val cover: String?,
    val shareCount: Int,
    val commentCount: Int,
    val duration: Long,
    val artists: List<MVDetailArtist>?,
    val url: String,
    var liked: Boolean,
    val likedCount: Int,
    val publishTime : String
)
