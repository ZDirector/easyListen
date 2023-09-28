package com.example.homepage.music.bean;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bN\b\u0086\b\u0018\u00002\u00020\u0001B\u00db\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\b\u00a2\u0006\u0002\u0010\"J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u000bH\u00c6\u0003J\t\u0010D\u001a\u00020\u0006H\u00c6\u0003J\t\u0010E\u001a\u00020\u0013H\u00c6\u0003J\t\u0010F\u001a\u00020\u0006H\u00c6\u0003J\t\u0010G\u001a\u00020\u000bH\u00c6\u0003J\t\u0010H\u001a\u00020\u0006H\u00c6\u0003J\t\u0010I\u001a\u00020\u0006H\u00c6\u0003J\t\u0010J\u001a\u00020\u0006H\u00c6\u0003J\t\u0010K\u001a\u00020\u000bH\u00c6\u0003J\t\u0010L\u001a\u00020\u000bH\u00c6\u0003J\t\u0010M\u001a\u00020\u0006H\u00c6\u0003J\t\u0010N\u001a\u00020\u0006H\u00c6\u0003J\t\u0010O\u001a\u00020\bH\u00c6\u0003J\t\u0010P\u001a\u00020\u0006H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0006H\u00c6\u0003J\t\u0010R\u001a\u00020\u0006H\u00c6\u0003J\t\u0010S\u001a\u00020\u0006H\u00c6\u0003J\t\u0010T\u001a\u00020\bH\u00c6\u0003J\t\u0010U\u001a\u00020\bH\u00c6\u0003J\t\u0010V\u001a\u00020\u0006H\u00c6\u0003J\t\u0010W\u001a\u00020\u000bH\u00c6\u0003J\t\u0010X\u001a\u00020\u000bH\u00c6\u0003J\t\u0010Y\u001a\u00020\u0006H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0006H\u00c6\u0003J\t\u0010[\u001a\u00020\u0006H\u00c6\u0003J\u0093\u0002\u0010\\\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\bH\u00c6\u0001J\u0013\u0010]\u001a\u00020\b2\b\u0010^\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010_\u001a\u00020\u0006H\u00d6\u0001J\t\u0010`\u001a\u00020\u000bH\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0011\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010+R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0011\u0010\u0015\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0011\u0010\u0016\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0011\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0011\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0011\u0010\u0019\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0011\u0010\u001a\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0011\u0010\u001b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0011\u0010\u001c\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010(R\u0011\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010&R\u0011\u0010\u001e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0011\u0010\u001f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0011\u0010 \u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010&R\u0011\u0010!\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010(\u00a8\u0006a"}, d2 = {"Lcom/example/homepage/music/bean/Privilege;", "", "chargeInfoList", "", "Lcom/example/homepage/music/bean/ChargeInfo;", "cp", "", "cs", "", "dl", "dlLevel", "", "downloadMaxBrLevel", "downloadMaxbr", "fee", "fl", "flLevel", "flag", "freeTrialPrivilege", "Lcom/example/homepage/music/bean/FreeTrialPrivilege;", "id", "maxBrLevel", "maxbr", "payed", "pl", "plLevel", "playMaxBrLevel", "playMaxbr", "preSell", "rscl", "sp", "st", "subp", "toast", "(Ljava/util/List;IZILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;ILcom/example/homepage/music/bean/FreeTrialPrivilege;ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;IZIIIIZ)V", "getChargeInfoList", "()Ljava/util/List;", "getCp", "()I", "getCs", "()Z", "getDl", "getDlLevel", "()Ljava/lang/String;", "getDownloadMaxBrLevel", "getDownloadMaxbr", "getFee", "getFl", "getFlLevel", "getFlag", "getFreeTrialPrivilege", "()Lcom/example/homepage/music/bean/FreeTrialPrivilege;", "getId", "getMaxBrLevel", "getMaxbr", "getPayed", "getPl", "getPlLevel", "getPlayMaxBrLevel", "getPlayMaxbr", "getPreSell", "getRscl", "getSp", "getSt", "getSubp", "getToast", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "homepage_debug"})
public final class Privilege {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.homepage.music.bean.ChargeInfo> chargeInfoList = null;
    private final int cp = 0;
    private final boolean cs = false;
    private final int dl = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String dlLevel = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String downloadMaxBrLevel = null;
    private final int downloadMaxbr = 0;
    private final int fee = 0;
    private final int fl = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String flLevel = null;
    private final int flag = 0;
    @org.jetbrains.annotations.NotNull
    private final com.example.homepage.music.bean.FreeTrialPrivilege freeTrialPrivilege = null;
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String maxBrLevel = null;
    private final int maxbr = 0;
    private final int payed = 0;
    private final int pl = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String plLevel = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String playMaxBrLevel = null;
    private final int playMaxbr = 0;
    private final boolean preSell = false;
    private final int rscl = 0;
    private final int sp = 0;
    private final int st = 0;
    private final int subp = 0;
    private final boolean toast = false;
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Privilege copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.homepage.music.bean.ChargeInfo> chargeInfoList, int cp, boolean cs, int dl, @org.jetbrains.annotations.NotNull
    java.lang.String dlLevel, @org.jetbrains.annotations.NotNull
    java.lang.String downloadMaxBrLevel, int downloadMaxbr, int fee, int fl, @org.jetbrains.annotations.NotNull
    java.lang.String flLevel, int flag, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.FreeTrialPrivilege freeTrialPrivilege, int id, @org.jetbrains.annotations.NotNull
    java.lang.String maxBrLevel, int maxbr, int payed, int pl, @org.jetbrains.annotations.NotNull
    java.lang.String plLevel, @org.jetbrains.annotations.NotNull
    java.lang.String playMaxBrLevel, int playMaxbr, boolean preSell, int rscl, int sp, int st, int subp, boolean toast) {
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
    
    public Privilege(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.homepage.music.bean.ChargeInfo> chargeInfoList, int cp, boolean cs, int dl, @org.jetbrains.annotations.NotNull
    java.lang.String dlLevel, @org.jetbrains.annotations.NotNull
    java.lang.String downloadMaxBrLevel, int downloadMaxbr, int fee, int fl, @org.jetbrains.annotations.NotNull
    java.lang.String flLevel, int flag, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.FreeTrialPrivilege freeTrialPrivilege, int id, @org.jetbrains.annotations.NotNull
    java.lang.String maxBrLevel, int maxbr, int payed, int pl, @org.jetbrains.annotations.NotNull
    java.lang.String plLevel, @org.jetbrains.annotations.NotNull
    java.lang.String playMaxBrLevel, int playMaxbr, boolean preSell, int rscl, int sp, int st, int subp, boolean toast) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.homepage.music.bean.ChargeInfo> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.homepage.music.bean.ChargeInfo> getChargeInfoList() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getCp() {
        return 0;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean getCs() {
        return false;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getDl() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDlLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDownloadMaxBrLevel() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int getDownloadMaxbr() {
        return 0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getFee() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getFl() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFlLevel() {
        return null;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int getFlag() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.FreeTrialPrivilege component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.FreeTrialPrivilege getFreeTrialPrivilege() {
        return null;
    }
    
    public final int component13() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMaxBrLevel() {
        return null;
    }
    
    public final int component15() {
        return 0;
    }
    
    public final int getMaxbr() {
        return 0;
    }
    
    public final int component16() {
        return 0;
    }
    
    public final int getPayed() {
        return 0;
    }
    
    public final int component17() {
        return 0;
    }
    
    public final int getPl() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPlLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPlayMaxBrLevel() {
        return null;
    }
    
    public final int component20() {
        return 0;
    }
    
    public final int getPlayMaxbr() {
        return 0;
    }
    
    public final boolean component21() {
        return false;
    }
    
    public final boolean getPreSell() {
        return false;
    }
    
    public final int component22() {
        return 0;
    }
    
    public final int getRscl() {
        return 0;
    }
    
    public final int component23() {
        return 0;
    }
    
    public final int getSp() {
        return 0;
    }
    
    public final int component24() {
        return 0;
    }
    
    public final int getSt() {
        return 0;
    }
    
    public final int component25() {
        return 0;
    }
    
    public final int getSubp() {
        return 0;
    }
    
    public final boolean component26() {
        return false;
    }
    
    public final boolean getToast() {
        return false;
    }
}