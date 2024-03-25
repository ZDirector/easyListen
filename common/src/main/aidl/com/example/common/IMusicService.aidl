package com.example.common;

import com.example.common.bean.searchBean.MusicBean;
import java.util.List;
import android.graphics.Bitmap;
import com.example.common.IMusicCommunicate;

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
    void loadCurMusic(in MusicBean music);
    void updateNotification(in Bitmap bitmap, String title, String name);
    void cancelNotification();

    void resister(in IMusicCommunicate callback);
    void unresister();
    void saveLatest();
}