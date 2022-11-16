package com.example.search.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\bJ\u0011\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J!\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/example/search/repository/SearchRepository;", "", "()V", "TAG", "", "easyListenDB", "Lcom/example/common/dao/SearchHistoryDao;", "addSearchHistory", "", "keyWords", "delAllSearchHistory", "getHotSearchList", "Lcom/example/common/bean/searchBean/HotSearchBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendSearchList", "Lcom/example/common/bean/searchBean/RecommendSearchBean;", "getSearchHistoryList", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/common/bean/searchBean/SearchHistoryBean;", "getSearchMusicResultList", "Lcom/example/common/bean/searchBean/SearchMusicBean;", "offset", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchMusicSheetResultList", "Lcom/example/common/bean/searchBean/SearchSongSheetBean;", "getSearchMusicVideoResultList", "Lcom/example/common/bean/searchBean/SearchMusicVideoBean;", "getSearchSuggest", "Lcom/example/common/bean/searchBean/SearchSuggestBean;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchUserResultList", "Lcom/example/common/bean/searchBean/SearchUserBean;", "search_debug"})
public final class SearchRepository {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.search.repository.SearchRepository INSTANCE = null;
    private static final java.lang.String TAG = "SearchRepository";
    private static final com.example.common.dao.SearchHistoryDao easyListenDB = null;
    
    private SearchRepository() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.common.bean.searchBean.SearchHistoryBean>> getSearchHistoryList() {
        return null;
    }
    
    public final void addSearchHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String keyWords) {
    }
    
    public final void delAllSearchHistory() {
    }
}