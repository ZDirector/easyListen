package com.example.homepage.activity

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.common.utils.MyApplication.Companion.context
import com.example.homepage.R
import com.example.homepage.databinding.ActivityWebBinding
import com.example.homepage.network.MyWebViewClient
import com.example.homepage.utils.WebUtils


class WebActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_web)
        init()
    }

    private fun init() {
        mBinding.apply {
            web.webViewClient = WebViewClient()
            val webSettings = web.settings
            webSettings.useWideViewPort = true
            webSettings.loadWithOverviewMode = true
            webSettings.javaScriptEnabled = true
            webSettings.domStorageEnabled = true
            intent.getStringExtra("url")?.let { web.loadUrl(it) }
            web.webViewClient = MyWebViewClient()
            if (WebUtils.isWifi(context)) {
                //当前有可用网络
                webSettings.cacheMode =
                    WebSettings.LOAD_DEFAULT//设置 缓存模式( 根据cache-control决定是否从网络上取数据。)
            } else {
                //当前没有可用网络
                webSettings.cacheMode =
                    WebSettings.LOAD_CACHE_ELSE_NETWORK  //设置 缓存模式(只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。)
            }
            web.webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    progressBar.progress = newProgress;
                    if (newProgress == 100) {
                        //加载完毕隐藏进度条
                        progressBar.visibility = View.GONE
                    }
                    super.onProgressChanged(view, newProgress)
                }
            }
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        if (mBinding.web.canGoBack()) {
            mBinding.web.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
