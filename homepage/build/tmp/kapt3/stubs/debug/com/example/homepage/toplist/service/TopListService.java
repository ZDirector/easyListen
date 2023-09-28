package com.example.homepage.toplist.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\'\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/homepage/toplist/service/TopListService;", "", "getLimitTopListSong", "Lcom/example/homepage/toplist/bean/TrackResponse;", "id", "", "limit", "", "(JLjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopListDetail", "Lcom/example/homepage/toplist/bean/TopListResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "homepage_debug"})
public abstract interface TopListService {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/toplist/detail")
    public abstract java.lang.Object getTopListDetail(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.toplist.bean.TopListResponse> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/playlist/track/all")
    public abstract java.lang.Object getLimitTopListSong(@retrofit2.http.Query(value = "id")
    long id, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Query(value = "limit")
    java.lang.Integer limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.homepage.toplist.bean.TrackResponse> continuation);
}