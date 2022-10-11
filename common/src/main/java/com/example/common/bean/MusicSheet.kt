package com.example.common.bean

data class MusicSheet(
    /**
     * 歌单 ID
     * */
    val id: Long,
    /**
     * 歌单名
     * */
    val name: String,
    /**
     * 歌单描述
     * */
    val des: String,
    /**
     * 歌单图片
     * */
    val img: String
)
