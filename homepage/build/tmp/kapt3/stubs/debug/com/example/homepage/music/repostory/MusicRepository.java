package com.example.homepage.music.repostory;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004J\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/example/homepage/music/repostory/MusicRepository;", "", "()V", "getBanner", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/homepage/music/bean/Banner;", "getRankList", "Lcom/example/homepage/music/bean/Rank;", "getRecoList", "Lcom/example/common/bean/home/Playlist;", "homepage_debug"})
public final class MusicRepository {
    @org.jetbrains.annotations.NotNull
    public static final com.example.homepage.music.repostory.MusicRepository INSTANCE = null;
    
    private MusicRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.homepage.music.bean.Banner>> getBanner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.common.bean.home.Playlist>> getRecoList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.homepage.music.bean.Rank>> getRankList() {
        return null;
    }
}