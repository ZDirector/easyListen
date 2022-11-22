package com.example.homepage.playSquare.bean


import com.example.common.bean.home.Playlist
import java.io.Serializable
import kotlin.collections.ArrayList

data class HighQualityResponse(
    val code: Int,
    val lasttime: Long,
    val more: Boolean,
    val playlists: List<Playlist>,
    val total: Int
){
    constructor() : this(0,0,false, emptyList(),0)
}


