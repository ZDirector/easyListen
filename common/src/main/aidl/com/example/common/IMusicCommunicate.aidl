package com.example.common;

import com.example.common.bean.searchBean.MusicBean;
import java.util.List;

interface IMusicCommunicate {
    void onPlayStateChanged(int playStatus);
    void onPlayListChanged(in List<MusicBean> playlist);
    void onCurMusicChanged(in MusicBean music);
    void onPlayModeChanged(int mode);
    void onCurPlayIndexChanged(int index);
}
