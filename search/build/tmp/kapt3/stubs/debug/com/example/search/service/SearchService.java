package com.example.search.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J9\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0003\u0010\u000e\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ9\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0003\u0010\u000e\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ9\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0003\u0010\u000e\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ%\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000e\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/search/service/SearchService;", "", "getHotSearchList", "Lcom/example/common/bean/searchbean/HotSearchBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendSearchList", "Lcom/example/common/bean/searchbean/RecommendSearchBean;", "getSearchMusicResultList", "Lcom/example/common/bean/searchbean/SearchMusicBean;", "keyWords", "", "limit", "", "offset", "type", "(Ljava/lang/String;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchMusicSheetResultList", "Lcom/example/common/bean/searchbean/SearchSongSheetBean;", "getSearchMusicVideoResultList", "Lcom/example/common/bean/searchbean/SearchMusicVideoBean;", "getSearchSuggest", "Lcom/example/common/bean/searchbean/SearchSuggestBean;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search_debug"})
public abstract interface SearchService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/search/suggest")
    public abstract java.lang.Object getSearchSuggest(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "keywords")
    java.lang.String keyWords, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "type")
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchbean.SearchSuggestBean> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/search/hot/detail")
    public abstract java.lang.Object getHotSearchList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchbean.HotSearchBean> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/search/hot")
    public abstract java.lang.Object getRecommendSearchList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchbean.RecommendSearchBean> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/cloudsearch")
    public abstract java.lang.Object getSearchMusicResultList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "keywords")
    java.lang.String keyWords, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "type")
    int type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchbean.SearchMusicBean> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/cloudsearch")
    public abstract java.lang.Object getSearchMusicSheetResultList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "keywords")
    java.lang.String keyWords, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "type")
    int type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchbean.SearchSongSheetBean> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/cloudsearch")
    public abstract java.lang.Object getSearchMusicVideoResultList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "keywords")
    java.lang.String keyWords, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "type")
    int type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchbean.SearchMusicVideoBean> continuation);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
    }
}