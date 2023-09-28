package com.example.homepage.toplist.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eR&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/example/homepage/toplist/viewmodel/TopListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_topDetailsStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/homepage/toplist/bean/TopListTab;", "", "Lcom/example/homepage/toplist/bean/TopDetail;", "topDetailsStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getTopDetailsStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "loadTopListData", "", "homepage_debug"})
public final class TopListViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<com.example.homepage.toplist.bean.TopListTab, java.util.List<com.example.homepage.toplist.bean.TopDetail>>> _topDetailsStateFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<com.example.homepage.toplist.bean.TopListTab, java.util.List<com.example.homepage.toplist.bean.TopDetail>>> topDetailsStateFlow = null;
    
    public TopListViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<com.example.homepage.toplist.bean.TopListTab, java.util.List<com.example.homepage.toplist.bean.TopDetail>>> getTopDetailsStateFlow() {
        return null;
    }
    
    public final void loadTopListData() {
    }
}