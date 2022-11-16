package com.example.search.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0006\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J!\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/search/network/SearchNetWork;", "", "()V", "searchService", "Lcom/example/search/service/SearchService;", "kotlin.jvm.PlatformType", "getHotSearchList", "Lcom/example/common/bean/searchBean/HotSearchBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendSearchList", "Lcom/example/common/bean/searchBean/RecommendSearchBean;", "getSearchMusicResultList", "Lcom/example/common/bean/searchBean/SearchMusicBean;", "keyWords", "", "offset", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchMusicSheetResultList", "Lcom/example/common/bean/searchBean/SearchSongSheetBean;", "getSearchMusicVideoResultList", "Lcom/example/common/bean/searchBean/SearchMusicVideoBean;", "getSearchSuggest", "Lcom/example/common/bean/searchBean/SearchSuggestBean;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchUserResultList", "Lcom/example/common/bean/searchBean/SearchUserBean;", "search_debug"})
public final class SearchNetWork {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.search.network.SearchNetWork INSTANCE = null;
    private static final com.example.search.service.SearchService searchService = null;
    
    private SearchNetWork() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSearchSuggest(@org.jetbrains.annotations.NotNull()
    java.lang.String keyWords, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchBean.SearchSuggestBean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHotSearchList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchBean.HotSearchBean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecommendSearchList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchBean.RecommendSearchBean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSearchMusicResultList(@org.jetbrains.annotations.NotNull()
    java.lang.String keyWords, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchBean.SearchMusicBean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSearchMusicSheetResultList(@org.jetbrains.annotations.NotNull()
    java.lang.String keyWords, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchBean.SearchSongSheetBean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSearchMusicVideoResultList(@org.jetbrains.annotations.NotNull()
    java.lang.String keyWords, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchBean.SearchMusicVideoBean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSearchUserResultList(@org.jetbrains.annotations.NotNull()
    java.lang.String keyWords, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchBean.SearchUserBean> continuation) {
        return null;
    }
}