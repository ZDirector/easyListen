package com.example.common.utils

import android.app.Activity
import java.util.*
import kotlin.system.exitProcess


object ExitUtils {
    private var mActivityList: LinkedList<Activity> = LinkedList()// 装载Activity的容器


    /**
     * 添加Activity实例到mActivityList中，在onCreate()中调用
     *
     * @param activity
     */
    fun addActivity(activity: Activity) {
        if (!mActivityList.contains(activity)) {
            mActivityList.add(activity)
        }
    }


    /**
     * 从容器中删除多余的Activity实例，在onDestroy中调用
     *
     * @param activity
     */
    fun delActivity(activity: Activity) {
        mActivityList.remove(activity)
    }


    /**
     * 退出应用
     */
    fun exitApp() {
        for (activity in mActivityList) {
            activity.finish()
        }
        exitProcess(0)
    }
}