package com.example.common.music.impl.postion

import com.example.common.music.abs.Position

class LoopPosition(override var max: Int, private var current: Int) : Position {
    override fun current(): Int {
        synchronized(this) {
            return current
        }
    }

    override fun next(): Int {
        return current()
    }

    override fun last(): Int {
        return current()
    }

    override fun with(position: Position) {
        synchronized(this) {
            current = position.current()
            max = position.max
        }
    }

    override fun toString(): String {
        return "[LoopPosition current = $current, max = $max]"
    }
}