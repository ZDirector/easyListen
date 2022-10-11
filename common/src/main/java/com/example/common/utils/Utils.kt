package com.example.common.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.view.WindowCompat

private var toast: Toast? = null

/**
 * Toast，会自动取消上一个，保证不让 Toast 乱弹
 * */
fun showToast(msg: String, time: Int = Toast.LENGTH_SHORT) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
        toast?.cancel()
        toast = Toast.makeText(MyApplication.context, msg, time).apply { show() }
    } else {
        Handler(Looper.getMainLooper()).post {
            toast?.cancel()
            toast = Toast.makeText(MyApplication.context, msg, time).apply { show() }
        }
    }
}

/**
 * 设置状态栏颜色
 */
fun Activity.setStatusBarColor(color: Int) {
    window.statusBarColor = color
}

/**
 * 状态栏文字颜色
 */
fun Activity.setStatusBarTextColor(isStateBarTextBlack: Boolean) {
    WindowCompat.getInsetsController(
        window,
        window.decorView
    ).isAppearanceLightStatusBars = isStateBarTextBlack
}

/**
 * 获取当前是否为深色模式
 * @return true 为深色模式  false 为浅色模式
 */
val Context.isDarkMode: Boolean
    get() = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK ==
            Configuration.UI_MODE_NIGHT_YES

/** 获取屏幕的高度  */
val Context.windowsHeight: Int
    get() = resources.displayMetrics.heightPixels

/** 获取屏幕的宽度  */
val Context.windowsWidth: Int
    get() = resources.displayMetrics.widthPixels

/**
 * 根据手机的分辨率从 px 的单位转成为 dp
 */
val Int.px2dp: Int
    get() = (this / MyApplication.context.resources.displayMetrics.density).toInt()

/**
 * 根据手机的分辨率从 dp 的单位转成为 px
 */
val Int.dp2px: Int
    get() = (this * MyApplication.context.resources.displayMetrics.density).toInt()

/**
 * 根据手机的分辨率从 px 的单位转成为 sp
 */
val Int.px2sp: Int
    get() = (this / MyApplication.context.resources.displayMetrics.scaledDensity).toInt()

/**
 * 根据手机的分辨率从 sp 的单位转成为 px
 */
val Int.sp2px: Int
    get() = (this * MyApplication.context.resources.displayMetrics.scaledDensity).toInt()

