package com.example.common.bean.home

import java.io.Serializable

data class Playlist(

    val commentCount: Int = 0,
    var coverImgUrl: String = "",
    val creator: Creator = Creator(""),
    val description: String = "",
    val id: Long = 0,
    val name: String = "",
    val playCount: Long = 0,
    val shareCount: Int = 0,
    val status: Int = 0,
    var picUrl: String = "",

    val tag: String = "",
    val tags: ArrayList<String> = ArrayList(),
): Serializable{
    init {
        if (picUrl.isNotEmpty()) coverImgUrl = picUrl
        if (coverImgUrl.isNotEmpty()) picUrl = coverImgUrl

    }
}

data class Creator(

    val nickname: String = "",

    ): Serializable


