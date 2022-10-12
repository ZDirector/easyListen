package com.example.search.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010\'\u001a\u00020\"H\u0002J\u0012\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@VX\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@VX\u0094\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\f\u00a8\u0006+"}, d2 = {"Lcom/example/search/ui/SearchActivity;", "Lcom/example/common/baseui/BaseActivity;", "Lcom/example/search/databinding/ActivitySearchBinding;", "Lcom/example/search/viewmodel/SearchViewModel;", "Landroid/view/View$OnClickListener;", "()V", "<set-?>", "", "layoutId", "getLayoutId", "()I", "setLayoutId", "(I)V", "searchBackImg", "Landroid/widget/ImageView;", "searchEditTextClear", "searchHistoryClear", "searchHistoryLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "searchHistoryRel", "Landroidx/recyclerview/widget/RecyclerView;", "searchHotRel", "searchRecommendRel", "searchScroll", "Landroidx/core/widget/NestedScrollView;", "searchSuggestLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "searchSuggestRel", "searchTextInput", "Lcom/google/android/material/textfield/TextInputEditText;", "variableId", "getVariableId", "setVariableId", "initData", "", "savedInstanceState", "Landroid/os/Bundle;", "initListener", "initObserve", "initView", "onClick", "v", "Landroid/view/View;", "search_debug"})
public final class SearchActivity extends com.example.common.baseui.BaseActivity<com.example.search.databinding.ActivitySearchBinding, com.example.search.viewmodel.SearchViewModel> implements android.view.View.OnClickListener {
    private int layoutId = com.example.search.R.layout.activity_search;
    private int variableId;
    private android.widget.ImageView searchBackImg;
    private com.google.android.material.textfield.TextInputEditText searchTextInput;
    private android.widget.ImageView searchEditTextClear;
    private androidx.constraintlayout.widget.ConstraintLayout searchHistoryLayout;
    private android.widget.ImageView searchHistoryClear;
    private androidx.recyclerview.widget.RecyclerView searchHistoryRel;
    private androidx.recyclerview.widget.RecyclerView searchRecommendRel;
    private androidx.recyclerview.widget.RecyclerView searchSuggestRel;
    private androidx.recyclerview.widget.RecyclerView searchHotRel;
    private androidx.core.widget.NestedScrollView searchScroll;
    private final androidx.recyclerview.widget.LinearLayoutManager searchSuggestLayoutManager = null;
    
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
    
    private final void initObserve() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
}