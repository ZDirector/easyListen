package com.example.playing.data
import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName
import java.util.regex.Pattern

@Keep
data class MusicUrl(
    val id: Long = 0L,
    @SerializedName("url")
    val url: String = ""
)

@Keep
data class LyricData(
    val lrc: Lyric = Lyric(),
    val code: Int = 0
)

@Keep
data class Lyric(
    val lyric: String = "",
) {
    /**
     * 歌词解析
     * 原歌词格式为：[00:12.570]难以忘记初次见你\n[00:16.860]一双迷人的眼睛\n
     * 解析后：[LyricLine(12570, "难以忘记初次见你"), LyricLine(16860, "一双迷人的眼睛")]
     */
    fun parseLyrics(): List<LyricLine> {
        val lines = lyric.split("\n")
        val lyricList = mutableListOf<LyricLine>()
        val pattern = Pattern.compile("\\[(\\d{2}):(\\d{2})\\.(\\d{2,3})\\](.*)")
        for (line in lines) {
            val matcher = pattern.matcher(line)
            if (matcher.find()) {
                val minute = matcher.group(1)?.toLong() ?: 0
                val second = matcher.group(2)?.toLong() ?: 0
                val millisecond = matcher.group(3)?.toLong() ?: 0
                val time = minute * 60 * 1000 + second * 1000 + millisecond
                val text = matcher.group(4) ?: ""
                lyricList.add(LyricLine(time, text))
            }
        }
        return lyricList
    }
}

@Keep
data class LyricLine(
    val time: Long = 0L, // 单位毫秒
    val text: String = "",

    // 以下为本地字段
    var _isPlaying: Boolean = false, // 是否正在播放
    var _isBeSelected: Boolean = false // 是否被选中
)