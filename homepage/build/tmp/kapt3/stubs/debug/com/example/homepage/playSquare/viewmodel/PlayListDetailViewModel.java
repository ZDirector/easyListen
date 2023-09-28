package com.example.homepage.playSquare.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/J\u0006\u00101\u001a\u00020+J\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR&\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R \u0010\'\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001a\u00a8\u00064"}, d2 = {"Lcom/example/homepage/playSquare/viewmodel/PlayListDetailViewModel;", "Lcom/example/common/baseui/BaseViewModel;", "()V", "_bitmapStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroid/graphics/Bitmap;", "_describeLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "_listLiveData", "Lcom/example/common/bean/home/Playlist;", "_nameLiveData", "_songsStateFlow", "", "Lcom/example/common/bean/searchBean/Song;", "_urlLiveData", "bitmapStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getBitmapStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "setBitmapStateFlow", "(Lkotlinx/coroutines/flow/StateFlow;)V", "describeLiveData", "getDescribeLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setDescribeLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "listLiveData", "Landroidx/lifecycle/LiveData;", "getListLiveData", "()Landroidx/lifecycle/LiveData;", "setListLiveData", "(Landroidx/lifecycle/LiveData;)V", "nameLiveData", "getNameLiveData", "setNameLiveData", "songsStateFlow", "getSongsStateFlow", "setSongsStateFlow", "urlLiveData", "getUrlLiveData", "setUrlLiveData", "getSongs", "", "id", "", "limit", "", "offset", "setBitMap", "setList", "playlist", "homepage_debug"})
public final class PlayListDetailViewModel extends com.example.common.baseui.BaseViewModel {
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.common.bean.searchBean.Song>> _songsStateFlow = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.example.common.bean.searchBean.Song>> songsStateFlow;
    private final kotlinx.coroutines.flow.MutableStateFlow<android.graphics.Bitmap> _bitmapStateFlow = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<android.graphics.Bitmap> bitmapStateFlow;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _nameLiveData = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.String> nameLiveData;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _urlLiveData = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.String> urlLiveData;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _describeLiveData = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.String> describeLiveData;
    private final androidx.lifecycle.MutableLiveData<com.example.common.bean.home.Playlist> _listLiveData = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.LiveData<com.example.common.bean.home.Playlist> listLiveData;
    
    public PlayListDetailViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.common.bean.searchBean.Song>> getSongsStateFlow() {
        return null;
    }
    
    public final void setSongsStateFlow(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.example.common.bean.searchBean.Song>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<android.graphics.Bitmap> getBitmapStateFlow() {
        return null;
    }
    
    public final void setBitmapStateFlow(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<android.graphics.Bitmap> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getNameLiveData() {
        return null;
    }
    
    public final void setNameLiveData(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getUrlLiveData() {
        return null;
    }
    
    public final void setUrlLiveData(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getDescribeLiveData() {
        return null;
    }
    
    public final void setDescribeLiveData(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.common.bean.home.Playlist> getListLiveData() {
        return null;
    }
    
    public final void setListLiveData(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LiveData<com.example.common.bean.home.Playlist> p0) {
    }
    
    public final void getSongs(long id, int limit, int offset) {
    }
    
    public final void setBitMap() {
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull
    com.example.common.bean.home.Playlist playlist) {
    }
}