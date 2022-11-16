package com.example.common.bean.searchBean

data class SearchMusicVideoBean(
    val code: Int,
    val result: SearchMusicVideoResult
)

data class SearchMusicVideoResult(
    val mvCount: Int,
    val mvs: List<Mv>?
)

data class Mv(
    val artistId: Int,
    val artistName: String,
    val artists: List<Artist>,
    val cover: String,
    val duration: Int,
    val id: Int,
    val name: String,
    val playCount: Int
)

data class Artist(
    val alias: List<String>,
    val id: Int,
    val name: String
)