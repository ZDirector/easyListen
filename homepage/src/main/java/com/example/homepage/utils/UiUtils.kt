package com.example.homepage.utils

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue


object UiUtils {
    /**
     * dp转px
     */
    fun dp2px(ctx: Context?, dpValue: Int): Int {
        val scale: Float? = ctx?.resources?.displayMetrics?.density
        return (dpValue * scale!! + 0.5f).toInt()
    }

    /**
     * px转dp
     */
    fun px2dp(ctx: Context, pxValue: Float): Int {
        val scale: Float = ctx.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * sp转px
     */
    fun sp2px(ctx: Context, spVal: Float): Int {
        val metrics: DisplayMetrics = ctx.resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, metrics).toInt()
    }

    /**
     * px转sp
     */
    fun px2sp(ctx: Context, pxVal: Float): Float {
        return pxVal / ctx.resources.displayMetrics.scaledDensity
    }


}