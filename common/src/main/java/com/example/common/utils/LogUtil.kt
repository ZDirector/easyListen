package com.example.common.utils

import android.content.pm.ApplicationInfo
import android.util.Log

object LogUtil {
    private const val IS_DEBUG = true

    var Tag: String = "default"

    private fun isDebug(): Boolean{
        // 要关闭调试输出 log 的两种方法：
        // 1. 只需要把对应的 manifest.xml 中的 application 节点中的 debuggable 改为 false 即可
        // 2. 将 IS_DEBUG 值设置为 false
        return MyApplication.context.applicationInfo.flags.and(ApplicationInfo.FLAG_DEBUGGABLE) != 0 && IS_DEBUG
    }

    // error, 红色
    fun e(tag: String = Tag, msg: String){
        if (isDebug()) Log.e(tag, "error: $msg", )
    }

    // verbose, 黑色
    fun v(tag: String = Tag, msg: String){
        if (isDebug()) Log.v(tag, "verbose: $msg")
    }

    // information, 绿色
    fun i(tag: String = Tag, msg: String){
        if (isDebug()) Log.i(tag, "information: $msg")
    }

    // warning, 橙色
    fun w(tag: String = Tag, msg: String){
        if (isDebug()) Log.w(tag, "warning: $msg")
    }

    // debug, 蓝色
    fun d(tag: String = Tag, msg: String){
        if (isDebug()) Log.d(tag, "debug: $msg")
    }
}