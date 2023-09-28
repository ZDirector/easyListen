package com.example.homepage.toplist.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0002J\u0012\u00100\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020-H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001c\u0010\u0014R\u001b\u0010\u001e\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b\u001f\u0010\u0014R\u000e\u0010!\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u000e\u001a\u0004\b$\u0010%R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/example/homepage/toplist/ui/activity/TopListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "h1", "", "h2", "h3", "h4", "h5", "mAdapter", "Lcom/example/homepage/toplist/adapter/OfficialAdapter;", "getMAdapter", "()Lcom/example/homepage/toplist/adapter/OfficialAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "mBinding", "Lcom/example/homepage/databinding/ActivityTopListBinding;", "mFeaturesAdapter", "Lcom/example/homepage/toplist/adapter/TopOtherAdapter;", "getMFeaturesAdapter", "()Lcom/example/homepage/toplist/adapter/TopOtherAdapter;", "mFeaturesAdapter$delegate", "mGlobalAdapter", "getMGlobalAdapter", "mGlobalAdapter$delegate", "mScrollviewFlag", "", "mSelectAdapter", "getMSelectAdapter", "mSelectAdapter$delegate", "mStyleAdapter", "getMStyleAdapter", "mStyleAdapter$delegate", "mTabIndex", "mViewModel", "Lcom/example/homepage/toplist/viewmodel/TopListViewModel;", "getMViewModel", "()Lcom/example/homepage/toplist/viewmodel/TopListViewModel;", "mViewModel$delegate", "mViewTreeObserver", "Landroid/view/ViewTreeObserver;", "calculateView", "view", "Landroid/view/View;", "composeTabScroll", "", "init", "initBottomImmersive", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setEachRv", "homepage_debug"})
public final class TopListActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.homepage.databinding.ActivityTopListBinding mBinding;
    private final kotlin.Lazy mViewModel$delegate = null;
    private final kotlin.Lazy mAdapter$delegate = null;
    private final kotlin.Lazy mFeaturesAdapter$delegate = null;
    private final kotlin.Lazy mGlobalAdapter$delegate = null;
    private final kotlin.Lazy mStyleAdapter$delegate = null;
    private final kotlin.Lazy mSelectAdapter$delegate = null;
    private int mTabIndex = 0;
    private boolean mScrollviewFlag = false;
    private int h1 = 0;
    private int h2 = 0;
    private int h3 = 0;
    private int h4 = 0;
    private int h5 = 0;
    private android.view.ViewTreeObserver mViewTreeObserver;
    
    public TopListActivity() {
        super();
    }
    
    private final com.example.homepage.toplist.viewmodel.TopListViewModel getMViewModel() {
        return null;
    }
    
    private final com.example.homepage.toplist.adapter.OfficialAdapter getMAdapter() {
        return null;
    }
    
    private final com.example.homepage.toplist.adapter.TopOtherAdapter getMFeaturesAdapter() {
        return null;
    }
    
    private final com.example.homepage.toplist.adapter.TopOtherAdapter getMGlobalAdapter() {
        return null;
    }
    
    private final com.example.homepage.toplist.adapter.TopOtherAdapter getMStyleAdapter() {
        return null;
    }
    
    private final com.example.homepage.toplist.adapter.TopOtherAdapter getMSelectAdapter() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initBottomImmersive() {
    }
    
    private final void init() {
    }
    
    private final void setEachRv() {
    }
    
    private final void composeTabScroll() {
    }
    
    private final int calculateView(android.view.View view) {
        return 0;
    }
}