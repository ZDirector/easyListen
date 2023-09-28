package com.example.homepage.music.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/example/homepage/music/adapter/RankListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/homepage/music/adapter/RankListAdapter$RankViewHolder;", "list", "", "Lcom/example/homepage/music/bean/Rank;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "RankViewHolder", "homepage_debug"})
public final class RankListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.homepage.music.adapter.RankListAdapter.RankViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.homepage.music.bean.Rank> list = null;
    
    public RankListAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.homepage.music.bean.Rank> list) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.homepage.music.bean.Rank> getList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.homepage.music.adapter.RankListAdapter.RankViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.homepage.music.adapter.RankListAdapter.RankViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/homepage/music/adapter/RankListAdapter$RankViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/homepage/music/adapter/RankListAdapter;Landroid/view/View;)V", "mBinding", "Lcom/example/homepage/databinding/ItemListRankingBinding;", "getMBinding", "()Lcom/example/homepage/databinding/ItemListRankingBinding;", "setMBinding", "(Lcom/example/homepage/databinding/ItemListRankingBinding;)V", "homepage_debug"})
    public final class RankViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.example.homepage.databinding.ItemListRankingBinding mBinding;
        
        public RankViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.homepage.databinding.ItemListRankingBinding getMBinding() {
            return null;
        }
        
        public final void setMBinding(@org.jetbrains.annotations.NotNull
        com.example.homepage.databinding.ItemListRankingBinding p0) {
        }
    }
}