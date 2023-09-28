package com.example.homepage.music.bean

import com.example.common.bean.home.Playlist


data class RecommendedPlaylistResponse(
    val category: Int,
    val code: Int,
    val hasTaste: Boolean,
    val result: List<Playlist>
)
