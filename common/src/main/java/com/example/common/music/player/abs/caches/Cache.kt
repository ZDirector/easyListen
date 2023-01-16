package com.example.common.music.player.abs.caches

interface Cache<T> {
    fun put(key:String,value:T)
    fun get(key: String):String?
}