package com.example.homepage.music.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/homepage/music/fragment/MusicFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/youth/banner/listener/OnBannerListener;", "Lcom/example/homepage/music/bean/Banner;", "()V", "mAdapter", "Lcom/youth/banner/adapter/BannerImageAdapter;", "mBinding", "Lcom/example/homepage/databinding/FragmentMusicBinding;", "mList", "", "mRankAdapter", "Lcom/example/homepage/music/adapter/RankListAdapter;", "mRanks", "Lcom/example/homepage/music/bean/Rank;", "mViewModel", "Lcom/example/homepage/music/viewmodel/MusicViewModel;", "OnBannerClick", "", "data", "position", "", "init", "initBanner", "initListener", "initRecommendedList", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Companion", "homepage_debug"})
public final class MusicFragment extends androidx.fragment.app.Fragment implements com.youth.banner.listener.OnBannerListener<com.example.homepage.music.bean.Banner> {
    private com.example.homepage.databinding.FragmentMusicBinding mBinding;
    private com.example.homepage.music.viewmodel.MusicViewModel mViewModel;
    private java.util.List<com.example.homepage.music.bean.Banner> mList;
    private java.util.List<com.example.homepage.music.bean.Rank> mRanks;
    private com.example.homepage.music.adapter.RankListAdapter mRankAdapter;
    private final com.youth.banner.adapter.BannerImageAdapter<com.example.homepage.music.bean.Banner> mAdapter = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.homepage.music.fragment.MusicFragment.Companion Companion = null;
    
    public MusicFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initListener() {
    }
    
    private final void init() {
    }
    
    private final void initRecommendedList() {
    }
    
    private final void initBanner() {
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final com.example.homepage.music.fragment.MusicFragment newInstance(@org.jetbrains.annotations.NotNull
    java.lang.String param1, @org.jetbrains.annotations.NotNull
    java.lang.String param2) {
        return null;
    }
    
    @java.lang.Override
    public void OnBannerClick(@org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.Banner data, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/homepage/music/fragment/MusicFragment$Companion;", "", "()V", "newInstance", "Lcom/example/homepage/music/fragment/MusicFragment;", "param1", "", "param2", "homepage_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @kotlin.jvm.JvmStatic
        public final com.example.homepage.music.fragment.MusicFragment newInstance(@org.jetbrains.annotations.NotNull
        java.lang.String param1, @org.jetbrains.annotations.NotNull
        java.lang.String param2) {
            return null;
        }
    }
}