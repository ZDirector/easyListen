package com.example.common.music.impl.postion

import java.util.*


/**
 * 管理播放顺序的类
 */
class JudgePosition(var max: Int, var current: Int, var mode: Int = 0) {
    private val nextMap: MutableMap<Int, Int> = mutableMapOf()
    private val lastMap: MutableMap<Int, Int> = mutableMapOf()
    private var random : Random  = Random()
    companion object {
        const val RANDOM = 1
        const val ORDER = 2
        const val LOOP = 3
    }

    fun current():Int{
        synchronized(this){
            return current
        }
    }

    /**
     * 下一首
     */
    fun next() :Int{
        synchronized(this) {

            when (mode) {
                RANDOM -> return nextRandom()
                ORDER -> return nextOrder()
                LOOP -> return nextOrLastLoop()
            }
            return -1
        }
    }


    fun last( ):Int{
        synchronized(this){
            when(mode){
                RANDOM -> return lastRandom()
                ORDER -> return lastOrder()
                LOOP -> return nextOrLastLoop()
            }
            return -1
        }
    }

    private fun lastOrder(): Int {
        return  (current+max -1)%max
    }

    /**
     * 单曲循环的上一首下一首
     */
    private fun nextOrLastLoop(): Int {
        return current
    }


    /**
     * 顺序播放的下一首
     */
    private fun nextOrder(): Int {
        current = (current+1)%max
        return current
    }




    /**
     * 随机播放的下一首
     */
    private fun nextRandom():Int{
        if (nextMap.containsKey(current)){
            current = nextMap[current]!!
        }else{
            val index = random.nextInt(max)
            if (!nextMap.containsKey(current)&& index!=current){
                nextMap[current] = index
                lastMap[current] = index
            }
            current = index
        }
        return current
    }


    /**
     * 随机播放模式下的上一曲
     */
     private fun lastRandom():Int{
        if (lastMap.containsKey(current)){
            current = lastMap[current]!!
        }else{
            val index = random.nextInt(max)
            if (!lastMap.containsKey(current)&&index!=current){
                lastMap[current] = index
                nextMap[current] = index
            }
            current = index
        }
        return current
    }

}