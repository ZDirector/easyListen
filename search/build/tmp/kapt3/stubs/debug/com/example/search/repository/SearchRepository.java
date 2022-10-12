package com.example.search.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00062\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/search/repository/SearchRepository;", "", "()V", "TAG", "", "getSearchSuggest", "Lkotlinx/coroutines/flow/Flow;", "", "keyWords", "search_debug"})
public final class SearchRepository {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.search.repository.SearchRepository INSTANCE = null;
    private static final java.lang.String TAG = "SearchRepository";
    
    private SearchRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getSearchSuggest(@org.jetbrains.annotations.NotNull()
    java.lang.String keyWords) {
        return null;
    }
}