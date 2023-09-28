package com.example.homepage.playSquare.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J$\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/homepage/playSquare/fragment/PlaySquareDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "title", "", "(Ljava/lang/String;)V", "footLayout", "Landroid/view/View;", "loading", "", "mAdapter", "Lcom/example/homepage/playSquare/adapter/PlaylistSquareAdapter;", "getMAdapter", "()Lcom/example/homepage/playSquare/adapter/PlaylistSquareAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "mBinding", "Lcom/example/homepage/databinding/FragmentPlaySquareDetailBinding;", "mViewModel", "Lcom/example/homepage/playSquare/viewmodel/SquareViewModel;", "more", "init", "", "initRvListener", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "initSquareList", "loadList", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "homepage_debug"})
public final class PlaySquareDetailFragment extends androidx.fragment.app.Fragment {
    private final java.lang.String title = null;
    private com.example.homepage.playSquare.viewmodel.SquareViewModel mViewModel;
    private com.example.homepage.databinding.FragmentPlaySquareDetailBinding mBinding;
    private boolean loading = false;
    private boolean more = true;
    private android.view.View footLayout;
    
    /**
     * 歌单广场的适配器
     */
    private final kotlin.Lazy mAdapter$delegate = null;
    
    public PlaySquareDetailFragment(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
        super();
    }
    
    public PlaySquareDetailFragment() {
        super();
    }
    
    /**
     * 歌单广场的适配器
     */
    private final com.example.homepage.playSquare.adapter.PlaylistSquareAdapter getMAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
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
    
    private final void init() {
    }
    
    /**
     * 初始化列表，收集列表
     */
    private final void initSquareList() {
    }
    
    private final void initRvListener(androidx.recyclerview.widget.RecyclerView rv) {
    }
    
    /**
     * 加载更多数据
     */
    private final void loadList() {
    }
}