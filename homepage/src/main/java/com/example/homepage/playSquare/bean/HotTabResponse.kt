package com.example.homepage.playSquare.bean

data class HotTabResponse(
    val code: Int,
    val tags: List<Tag>
)

data class Tag(
    val activity: Boolean,
    val category: Int,
    val createTime: Long,
    val hot: Boolean,
    val id: Int,
    val name: String,
    val playlistTag: PlaylistTag,
    val position: Int,
    val type: Int,
    val usedCount: Int
)

data class PlaylistTag(
    val category: Int,
    val createTime: Long,
    val highQuality: Int,
    val highQualityPos: Int,
    val id: Int,
    val name: String,
    val officialPos: Int,
    val position: Int,
    val type: Int,
    val usedCount: Int
)