package com.example.homepage.playSquare.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/example/homepage/playSquare/repository/SquareRepository;", "", "()V", "getSongs", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/homepage/playSquare/bean/PlaylistSongsResponse;", "id", "", "limit", "", "offset", "getSquareList", "Lcom/example/homepage/playSquare/bean/HighQualityResponse;", "cat", "", "getTabs", "", "Lcom/example/homepage/playSquare/bean/Sub;", "homepage_debug"})
public final class SquareRepository {
    @org.jetbrains.annotations.NotNull
    public static final com.example.homepage.playSquare.repository.SquareRepository INSTANCE = null;
    
    private SquareRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.homepage.playSquare.bean.HighQualityResponse> getSquareList(int offset, int limit, @org.jetbrains.annotations.NotNull
    java.lang.String cat) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.homepage.playSquare.bean.Sub>> getTabs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.homepage.playSquare.bean.PlaylistSongsResponse> getSongs(long id, int limit, int offset) {
        return null;
    }
}