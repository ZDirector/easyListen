package com.example.common.bean.searchBean

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = "playSongList")
data class MusicBean(
    @PrimaryKey
    var id: Long = 0L, // 歌曲id
    var name: String = "", // 歌曲名
    var url : String = "", // 歌曲播放地址
    var tns: String = "", // 别名列表，第一个别名会作为副标题，例如Ref:rain(TV动画《恋如雨止》片尾曲)
    var ar: String = "", // 歌手名
    var arId: Long = 0L, // 歌手id
    var al: String = "",// 专辑名
    var alId: Long = 0L, // 专辑id
    var alPicUrl: String = "", // 专辑图URL
    var mv: Long = 0L, // 非零表示有MV ID
    var lastPlayTime : Long = 0L // 最后一次播放时间
) : Parcelable