package com.example.homepage.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/homepage/network/MyWebViewClient;", "Landroid/webkit/WebViewClient;", "()V", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "homepage_debug"})
public final class MyWebViewClient extends android.webkit.WebViewClient {
    
    public MyWebViewClient() {
        super();
    }
    
    @java.lang.Override
    public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.NotNull
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull
    java.lang.String url) {
        return false;
    }
}