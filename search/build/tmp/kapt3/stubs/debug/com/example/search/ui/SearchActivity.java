package com.example.search.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u001aH\u0016J\u0012\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u0015H\u0002J\b\u0010\'\u001a\u00020\u001aH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@VX\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0012\u0012\u0006\b\u0001\u0012\u00020\u00130\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@VX\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e\u00a8\u0006("}, d2 = {"Lcom/example/search/ui/SearchActivity;", "Lcom/example/common/baseui/BaseActivity;", "Lcom/example/search/databinding/ActivitySearchBinding;", "Lcom/example/search/viewmodel/SearchViewModel;", "Landroid/view/View$OnClickListener;", "()V", "isSuggestToSearch", "", "<set-?>", "", "layoutId", "getLayoutId", "()I", "setLayoutId", "(I)V", "pageList", "", "Lcom/example/common/baseui/BaseFragment;", "Landroidx/databinding/ViewDataBinding;", "Lcom/example/common/baseui/BaseViewModel;", "titleList", "", "variableId", "getVariableId", "setVariableId", "finishLoading", "", "initData", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initObserve", "initView", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onClickSearch", "keyWords", "startLoading", "search_debug"})
public final class SearchActivity extends com.example.common.baseui.BaseActivity<com.example.search.databinding.ActivitySearchBinding, com.example.search.viewmodel.SearchViewModel> implements android.view.View.OnClickListener {
    private int layoutId = com.example.search.R.layout.activity_search;
    private int variableId;
    private final java.util.List<java.lang.String> titleList = null;
    private final java.util.List<com.example.common.baseui.BaseFragment<? extends androidx.databinding.ViewDataBinding, ? extends com.example.common.baseui.BaseViewModel>> pageList = null;
    private boolean isSuggestToSearch = false;
    
    public SearchActivity() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutId() {
        return 0;
    }
    
    public void setLayoutId(int p0) {
    }
    
    @java.lang.Override()
    protected int getVariableId() {
        return 0;
    }
    
    public void setVariableId(int p0) {
    }
    
    @java.lang.Override()
    protected void initData(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void initListener() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void initObserve() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void startLoading() {
    }
    
    private final void finishLoading() {
    }
    
    private final void onClickSearch(java.lang.String keyWords) {
    }
}