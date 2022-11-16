package com.example.search.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\u0006\u0010\'\u001a\u00020$J\u0006\u0010(\u001a\u00020$J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020$2\u0006\u0010+\u001a\u00020\fR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R(\u0010\u001e\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001f0\u001f0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0013\u00a8\u0006,"}, d2 = {"Lcom/example/search/viewmodel/SearchViewModel;", "Lcom/example/common/baseui/BaseViewModel;", "()V", "_hotSearchList", "Landroidx/lifecycle/MutableLiveData;", "", "", "_recommendSearchList", "_searchHistoryList", "_searchSuggestList", "initMission", "Ljava/util/HashMap;", "", "getInitMission", "()Landroidx/lifecycle/MutableLiveData;", "isSearchResultFinishLoading", "keyWords", "getKeyWords", "setKeyWords", "(Landroidx/lifecycle/MutableLiveData;)V", "mHotSearchList", "Landroidx/lifecycle/LiveData;", "getMHotSearchList", "()Landroidx/lifecycle/LiveData;", "mRecommendSearchList", "getMRecommendSearchList", "mSearchHistoryList", "getMSearchHistoryList", "mSearchSuggestList", "getMSearchSuggestList", "viewMode", "", "kotlin.jvm.PlatformType", "getViewMode", "setViewMode", "addSearchHistory", "", "delAllSearchHistory", "getHotSearchList", "getRecommendSearchList", "getSearchHistory", "getSearchSuggest", "ketWords", "isFinish", "search_debug"})
public final class SearchViewModel extends com.example.common.baseui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _searchSuggestList = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _hotSearchList = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _recommendSearchList = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _searchHistoryList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.HashMap<java.lang.String, java.lang.Boolean>> initMission = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> keyWords;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isSearchResultFinishLoading = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> viewMode;
    
    public SearchViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getMSearchSuggestList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getMHotSearchList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getMRecommendSearchList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getMSearchHistoryList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.HashMap<java.lang.String, java.lang.Boolean>> getInitMission() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getKeyWords() {
        return null;
    }
    
    public final void setKeyWords(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isSearchResultFinishLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getViewMode() {
        return null;
    }
    
    public final void setViewMode(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    public final void getSearchSuggest(@org.jetbrains.annotations.NotNull()
    java.lang.String ketWords) {
    }
    
    public final void getHotSearchList() {
    }
    
    public final void getRecommendSearchList() {
    }
    
    public final void getSearchHistory() {
    }
    
    public final void addSearchHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String keyWords) {
    }
    
    public final void delAllSearchHistory() {
    }
    
    public final void isSearchResultFinishLoading(boolean isFinish) {
    }
}