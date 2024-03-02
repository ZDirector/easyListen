package com.example.common.music

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.Bitmap
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import com.example.common.IMusicService
import com.example.common.bean.searchBean.MusicBean
import com.example.common.utils.LogUtil

class MusicManager(internal val context: Context) : IMusicService.Stub() {

    companion object {
        private const val TAG = "MediaManager"
        const val MUSIC_SERVICE = "com.example.common.music.MusicService"
    }

    private var mediaService: IMusicService? = null
    private val serviceConnection: ServiceConnection
    private var onCompletionListener: MusicControl.OnConnectCompletionListener? = null
    private var iMusicManager: IMusicManager? = null

    init {
        this.serviceConnection = object : ServiceConnection {

            override fun onServiceConnected(name: ComponentName, service: IBinder) {
                mediaService = asInterface(service)
                if (mediaService != null) {
                    //音频服务启动的标志
                    LogUtil.i(TAG, "MediaManager:connected")
                    onCompletionListener?.onConnectCompletion(mediaService)
                }
            }

            override fun onServiceDisconnected(name: ComponentName) {
                //音频服务断开的标志
                LogUtil.i(TAG, "MediaManager:disconnected")
                Log.d("Test", "onServiceDisconnected")
                mediaService = null
            }
        }
    }

    fun setOnCompletionListener(l: MusicControl.OnConnectCompletionListener) {
        onCompletionListener = l
    }

    fun connectService() {
        val intent = Intent(MUSIC_SERVICE)
        intent.setClass(context, MusicService::class.java)
        context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    fun disconnectService() {
        context.unbindService(serviceConnection)
        context.stopService(Intent(context, MusicService::class.java))
    }

    fun setIMusicManager(iMusicManager: IMusicManager) {
        this.iMusicManager = iMusicManager
    }

    override fun play(pos: Int): Boolean {
        try {
            return mediaService?.play(pos) ?: false
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return false
    }

    override fun replay(): Boolean {
        try {
            return mediaService?.replay() ?: false
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return false
    }

    override fun pause(): Boolean {
        try {
            return mediaService?.pause() ?: false
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return false
    }

    override fun prev(): Boolean {
        try {
            return mediaService?.prev() ?: false
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return false
    }

    override fun next(): Boolean {
        try {
            return mediaService?.next() ?: false
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return false
    }

    override fun stop() {
        try {
            mediaService?.stop()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    override fun duration(): Int {
        try {
            return mediaService?.duration() ?: 0
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return 0
    }

    override fun position(): Int {
        try {
            return mediaService?.position() ?: 0
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return 0
    }

    override fun curIndex(): Int {
        try {
            return mediaService?.curIndex() ?: 0
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return 0
    }

    override fun pendingProgress(): Int {
        try {
            return mediaService?.pendingProgress() ?: 0
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return 0
    }

    override fun seekTo(progress: Int): Boolean {
        try {
            return mediaService?.seekTo(progress) ?: false
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return false
    }

    override fun refreshPlaylist(playlist: MutableList<MusicBean>?) {
        try {
            assert(playlist != null)
            mediaService?.refreshPlaylist(playlist)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    override fun addMusic(music: MusicBean?) {
        music?.let {
            try {
                mediaService?.addMusic(it)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }
    }

    override fun removeMusic(pos: Int) {
        try {
            mediaService?.removeMusic(pos)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    override fun setPlayMode(mode: Int) {
        try {
            mediaService?.setPlayMode(mode)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    override fun loadCurMusic(music: MusicBean?): Boolean {
        try {
            return mediaService?.loadCurMusic(music) ?: false
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return false
    }

    override fun setCurMusic(music: MusicBean?) {
        try {
            mediaService?.setCurMusic(music)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    override fun updateNotification(bitmap: Bitmap?, title: String?, name: String?) {

    }

    override fun cancelNotification() {

    }

    override fun onPlayStateChanged(isPlaying: Int) {
        iMusicManager?.onPlayStateChanged(isPlaying)
    }

    override fun onPlayListChanged(playlist: MutableList<MusicBean>?) {
        iMusicManager?.onPlayListChanged(playlist)
    }

    override fun onCurMusicChanged(music: MusicBean?) {
        iMusicManager?.onCurMusicChanged(music)
    }

    override fun onPlayModeChanged(mode: Int) {
        iMusicManager?.onPlayModeChanged(mode)
    }

    override fun onPlayProgressChanged(progress: Int) {
        iMusicManager?.onPlayProgressChanged(progress)
    }

    override fun onCurPlayIndexChanged(index: Int) {
        iMusicManager?.onCurPlayIndexChanged(index)
    }

    interface IMusicManager {
        fun onPlayStateChanged(isPlaying: Int)
        fun onPlayListChanged(playlist: MutableList<MusicBean>?)
        fun onCurMusicChanged(music: MusicBean?)
        fun onPlayModeChanged(mode: Int)
        fun onPlayProgressChanged(progress: Int)
        fun onCurPlayIndexChanged(index: Int)
    }

}