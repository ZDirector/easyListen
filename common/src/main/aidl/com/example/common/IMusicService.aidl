package com.example.common;

import com.example.common.bean.searchBean.MusicBean;
import java.util.List;
import android.graphics.Bitmap;

interface IMusicService {
    boolean play(int pos);
    boolean replay();
    boolean pause();
    boolean prev();
    boolean next();
    void stop();
    int duration();
    int position();
    int curIndex();
    int pendingProgress();
    boolean seekTo(int progress);
    void refreshPlaylist(in List<MusicBean> playlist);
    void addMusic(in MusicBean music);
    void removeMusic(int pos);

    void setPlayMode(int mode);
    boolean loadCurMusic(in MusicBean music);
    void setCurMusic(in MusicBean music);
    void updateNotification(in Bitmap bitmap, String title, String name);
    void cancelNotification();

    void onPlayStateChanged(int isPlaying);
    void onPlayListChanged(in List<MusicBean> playlist);
    void onCurMusicChanged(in MusicBean music);
    void onPlayModeChanged(int mode);
    void onPlayProgressChanged(int progress);
    void onCurPlayIndexChanged(int index);

}