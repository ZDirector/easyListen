package com.example.common.bean.login

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LoginData(
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("token")
    val token: String = "",
    @SerializedName("cookie")
    val cookie: String = "",
    @SerializedName("profile")
    val profile: UserInfo = UserInfo(),
    @SerializedName("msg")
    val msg: String = "",
)

@Keep
data class UserInfo(
    @SerializedName("nickname")
    val name: String = "",
    @SerializedName("userId")
    val userId: Int = 0,
    @SerializedName("avatarUrl")
    val avatarUrl: String = "",
    @SerializedName("birthday")
    val birthday: Long = 0,
    @SerializedName("gender")
    val gender: Int = 0,
    @SerializedName("followeds")
    val followeds: Int = 0,
    @SerializedName("follows")
    val follows: Int = 0,
)

@Keep
data class UserAccountData(
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("account")
    val account: Account = Account(),
    @SerializedName("msg")
    val msg: String = "",
)

@Keep
data class Account(
    @SerializedName("id")
    val userId: Long = 0,
)

@Keep
data class UserDetail(
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("profile")
    val profile: UserInfo = UserInfo(),
    @SerializedName("msg")
    val msg: String = "",
)

@Keep
data class LogoutData(
    @SerializedName("code")
    val code: Int = 0,
    @SerializedName("msg")
    val msg: String = "",
)