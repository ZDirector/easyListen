package com.example.common.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.*
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


object UiUtils {
    fun setPic(imageView: ImageView, radius: Int, url: String) {
        //Glide设置图片圆角角度
        val roundedCorners = RoundedCorners(radius)
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        val options = RequestOptions.bitmapTransform(roundedCorners)
        Glide.with(imageView.context)
            .load(url) //.placeholder(R.drawable.ic_default_image)
            .apply(options)
            .into(imageView)
    }

    fun getViewWidth(view: View, onViewListener: OnViewListener?) {
        val vto2: ViewTreeObserver = view.viewTreeObserver
        vto2.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                view.viewTreeObserver.removeOnGlobalLayoutListener(this)

                onViewListener?.onView(view.width, view.height)
            }
        })
    }
}

val Context.navigationBarHeight: Int
    get() {
        if (navigationBarHeightInternal != -1) return navigationBarHeightInternal
        var result = 0
        val resourceId = resources.getIdentifier(
            "navigation_bar_height",
            "dimen",
            "android"
        )
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
//        result = if (result < 50) 0 else result
        navigationBarHeightInternal = result
        return result
    }
private var navigationBarHeightInternal = -1


/**
 * 沉浸式处理
 */
fun immersive(window: Window, activity: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.apply {
            //清除透明状态栏标识
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //添加绘制状态栏标识
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            // 添加透明导航标识
            addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            //设置状态栏的颜色为透明
            statusBarColor = Color.TRANSPARENT
        }
        activity.findViewById<ViewGroup>(android.R.id.content).apply {
            //遍历根布局的子布局
            for (index in 0 until childCount) {
                val child = getChildAt(index) as? ViewGroup
                //让布局根据系统窗口来调整自己的布局
                child?.let {
                    it.fitsSystemWindows = true
                    it.clipToPadding = true
                }
            }
        }

    } else {
        //Android4.4这个设置就能实现沉浸式效果
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    }


}


interface OnViewListener {
    fun onView(width: Int, height: Int)
}
