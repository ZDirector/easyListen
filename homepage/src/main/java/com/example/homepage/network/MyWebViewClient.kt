package com.example.homepage.network

import android.content.Intent
import android.net.Uri

import android.webkit.WebView

import android.webkit.WebViewClient


class MyWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        val uri: Uri = Uri.parse(url)
        if (uri.host != null) {
            return false
        }
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        view.context.startActivity(intent)
        return true
    }
}