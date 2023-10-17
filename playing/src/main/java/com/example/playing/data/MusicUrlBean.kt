package com.example.playing.data
import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName

@Keep
data class MusicUrl(
    val id: Long = 0L,
    @SerializedName("url")
    val url: String = ""
)