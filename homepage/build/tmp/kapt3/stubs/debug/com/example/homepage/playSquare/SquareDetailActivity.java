package com.example.homepage.playSquare;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/homepage/playSquare/SquareDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "loading", "", "mAdapter", "Lcom/example/homepage/playSquare/adapter/SongsAdapter;", "getMAdapter", "()Lcom/example/homepage/playSquare/adapter/SongsAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "mBinding", "Lcom/example/homepage/databinding/ActivitySquareDetailBinding;", "mFootView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getMFootView", "()Landroid/view/View;", "mFootView$delegate", "mMainColor", "", "mMore", "mViewModel", "Lcom/example/homepage/playSquare/viewmodel/PlayListDetailViewModel;", "getPicColor", "", "init", "initColor", "initList", "initSongs", "loadList", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setImageView", "setToolBar", "Companion", "homepage_debug"})
public final class SquareDetailActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.homepage.databinding.ActivitySquareDetailBinding mBinding;
    private com.example.homepage.playSquare.viewmodel.PlayListDetailViewModel mViewModel;
    private int mMainColor = 0;
    private boolean mMore = true;
    private boolean loading = false;
    private final kotlin.Lazy mAdapter$delegate = null;
    private final kotlin.Lazy mFootView$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.homepage.playSquare.SquareDetailActivity.Companion Companion = null;
    
    public SquareDetailActivity() {
        super();
    }
    
    private final com.example.homepage.playSquare.adapter.SongsAdapter getMAdapter() {
        return null;
    }
    
    private final android.view.View getMFootView() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getPicColor() {
    }
    
    private final void initColor() {
    }
    
    private final void setToolBar() {
    }
    
    private final void init() {
    }
    
    private final void initSongs() {
    }
    
    private final void loadList() {
    }
    
    private final void initList() {
    }
    
    private final void setImageView() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/homepage/playSquare/SquareDetailActivity$Companion;", "", "()V", "getStatusBarHeight", "", "context", "Landroid/content/Context;", "homepage_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int getStatusBarHeight(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return 0;
        }
    }
}