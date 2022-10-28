package com.example.search.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0006\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/search/network/SearchNetWork;", "", "()V", "searchService", "Lcom/example/search/service/SearchService;", "kotlin.jvm.PlatformType", "getHotSearchList", "Lcom/example/common/bean/HotSearchBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendSearchList", "Lcom/example/common/bean/RecommendSearchBean;", "getSearchMusicResultList", "Lcom/example/common/bean/searchbean/SearchMusicBean;", "keyWords", "", "offset", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchSuggest", "Lcom/example/common/bean/SearchSuggestBean;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search_debug"})
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
    kotlin.coroutines.Continuation<? super com.example.common.bean.SearchSuggestBean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHotSearchList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.HotSearchBean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecommendSearchList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.RecommendSearchBean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSearchMusicResultList(@org.jetbrains.annotations.NotNull()
    java.lang.String keyWords, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.common.bean.searchbean.SearchMusicBean> continuation) {
        return null;
    }
}