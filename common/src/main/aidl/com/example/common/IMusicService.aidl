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
    void removeMusic(int pos);

    int getPlayState();
    int getPlayMode();
    void setPlayMode(int mode);
    long getCurMusicId();
    boolean loadCurMusic(in MusicBean music);
    void setCurMusic(in MusicBean music);
    MusicBean getCurMusic();
    List<MusicBean> getPlaylist();
    void updateNotification(in Bitmap bitmap, String title, String name);
    void cancelNotification();
}