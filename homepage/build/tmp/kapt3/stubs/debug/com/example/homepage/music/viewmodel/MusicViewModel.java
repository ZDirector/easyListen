package com.example.homepage.music.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0019\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0011\u0010\u001d\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\fX\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0002R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\fX\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0002R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/example/homepage/music/viewmodel/MusicViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_mBanners", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/homepage/music/bean/Banner;", "_mRankList", "Lcom/example/homepage/music/bean/Rank;", "_mRecoLists", "Lcom/example/common/bean/home/Playlist;", "mBannerFlow", "Lkotlinx/coroutines/flow/Flow;", "mBanners", "Landroidx/lifecycle/LiveData;", "getMBanners", "()Landroidx/lifecycle/LiveData;", "mRankList", "getMRankList", "mRankListFlow", "getMRankListFlow$annotations", "mRecoListFlow", "getMRecoListFlow$annotations", "mRecoLists", "getMRecoLists", "getBanners", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRanks", "getRecoLists", "homepage_debug"})
public final class MusicViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.homepage.music.bean.Banner>> mBannerFlow = null;
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.common.bean.home.Playlist>> mRecoListFlow = null;
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.homepage.music.bean.Rank>> mRankListFlow = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.homepage.music.bean.Banner>> _mBanners = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.common.bean.home.Playlist>> _mRecoLists = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.homepage.music.bean.Rank>> _mRankList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.common.bean.home.Playlist>> mRecoLists = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.homepage.music.bean.Banner>> mBanners = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.homepage.music.bean.Rank>> mRankList = null;
    
    public MusicViewModel() {
        super();
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.FlowPreview.class})
    @java.lang.Deprecated
    private static void getMRecoListFlow$annotations() {
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.FlowPreview.class})
    @java.lang.Deprecated
    private static void getMRankListFlow$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.common.bean.home.Playlist>> getMRecoLists() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.homepage.music.bean.Banner>> getMBanners() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.homepage.music.bean.Rank>> getMRankList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getBanners(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRecoLists(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRanks(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}