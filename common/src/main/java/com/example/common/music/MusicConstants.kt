package com.example.common.music

object MusicConstants {
    const val PLAY_MODE_LOOP = 0 // 列表循环
    const val PLAY_MODE_RANDOM = 1 // 随机播放
    const val PLAY_MODE_SINGLE = 2 // 单曲循环
    const val PLAY_MODE_ORDER = 3 // 顺序播放

    // 播放状态
    const val MPS_NO_FILE = -1 // 无音乐文件
    const val MPS_INVALID = 0 // 当前音乐文件无效
    const val MPS_PREPARE = 1 // 准备就绪
    const val MPS_PLAYING = 2 // 播放中
    const val MPS_PAUSE = 3 // 暂停

    const val TAG = "MusicControl"
    const val ON_403_PLAY_URL = "https://music.163.com/song/media/outer/url?id="
}