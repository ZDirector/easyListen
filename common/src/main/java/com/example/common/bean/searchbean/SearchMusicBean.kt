package com.example.common.bean.searchbean

data class SearchMusicBean(
    val code: Int,
    val result: SearchMusicResult
)

data class SearchMusicResult(
    val songCount: Int,
    val songs: List<Song>
)

data class Song(
    val alia : List<String>?,//歌曲的附加信息
    val tns: List<String>?,//别名列表，第一个别名会作为副标题，例如Ref:rain(TV动画《恋如雨止》片尾曲)
    val ar: List<Ar>,
    val al: Al,
    val dt: Int,//歌曲时长
    val mv: Int,//非零表示有MV ID
    val name: String,//歌曲名
    val originCoverType: Int,//0: 未知, 1: 原曲, 2: 翻唱
    val pop: Int,//常取[0.0~100.0]区间，表示歌曲热度
    val privilege: Privilege,
    val id: Int,//歌曲id
    val h: Quality?,
    val m: Quality?,
    val l: Quality?,
    val sq : Quality?
)

//专辑类
data class Al(
    val id: Int,//专辑id
    val name: String,//专辑名
    val picUrl: String,//专辑图URL
)

//歌手列表
data class Ar(
    val alia: List<String>,
    val alias: List<String>,
    val id: Int,
    val name: String,
    val tns: List<Any>
)

data class Quality(
    val br: Int,
    val fid: Int,
    val size: Int,
    val sr: Int,
    val vd: Int
)


data class Privilege(
    val chargeInfoList: List<ChargeInfo>,
    val downloadMaxbr: Int,//下载最大码率
    val fee: Int,//0:免费, 1:2元购买单曲, 4:购买专辑, 8:低音质免费
    val flag: Int,//和64按位与,只要不为0就为独家
    val freeTrialPrivilege: FreeTrialPrivilege,
    val id: Int,//歌曲id
    val playMaxbr: Int,//播放最大码率
    val st: Int,//st < 0表示不能播
)

//选择音质的列表
data class ChargeInfo(
    val chargeType: Int,
    val rate: Int
)

data class FreeTrialPrivilege(
    val resConsumable: Boolean,//应该是判断该音乐需不需要购买
    val userConsumable: Boolean//应该是判断你有没有购买
)