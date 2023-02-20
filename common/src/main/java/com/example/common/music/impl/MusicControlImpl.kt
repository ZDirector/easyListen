package com.example.common.music.impl

import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import com.example.common.music.abs.MusicControl
import com.example.common.music.abs.MusicPlayer
import com.example.common.music.abs.Position
import com.example.common.music.data.Item

class MusicControlImpl<T : Item>(
    private val player: MusicPlayer,
    var position: Position,
    private val list: MutableList<T> = mutableListOf(),
    handler: Handler = Handler(Looper.myLooper()!!),
    var listenerManger: MediaListenerManger,
    var preparedListener: PreparedListener<T>? = null,
    var errorListener: ErrorListener<T>? = null,
    var completeListener: CompleteListener<T>? = null,

    ) : MusicControl {
    override fun last() {
        if (list.isNotEmpty()) {
            val last = position.current()
            setDataSource(list[position.last()])
            if (isItemChange(last)){
                notifyItemChange()
            }
        }
    }

    override fun next() {
        if(list.isNotEmpty()){
            val last = position.current()
            setDataSource(list[position.next()])
            if (isItemChange(last)){
                notifyItemChange()
            }
        }
    }

    override fun playOrPause() {
        if(player.isPrepared()){
            player.playOrPause()
        } else{
            setDataSource(list[position.current()])
            notifyItemChange()
        }
        listenerManger.invokeChangeListener(player.isPlaying(),PlayStateFilter)
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
        val p = TempPosition(max = position.max,current = index)
        position.with(p)
        val item  = list[position.current()]
        setDataSource(item)
        notifyItemChange()
    }



    private class TempPosition(override var max:Int,val current:Int):Position{
        override fun current(): Int {
            return current
        }

        override fun next(): Int {
            return 0
        }

        override fun last(): Int {
            return 0
        }

        override fun with(position: Position) {
        }

    }

    private fun notifyItemChange(){
        listenerManger.invokeChangeListener(list[position.current()],ItemFilter)
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

// 音乐播放器准备完成时的回调
interface PreparedListener<T> {
    fun onPrepared(value: T)
}

/**
 * 音乐播放错误时的回调
 */
interface ErrorListener<T> {
    fun onError(value: T): Boolean
}


/**
 * 音乐播放完成的回调
 */
interface CompleteListener<T> {
    fun onComplete(value: T)
}


// 真正的播放器回调管理接口
interface MediaListenerManger {
    fun <T> registerChangeListener(listener: ChangeListener<T>)
    fun <T> removeChangeListener(listener: ChangeListener<T>)
    fun <T> invokeChangeListener(value: T, filter: ListenerFilter<T>)
}


interface ChangeListener<T> {
    fun onChange(value: T)
    val key: ListenerKey
        get() = DefaultKey
}

interface ListenerKey {
}

object DefaultKey : ListenerKey

object PlayStateKey : ListenerKey

object ModeStateKey : ListenerKey

object ItemKey : ListenerKey



// 过滤器，用于过滤不符合条件的ChangeListener
interface ListenerFilter<T> {
    fun filter(listener: ChangeListener<T>): Boolean
}

// PlayStateChangeListener的过滤器
object PlayStateFilter : ListenerFilter<Boolean> {
    override fun filter(listener: ChangeListener<Boolean>): Boolean {
        return listener.key == PlayStateKey
    }
}

// ModeStateChangeListener的过滤器
object ModeFilter : ListenerFilter<Int> {
    override fun filter(listener: ChangeListener<Int>): Boolean {
        return listener.key == ModeStateKey
    }
}

// ItemChangeListener的过滤器
object ItemFilter : ListenerFilter<Item> {
    override fun filter(listener: ChangeListener<Item>): Boolean {
        return listener.key == ItemKey
    }
}