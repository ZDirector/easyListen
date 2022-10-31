package com.example.common.bean.searchbean

data class SearchSongSheetBean(
    val code: Int,
    val result: SearchSongSheetResult
)

data class SearchSongSheetResult(
    val playlistCount: Int,
    val playlists: List<Playlists>
)

data class Playlists(
    val bookCount: Int,
    val coverImgUrl: String,
    val creator: Creator,
    val id: Long,
    val name: String,
    val playCount: Int,
    val subscribed: Boolean,
    val trackCount: Int
)

data class Creator(
    val expertTags: List<String>,
    val nickname: String,
    val userId: Long
)