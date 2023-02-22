package com.example.common.music.impl

import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import com.example.common.music.abs.MusicControl
import com.example.common.music.abs.MusicPlayer
import com.example.common.music.abs.Position
import com.example.common.music.data.Item
import com.example.common.music.impl.postion.JudgePosition

class MusicControlImpl<T : Item>(
    private val player: MusicPlayer,
    private val list: MutableList<T> = mutableListOf(),
    var position:JudgePosition

    ) : MusicControl {
    override fun last() {
        if (list.isNotEmpty()) {
            val last = position.current()
            setDataSource(list[position.last()])
            if (isItemChange(last)){
                playOrPause()
            }
        }
    }

    override fun next() {
        if(list.isNotEmpty()){
            val last = position.current()
            setDataSource(list[position.next()])
            if (isItemChange(last)){
                playOrPause()
            }
        }
    }

    override fun playOrPause() {
        if(player.isPrepared()){
            player.playOrPause()
        } else{
            setDataSource(list[position.current()])
        }
    }

    override fun duration(): Int {
        return player.duration()
    }

    override fun seekTo(progress: Int) {
        player.seekTo(progress)
    }

    override fun isPlaying(): Boolean {
        return player.isPlaying()
    }

    override fun reset() {
        return player.reset()
    }

    override fun progress(): Int {
        return player.progress()
    }

    override fun release() {
        return player.release()
    }

    override fun jumpTo(index: Int) {
        val current = (position.max + index)%position.max
        val item  = list[current]
        setDataSource(item)
        playOrPause()

    }






    private fun isItemChange(last:Int):Boolean{
        return last!= position.current()

    }

    private fun setDataSource(item: Item) {
        if (player.isPlaying()) {
            player.playOrPause()
        }
        if (!TextUtils.isEmpty(item.url())) {
            player.setDataSource(item.url()!!)
        }
    }
}

