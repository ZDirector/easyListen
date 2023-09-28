package com.example.common.music.abs

interface Position {
    /**
     * 当前位置
     */
    fun current():Int

    /**
     * 下一位置
     */
    fun next():Int

    /**
     * 上一位置
     */
    fun last():Int

    /**
     * 根据传入的position重构这个position的参数
     */
    fun with(position: Position)

    /**
     * 最大位置
     */
    var max:Int
}