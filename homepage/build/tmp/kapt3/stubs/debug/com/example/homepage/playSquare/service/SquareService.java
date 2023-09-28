package com.example.homepage.playSquare.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ/\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/homepage/playSquare/service/SquareService;", "", "getHighList", "Lcom/example/homepage/playSquare/bean/HighQualityResponse;", "offset", "", "limit", "cat", "", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getListSongs", "Lcom/example/homepage/playSquare/bean/PlaylistSongsResponse;", "id", "", "(JIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTags", "Lcom/example/homepage/playSquare/bean/PlaylistTagResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "homepage_debug"})
public abstract interface SquareService {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/playlist/catlist")
    public abstract java.lang.Object getTags(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.playSquare.bean.PlaylistTagResponse> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/top/playlist")
    public abstract java.lang.Object getHighList(@retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "cat")
    java.lang.String cat, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.playSquare.bean.HighQualityResponse> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/playlist/track/all")
    public abstract java.lang.Object getListSongs(@retrofit2.http.Query(value = "id")
    long id, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.playSquare.bean.PlaylistSongsResponse> continuation);
}