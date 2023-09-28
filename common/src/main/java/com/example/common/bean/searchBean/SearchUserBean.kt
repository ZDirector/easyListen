package com.example.common.bean.searchBean

data class SearchUserBean(
    val code: Int,
    val result: SearchUserResult
)

data class SearchUserResult(
    val userprofileCount: Int,
    val userprofiles: List<Userprofile>?
)

data class Userprofile(
    val accountStatus: Int,
    val alg: String,
    val anchor: Boolean,
    val authStatus: Int,
    val authenticationTypes: Int,
    val authority: Int,
    val avatarDetail: AvatarDetail,
    val avatarImgId: Long,
    val avatarUrl: String,
    val backgroundUrl: String,
    val birthday: Int,
    val city: Int,
    val defaultAvatar: Boolean,
    val description: String,
    val detailDescription: String,
    val djStatus: Int,
    val followed: Boolean,
    val followeds: Int,
    val follows: Int,
    val gender: Int,
    val mutual: Boolean,
    val nickname: String,
    val playlistBeSubscribedCount: Int,
    val playlistCount: Int,
    val province: Int,
    val signature: String,
    val userId: Long,
    val userType: Int,
    val vipType: Int
)

data class AvatarDetail(
    val identityIconUrl: String,
    val identityLevel: Int,
    val userType: Int
)