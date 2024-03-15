package com.example.common.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.view.WindowCompat
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

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

fun showToast(resId: Int, time: Int = Toast.LENGTH_SHORT) {
    showToast(MyApplication.context.getString(resId), time)
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

fun String.toMd5() : String{
    try {
        val instance : MessageDigest = MessageDigest.getInstance("MD5")//获取md5加密对象
        val digest:ByteArray = instance.digest(this.toByteArray())//对字符串加密，返回字节数组
        val sb = StringBuffer()
        for (b in digest) {
            val i :Int = b.toInt() and 0xff//获取低八位有效值
            var hexString = Integer.toHexString(i)//将整数转化为16进制
            if (hexString.length < 2) {
                hexString = "0$hexString"//如果是一位的话，补0
            }
            sb.append(hexString)
        }
        return sb.toString()

    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}

