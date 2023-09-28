package com.example.homepage.toplist.repostory;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/homepage/toplist/repostory/TopListRepository;", "", "()V", "collectTopListMap", "", "Lcom/example/homepage/toplist/bean/TopListTab;", "", "Lcom/example/homepage/toplist/bean/TopDetail;", "list", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopDetail", "Lkotlinx/coroutines/flow/Flow;", "homepage_debug"})
public final class TopListRepository {
    @org.jetbrains.annotations.NotNull
    public static final com.example.homepage.toplist.repostory.TopListRepository INSTANCE = null;
    
    private TopListRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.homepage.toplist.bean.TopDetail>> getTopDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object collectTopListMap(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.homepage.toplist.bean.TopDetail> list, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.Map<com.example.homepage.toplist.bean.TopListTab, ? extends java.util.List<com.example.homepage.toplist.bean.TopDetail>>> continuation) {
        return null;
    }
}