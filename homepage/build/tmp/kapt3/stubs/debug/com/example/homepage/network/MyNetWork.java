package com.example.homepage.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ)\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020 H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/example/homepage/network/MyNetWork;", "", "()V", "bannerService", "Lcom/example/homepage/music/service/BannerService;", "rankListService", "Lcom/example/homepage/music/service/RankListService;", "recommendedPlaylistService", "Lcom/example/homepage/music/service/RecoListService;", "squareService", "Lcom/example/homepage/playSquare/service/SquareService;", "getBanner", "Lcom/example/homepage/music/bean/BannerResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRankResponse", "Lcom/example/homepage/music/bean/RankListResponse;", "getRecommendedList", "Lcom/example/homepage/music/bean/RecommendedPlaylistResponse;", "getSongs", "Lcom/example/homepage/playSquare/bean/PlaylistSongsResponse;", "id", "", "limit", "", "offset", "(JIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSquareList", "Lcom/example/homepage/playSquare/bean/HighQualityResponse;", "cat", "", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTags", "Lcom/example/homepage/playSquare/bean/PlaylistTagResponse;", "homepage_debug"})
public final class MyNetWork {
    @org.jetbrains.annotations.NotNull
    public static final com.example.homepage.network.MyNetWork INSTANCE = null;
    private static final com.example.homepage.music.service.BannerService bannerService = null;
    private static final com.example.homepage.music.service.RecoListService recommendedPlaylistService = null;
    private static final com.example.homepage.music.service.RankListService rankListService = null;
    private static final com.example.homepage.playSquare.service.SquareService squareService = null;
    
    private MyNetWork() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getBanner(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.music.bean.BannerResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRecommendedList(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.music.bean.RecommendedPlaylistResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRankResponse(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.music.bean.RankListResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTags(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.playSquare.bean.PlaylistTagResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSquareList(int offset, int limit, @org.jetbrains.annotations.NotNull
    java.lang.String cat, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.playSquare.bean.HighQualityResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSongs(long id, int limit, int offset, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.playSquare.bean.PlaylistSongsResponse> continuation) {
        return null;
    }
}