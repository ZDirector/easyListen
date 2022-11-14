package com.example.homepage.toplist.bean


data class TopListResponse(
    val artistToplist: ArtistToplist,
    val code: Int,
    val list: List<TopDetail>,
    val rewardToplist: RewardToplist
)

data class ArtistToplist(
    val artists: List<Artist>,
    val coverUrl: String,
    val name: String,
    val position: Int,
    val upateFrequency: String,
    val updateFrequency: String
)

data class TopDetail (
    val ToplistType: String,
    val adType: Int,
    val anonimous: Boolean,
    val artists: Any,
    val backgroundCoverId: Int,
    val backgroundCoverUrl: Any,
    val cloudTrackCount: Int,
    val commentThreadId: String,
    val coverImgId: Long,
    val coverImgId_str: String,
    val coverImgUrl: String,
    val createTime: Long,
    val creator: Any,
    val description: String,
    val englishTitle: Any,
    val highQuality: Boolean,
    val id: Long,
    val name: String,
    val newImported: Boolean,
    val opRecommend: Boolean,
    val ordered: Boolean,
    val playCount: Long,
    val privacy: Int,
    val recommendInfo: Any,
    val specialType: Int,
    val status: Int,
    val subscribed: Any,
    val subscribedCount: Int,
    val subscribers: List<Any>,
    val tags: List<String>,
    val titleImage: Int,
    val titleImageUrl: Any,
    val totalDuration: Int,
    val trackCount: Int,
    val trackNumberUpdateTime: Long,
    val trackUpdateTime: Long,
    val tracks: List<Track>,
    val updateFrequency: String,
    val updateTime: Long,
    val userId: Long
){
    var songs:List<Song> = emptyList()
}

data class RewardToplist(
    val coverUrl: String,
    val name: String,
    val position: Int,
)

data class Artist(
    val first: String,
    val second: String,
    val third: Int
)

data class Track(
    val first: String,
    val second: String
)


data class Album(
    val alias: List<Any>,
    val artist: ArtistXXX,
    val artists: List<ArtistXXX>,
    val blurPicUrl: String,
    val briefDesc: String,
    val commentThreadId: String,
    val company: String,
    val companyId: Int,
    val copyrightId: Int,
    val description: String,
    val gapless: Int,
    val id: Int,
    val mark: Int,
    val name: String,
    val onSale: Boolean,
    val pic: Long,
    val picId: Long,
    val picId_str: String,
    val picUrl: String,
    val publishTime: Long,
    val size: Int,
    val status: Int,
    val subType: String,
    val tags: String,
    val transName: Any,
    val type: String
)

data class ArtistXXX(
    val albumSize: Int,
    val alias: List<Any>,
    val briefDesc: String,
    val id: Int,
    val img1v1Id: Int,
    val img1v1Url: String,
    val musicSize: Int,
    val name: String,
    val picId: Int,
    val picUrl: String,
    val topicPerson: Int,
    val trans: String
)

data class BMusic(
    val bitrate: Int,
    val dfsId: Int,
    val extension: String,
    val id: Long,
    val name: Any,
    val playTime: Int,
    val size: Int,
    val sr: Int,
    val volumeDelta: Int
)

data class HMusic(
    val bitrate: Int,
    val dfsId: Int,
    val extension: String,
    val id: Long,
    val name: Any,
    val playTime: Int,
    val size: Int,
    val sr: Int,
    val volumeDelta: Int
)

data class HrMusic(
    val bitrate: Int,
    val dfsId: Int,
    val extension: String,
    val id: Long,
    val name: Any,
    val playTime: Int,
    val size: Int,
    val sr: Int,
    val volumeDelta: Int
)

data class LMusic(
    val bitrate: Int,
    val dfsId: Int,
    val extension: String,
    val id: Long,
    val name: Any,
    val playTime: Int,
    val size: Int,
    val sr: Int,
    val volumeDelta: Int
)

data class MMusic(
    val bitrate: Int,
    val dfsId: Int,
    val extension: String,
    val id: Long,
    val name: Any,
    val playTime: Int,
    val size: Int,
    val sr: Int,
    val volumeDelta: Int
)

data class SqMusic(
    val bitrate: Int,
    val dfsId: Int,
    val extension: String,
    val id: Long,
    val name: Any,
    val playTime: Int,
    val size: Int,
    val sr: Int,
    val volumeDelta: Int
)