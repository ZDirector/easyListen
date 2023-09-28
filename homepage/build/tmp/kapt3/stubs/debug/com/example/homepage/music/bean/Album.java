package com.example.homepage.music.bean;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\bL\b\u0086\b\u0018\u00002\u00020\u0001B\u00e1\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\u0001\u0012\u0006\u0010!\u001a\u00020\b\u00a2\u0006\u0002\u0010\"J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\bH\u00c6\u0003J\t\u0010F\u001a\u00020\rH\u00c6\u0003J\t\u0010G\u001a\u00020\rH\u00c6\u0003J\t\u0010H\u001a\u00020\rH\u00c6\u0003J\t\u0010I\u001a\u00020\bH\u00c6\u0003J\t\u0010J\u001a\u00020\u0015H\u00c6\u0003J\t\u0010K\u001a\u00020\u0017H\u00c6\u0003J\t\u0010L\u001a\u00020\u0017H\u00c6\u0003J\t\u0010M\u001a\u00020\bH\u00c6\u0003J\t\u0010N\u001a\u00020\bH\u00c6\u0003J\t\u0010O\u001a\u00020\u0005H\u00c6\u0003J\t\u0010P\u001a\u00020\u0017H\u00c6\u0003J\t\u0010Q\u001a\u00020\rH\u00c6\u0003J\t\u0010R\u001a\u00020\rH\u00c6\u0003J\t\u0010S\u001a\u00020\bH\u00c6\u0003J\t\u0010T\u001a\u00020\bH\u00c6\u0003J\t\u0010U\u001a\u00020\u0001H\u00c6\u0003J\t\u0010V\u001a\u00020\bH\u00c6\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J\t\u0010X\u001a\u00020\bH\u00c6\u0003J\t\u0010Y\u001a\u00020\bH\u00c6\u0003J\t\u0010Z\u001a\u00020\bH\u00c6\u0003J\t\u0010[\u001a\u00020\u0001H\u00c6\u0003J\t\u0010\\\u001a\u00020\rH\u00c6\u0003J\t\u0010]\u001a\u00020\rH\u00c6\u0003J\u0099\u0002\u0010^\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\bH\u00c6\u0001J\u0013\u0010_\u001a\u00020\u00152\b\u0010`\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010a\u001a\u00020\rH\u00d6\u0001J\t\u0010b\u001a\u00020\bH\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010$R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010\u000b\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0011\u0010\u0011\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0011\u0010\u0012\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0011\u0010\u0013\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u0011\u0010\u0019\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0011\u0010\u001a\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0011\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u00109R\u0011\u0010\u001c\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010/R\u0011\u0010\u001d\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010/R\u0011\u0010\u001e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010)R\u0011\u0010\u001f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u0011\u0010 \u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0011\u0010!\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010)\u00a8\u0006c"}, d2 = {"Lcom/example/homepage/music/bean/Album;", "", "alias", "", "artist", "Lcom/example/homepage/music/bean/ArtistXXX;", "artists", "blurPicUrl", "", "briefDesc", "commentThreadId", "company", "companyId", "", "copyrightId", "description", "gapless", "id", "mark", "name", "onSale", "", "pic", "", "picId", "picId_str", "picUrl", "publishTime", "size", "status", "subType", "tags", "transName", "type", "(Ljava/util/List;Lcom/example/homepage/music/bean/ArtistXXX;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;IILjava/lang/String;IIILjava/lang/String;ZJJLjava/lang/String;Ljava/lang/String;JIILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getAlias", "()Ljava/util/List;", "getArtist", "()Lcom/example/homepage/music/bean/ArtistXXX;", "getArtists", "getBlurPicUrl", "()Ljava/lang/String;", "getBriefDesc", "getCommentThreadId", "getCompany", "()Ljava/lang/Object;", "getCompanyId", "()I", "getCopyrightId", "getDescription", "getGapless", "getId", "getMark", "getName", "getOnSale", "()Z", "getPic", "()J", "getPicId", "getPicId_str", "getPicUrl", "getPublishTime", "getSize", "getStatus", "getSubType", "getTags", "getTransName", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "homepage_debug"})
public final class Album {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Object> alias = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.homepage.music.bean.ArtistXXX artist = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.homepage.music.bean.ArtistXXX> artists = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String blurPicUrl = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String briefDesc = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String commentThreadId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object company = null;
    private final int companyId = 0;
    private final int copyrightId = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    private final int gapless = 0;
    private final int id = 0;
    private final int mark = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    private final boolean onSale = false;
    private final long pic = 0L;
    private final long picId = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String picId_str = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String picUrl = null;
    private final long publishTime = 0L;
    private final int size = 0;
    private final int status = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String subType = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String tags = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object transName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String type = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Album copy(@org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> alias, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.ArtistXXX artist, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.homepage.music.bean.ArtistXXX> artists, @org.jetbrains.annotations.NotNull
    java.lang.String blurPicUrl, @org.jetbrains.annotations.NotNull
    java.lang.String briefDesc, @org.jetbrains.annotations.NotNull
    java.lang.String commentThreadId, @org.jetbrains.annotations.NotNull
    java.lang.Object company, int companyId, int copyrightId, @org.jetbrains.annotations.NotNull
    java.lang.String description, int gapless, int id, int mark, @org.jetbrains.annotations.NotNull
    java.lang.String name, boolean onSale, long pic, long picId, @org.jetbrains.annotations.NotNull
    java.lang.String picId_str, @org.jetbrains.annotations.NotNull
    java.lang.String picUrl, long publishTime, int size, int status, @org.jetbrains.annotations.NotNull
    java.lang.String subType, @org.jetbrains.annotations.NotNull
    java.lang.String tags, @org.jetbrains.annotations.NotNull
    java.lang.Object transName, @org.jetbrains.annotations.NotNull
    java.lang.String type) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Album(@org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> alias, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.ArtistXXX artist, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.homepage.music.bean.ArtistXXX> artists, @org.jetbrains.annotations.NotNull
    java.lang.String blurPicUrl, @org.jetbrains.annotations.NotNull
    java.lang.String briefDesc, @org.jetbrains.annotations.NotNull
    java.lang.String commentThreadId, @org.jetbrains.annotations.NotNull
    java.lang.Object company, int companyId, int copyrightId, @org.jetbrains.annotations.NotNull
    java.lang.String description, int gapless, int id, int mark, @org.jetbrains.annotations.NotNull
    java.lang.String name, boolean onSale, long pic, long picId, @org.jetbrains.annotations.NotNull
    java.lang.String picId_str, @org.jetbrains.annotations.NotNull
    java.lang.String picUrl, long publishTime, int size, int status, @org.jetbrains.annotations.NotNull
    java.lang.String subType, @org.jetbrains.annotations.NotNull
    java.lang.String tags, @org.jetbrains.annotations.NotNull
    java.lang.Object transName, @org.jetbrains.annotations.NotNull
    java.lang.String type) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> getAlias() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.ArtistXXX component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.ArtistXXX getArtist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.homepage.music.bean.ArtistXXX> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.homepage.music.bean.ArtistXXX> getArtists() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBlurPicUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBriefDesc() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCommentThreadId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getCompany() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getCompanyId() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getCopyrightId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int getGapless() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final int component13() {
        return 0;
    }
    
    public final int getMark() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final boolean getOnSale() {
        return false;
    }
    
    public final long component16() {
        return 0L;
    }
    
    public final long getPic() {
        return 0L;
    }
    
    public final long component17() {
        return 0L;
    }
    
    public final long getPicId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPicId_str() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPicUrl() {
        return null;
    }
    
    public final long component20() {
        return 0L;
    }
    
    public final long getPublishTime() {
        return 0L;
    }
    
    public final int component21() {
        return 0;
    }
    
    public final int getSize() {
        return 0;
    }
    
    public final int component22() {
        return 0;
    }
    
    public final int getStatus() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSubType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getTransName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getType() {
        return null;
    }
}