package com.example.homepage.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/homepage/activity/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mBinding", "Lcom/example/homepage/databinding/ActivityHomeBinding;", "mCareFragment", "Lcom/example/homepage/ui/fragment/CareFragment;", "mMineFragment", "Lcom/example/homepage/ui/fragment/MineFragment;", "mMusicFragment", "Lcom/example/homepage/music/fragment/MusicFragment;", "mVideoFragment", "Lcom/example/homepage/ui/fragment/VideoFragment;", "hideFragments", "", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "immersive", "init", "initListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setFragment", "index", "", "homepage_debug"})
public final class HomeActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.homepage.databinding.ActivityHomeBinding mBinding;
    private com.example.homepage.music.fragment.MusicFragment mMusicFragment;
    private com.example.homepage.ui.fragment.CareFragment mCareFragment;
    private com.example.homepage.ui.fragment.VideoFragment mVideoFragment;
    private com.example.homepage.ui.fragment.MineFragment mMineFragment;
    
    public HomeActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void init() {
    }
    
    private final void initListener() {
    }
    
    /**
     * 沉浸式处理
     */
    private final void immersive() {
    }
    
    private final void setFragment(int index) {
    }
    
    private final void hideFragments(androidx.fragment.app.FragmentTransaction transaction) {
    }
}