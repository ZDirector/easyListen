package com.example.common.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.common.BuildConfig
import java.util.Stack

class ActivityLifeCycle : Application.ActivityLifecycleCallbacks {

    private var activityCount = 0
    private var isForeground = false
    var topActivity: Activity? = null
        private set
    private var activityStack = Stack<Activity>()

    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
        if (BuildConfig.DEBUG) {
            LogUtil.d("ActivityLifeCycle", "onActivityCreated: ${activity.localClassName}")
        }
        activityStack.add(activity)
    }

    override fun onActivityStarted(activity: Activity) {
        if (BuildConfig.DEBUG) {
            LogUtil.d("ActivityLifeCycle", "onActivityStarted: ${activity.localClassName}")
        }
        activityCount++
        if (!isForeground) {
            isForeground = true
            // App进入前台
            if (BuildConfig.DEBUG) {
                LogUtil.d("ActivityLifeCycle", "App进入前台")
            }
        }
    }

    override fun onActivityResumed(activity: Activity) {
        if (BuildConfig.DEBUG) {
            LogUtil.d("ActivityLifeCycle", "onActivityResumed: ${activity.localClassName}")
        }
        topActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {
        if (BuildConfig.DEBUG) {
            LogUtil.d("ActivityLifeCycle", "onActivityPaused: ${activity.localClassName}")
        }
    }

    override fun onActivityStopped(activity: Activity) {
        if (BuildConfig.DEBUG) {
            LogUtil.d("ActivityLifeCycle", "onActivityStopped: ${activity.localClassName}")
        }
        activityCount--
        if (activityCount <= 0) {
            isForeground = false
            // App进入后台
            if (BuildConfig.DEBUG) {
                LogUtil.d("ActivityLifeCycle", "App进入后台")
            }
        }
    }

    override fun onActivitySaveInstanceState(pactivity0: Activity, bundle: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        if (BuildConfig.DEBUG) {
            LogUtil.d("ActivityLifeCycle", "onActivityDestroyed: ${activity.localClassName}")
        }
        if (activityCount == 0) {
            MyApplication.instance.get()?.mediaManager?.saveLatest()
        }
        activityStack.remove(activity)
    }

    fun closeAll() {
        activityStack.toList().forEach {
            it.finish()
        }
        activityStack.clear()
    }
}