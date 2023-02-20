package com.example.common.music.impl

import com.example.common.music.abs.Position
import com.example.common.music.impl.postion.LoopPosition
import com.example.common.music.impl.postion.OrderPosition
import com.example.common.music.impl.postion.RandomPosition

class MusicModeSetting {
    private val map = mutableMapOf<Int, Position>()
    private val modeList = mutableListOf<Int>()

    fun init(max: Int, current: Int) {
        addMode(ORDER,OrderPosition(max = max, current = current))
        addMode(RANDOM, RandomPosition(max = max, current = current))
        addMode(LOOP,LoopPosition(max = max, current = current))

    }

    fun getPosition(mode: Int):Position?{
        return map[mode]
    }

    fun getFirstMode():Int{
        return modeList[0]
    }

    fun getNextMode(mode: Int):Int{
        val index = modeList.indexOf(mode)
        return modeList[(index+1)%modeList.size]
    }


    /**
     * @param mode 播放模式
     * @param position 位置信息
     * 添加播放模式及位置信息,可通过此方法来添加自己想要的播放模式
     */
    fun addMode(mode: Int, position: Position): Boolean {
        return if (map.containsKey(mode)) {
            false
        } else {
            map[mode]=position
            modeList.add(mode)
            return true

        }
    }


    companion object{
        private var instance :MusicModeSetting? = null
        const val INIT_POSITION = -1
        const val ORDER = 1
        const val RANDOM =  ORDER+  1

        const val LOOP =  ORDER + 2

        fun getInstance():MusicModeSetting{
            if (instance == null){
                synchronized(MusicModeSetting::class.java){
                    if (instance==null){
                        instance = MusicModeSetting()
                    }
                }
            }
            return instance!!
        }

    }
}