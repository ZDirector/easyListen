package com.example.common.utils

import android.content.Context

class UiUtils {
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
