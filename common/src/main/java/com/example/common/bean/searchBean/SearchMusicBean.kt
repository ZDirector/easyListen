package com.example.common.bean.searchBean

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

data class SearchMusicBean(
    val code: Int,
    val result: SearchMusicResult?
)

data class SearchMusicResult(
    val songCount: Int,
    val songs: List<Song>
)

@Keep
@Parcelize
data class Song(
    val alia: List<String> = listOf(),//歌曲的附加信息
    val tns: List<String>? = listOf(),//别名列表，第一个别名会作为副标题，例如Ref:rain(TV动画《恋如雨止》片尾曲)
    val ar: List<Ar> = listOf(),
    val al: Al = Al(),
    val dt: Int = 0,//歌曲时长
    val mv: Int = 0,//非零表示有MV ID
    val name: String = "",//歌曲名
    val originCoverType: Int = 0,//0: 未知, 1: 原曲, 2: 翻唱
    val pop: Int = 0,//常取[0.0~100.0]区间，表示歌曲热度
    val privilege: Privilege = Privilege(),
    val id: Long = 0L,//歌曲id
    val h: Quality = Quality(),
    val m: Quality = Quality(),
    val l: Quality = Quality(),
    val sq: Quality = Quality(),
) : Parcelable {
    fun trans2MusicBean(url : String): MusicBean {
        return MusicBean(
            id = id,
            name = name,
            url = url,
            tns = if (!tns.isNullOrEmpty()) tns[0] else "",
            ar = ar[0].name,
            arId = ar[0].id,
            al = al.name,
            alId = al.id.toLong(),
            alPicUrl = al.picUrl,
            mv = mv.toLong()
        )
    }
}

@Keep
@Parcelize
//专辑类
data class Al(
    val id: Int = 0,//专辑id
    val name: String = "",//专辑名
    val picUrl: String = "",//专辑图URL
) : Parcelable

//歌手列表
@Keep
@Parcelize
data class Ar(
    val alia: List<String> = listOf(),
    val alias: List<String> = listOf(),
    val id: Long = 0L,
    val name: String = "",
) : Parcelable

@Keep
@Parcelize
data class Quality(
    val br: Int = 0,
    val fid: Int = 0,
    val size: Int = 0,
    val sr: Int = 0,
    val vd: Float = 0F
) : Parcelable

@Keep
@Parcelize
data class Privilege(
    val chargeInfoList: List<ChargeInfo> = listOf(),
    val downloadMaxbr: Int = 0,//下载最大码率
    val fee: Int = 0,//0:免费, 1:2元购买单曲, 4:购买专辑, 8:低音质免费
    val flag: Int = 0,//和64按位与,只要不为0就为独家
    val freeTrialPrivilege: FreeTrialPrivilege = FreeTrialPrivilege(),
    val id: Int = 0,//歌曲id
    val playMaxbr: Int = 0,//播放最大码率
    val st: Int = 0,//st < 0表示不能播
) : Parcelable

//选择音质的列表
@Keep
@Parcelize
data class ChargeInfo(
    val chargeType: Int,
    val rate: Int
) : Parcelable

@Keep
@Parcelize
data class FreeTrialPrivilege(
    val resConsumable: Boolean = false,//应该是判断该音乐需不需要购买
    val userConsumable: Boolean = false//应该是判断你有没有购买
) : Parcelable