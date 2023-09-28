package com.example.homepage.playSquare.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0015R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/example/homepage/playSquare/viewmodel/SquareViewModel;", "Lcom/example/common/baseui/BaseViewModel;", "()V", "_highListStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/paging/PagingData;", "Lcom/example/common/bean/home/Playlist;", "_squareListStateFlow", "Lcom/example/homepage/playSquare/bean/HighQualityResponse;", "_tagsStateFlow", "", "Lcom/example/homepage/playSquare/bean/Sub;", "highListStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getHighListStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "squareListStateFlow", "getSquareListStateFlow", "tagsStateFlow", "getTagsStateFlow", "getSquareList", "", "offset", "", "limit", "cat", "", "getTags", "homepage_debug"})
public final class SquareViewModel extends com.example.common.baseui.BaseViewModel {
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.paging.PagingData<com.example.common.bean.home.Playlist>> _highListStateFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<androidx.paging.PagingData<com.example.common.bean.home.Playlist>> highListStateFlow = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.homepage.playSquare.bean.Sub>> _tagsStateFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.homepage.playSquare.bean.Sub>> tagsStateFlow = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.homepage.playSquare.bean.HighQualityResponse> _squareListStateFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.homepage.playSquare.bean.HighQualityResponse> squareListStateFlow = null;
    
    public SquareViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<androidx.paging.PagingData<com.example.common.bean.home.Playlist>> getHighListStateFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.homepage.playSquare.bean.Sub>> getTagsStateFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.homepage.playSquare.bean.HighQualityResponse> getSquareListStateFlow() {
        return null;
    }
    
    public final void getSquareList(int offset, int limit, @org.jetbrains.annotations.NotNull
    java.lang.String cat) {
    }
    
    public final void getTags() {
    }
}