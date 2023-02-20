package com.example.common.music.impl.postion

import com.example.common.music.abs.Position
import java.util.*

class RandomPosition(
    override var max: Int, private var current: Int,
    var random: Random = Random(),
    private val nextMap: MutableMap<Int, Int> = mutableMapOf(),
    private val lastMap: MutableMap<Int, Int> = mutableMapOf()
) : Position {
    override fun current(): Int {
        synchronized(this) {
            return current
        }
    }

    override fun next(): Int {
        synchronized(this) {
            if (nextMap.containsKey(current)) {
                current = nextMap[current]!!
            } else {
                val index = random.nextInt(max)
                if (!nextMap.keys.contains(index) && index != current) {
                    nextMap[current] = index
                    lastMap[index] = current
                }
                current = index
            }
            return current
        }

    }

    override fun last(): Int {
        synchronized(this){
            if (lastMap.containsKey(current)){
                current = lastMap[current]!!
            }else{
                val index = random.nextInt(max)
                if (!lastMap.keys.contains(index)&&index!=current){
                    lastMap[current] = index
                    nextMap[index] = current
                }
                current = index
            }
            return current
        }
    }

    override fun with(position: Position) {
        synchronized(this){
            lastMap.clear()
            nextMap.clear()
            current = position.current()
            max = position.max
        }
    }
}