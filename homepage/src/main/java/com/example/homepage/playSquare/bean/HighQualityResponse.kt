package com.example.homepage.playSquare.bean

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.util.ArrayList

data class HighQualityResponse(
    val code: Int,
    val lasttime: Long,
    val more: Boolean,
    val playlists: List<Playlist>,
    val total: Int
){
    constructor() : this(0,0,false, emptyList(),0)
}

data class Playlist(
    val adType: Int,
    val anonimous: Boolean,
    val commentCount: Int,
    val coverImgId: Long,
    val coverImgId_str: String,
    val coverImgUrl: String,
    val coverStatus: Int,
    val createTime: Long,
    val creator: Creator,
    val description: String,
    val highQuality: Boolean,
    val id: Long,
    val name: String,
    val ordered: Boolean,
    val playCount: Long,
    val privacy: Int,
    val shareCount: Int,
    val specialType: Int,
    val status: Int,
    val subscribed: Boolean,
    val subscribedCount: Int,
    val subscribers: List<Subscriber>,
    val tag: String,
    val tags: ArrayList<String>,
):Serializable

data class Creator(
    val accountStatus: Int,
    val anchor: Boolean,
    val authStatus: Int,
    val authenticationTypes: Int,
    val authority: Int,
    val avatarDetail: AvatarDetail,
    val avatarImgId: Long,
    val avatarImgIdStr: String,
    val avatarImgId_str: String,
    val avatarUrl: String,
    val backgroundImgId: Long,
    val backgroundImgIdStr: String,
    val backgroundUrl: String,
    val birthday: Long,
    val city: Int,
    val defaultAvatar: Boolean,
    val description: String,
    val detailDescription: String,
    val djStatus: Int,
    val expertTags: List<String>,
    val followed: Boolean,
    val gender: Int,
    val mutual: Boolean,
    val nickname: String,
    val province: Int,
    val signature: String,
    val userType: Int,
    val vipType: Int
):Serializable

data class Subscriber(
    val accountStatus: Int,
    val anchor: Boolean,
    val authStatus: Int,
    val authenticationTypes: Int,
    val authority: Int,
    val avatarImgId: Long,
    val avatarImgIdStr: String,
    val avatarImgId_str: String,
    val avatarUrl: String,
    val backgroundImgId: Long,
    val backgroundImgIdStr: String,
    val backgroundUrl: String,
    val birthday: Long,
    val city: Int,
    val defaultAvatar: Boolean,
    val description: String,
    val detailDescription: String,
    val djStatus: Int,
    val followed: Boolean,
    val gender: Int,
    val mutual: Boolean,
    val nickname: String,
    val province: Int,
    val signature: String,
    val userType: Int,
    val vipType: Int
):Serializable

data class AvatarDetail(
    val identityIconUrl: String,
    val identityLevel: Int,
    val userType: Int
):Serializable
