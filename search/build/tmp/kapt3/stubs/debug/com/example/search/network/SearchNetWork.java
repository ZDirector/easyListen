package com.example.search.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/search/network/SearchNetWork;", "", "()V", "searchService", "Lcom/example/search/service/SearchService;", "kotlin.jvm.PlatformType", "getSearchSuggest", "Lcom/example/common/network/RetrofitResponseBody;", "Lcom/example/common/bean/SearchSuggestBean;", "keyWords", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search_debug"})
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
    kotlin.coroutines.Continuation<? super com.example.common.network.RetrofitResponseBody<com.example.common.bean.SearchSuggestBean>> continuation) {
        return null;
    }
}