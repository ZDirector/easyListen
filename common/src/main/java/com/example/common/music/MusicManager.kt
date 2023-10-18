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
        Log.d("TestService", "disconnectService")
        context.unbindService(serviceConnection)
        context.stopService(Intent(context, MusicService::class.java))
    }

    override fun play(pos: Int): Boolean {
        try {
            return mediaService?.play(pos) ?: false
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return false
    }

    override fun playByUrl(music: MusicBean?, url: String?) {
        try {
            mediaService?.playByUrl(music, url)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
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

    override fun getPlayState(): Int {
        try {
            return mediaService?.playState ?: 0
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return 0
    }

    override fun getPlayMode(): Int {
        try {
            return mediaService?.playMode ?: 0
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return 0
    }

    override fun setPlayMode(mode: Int) {
        try {
            mediaService?.playMode = mode
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    override fun getCurMusicId(): Long {
        try {
            return mediaService?.curMusicId ?: 0
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return 0
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
            mediaService?.curMusic = music
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    override fun getCurMusic(): MusicBean {
        try {
            return mediaService?.curMusic ?: MusicBean()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return MusicBean()
    }

    override fun getPlaylist(): MutableList<MusicBean> {
        try {
            return mediaService?.playlist ?: mutableListOf()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
        return mutableListOf()
    }

    override fun updateNotification(bitmap: Bitmap?, title: String?, name: String?) {

    }

    override fun cancelNotification() {

    }


}