package com.example.common.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import androidx.core.content.ContextCompat;

import com.example.common.R;

import java.lang.reflect.Method;

public class SystemUtils {

    private static int mStatusBarHeight = -1;
    private static int mNavigationBarHeight = -1;


    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
    private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";

    public static boolean isDarkMode(Activity activity) {
        int mode = activity.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return mode == Configuration.UI_MODE_NIGHT_YES;
    }

    /**
     * 状态栏透明字体黑色
     *
     * @param activity
     */
    public static void changeStatusBarTransTextBlack(Activity activity) {
        if (isDarkMode(activity)) {
            changeStatusBarTransTextWhite(activity);
        } else {
            Window window = activity.getWindow();
            window.clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }

    /**
     * 状态栏透明字体白色
     *
     * @param activity
     */
    public static void changeStatusBarTransTextWhite(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

    /**
     * 设置状态栏颜色，字体永远为白色
     *
     * @param activity
     * @param color
     */
    public static void changeStatusBarWithTextWhite(Activity activity, int color) {
        Window window = activity.getWindow();
        window.clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(color); // 状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

    public static void changeStatusBarWithDayAndNight(Activity activity, int color) {
        Window window = activity.getWindow();
        window.clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(color); // 状态栏颜色
        if (isDarkMode(activity)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); // 字体颜色,加了是黑
            }
        }
    }

    public static void changeStatusBarTransparent(Activity activity, int color) {
        Window window = activity.getWindow();
        window.clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // 6.0以上系统支持修改状态栏字体颜色，6.0以下不支持的设为黑色透明背景，突显白色字体
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (color == ContextCompat.getColor(activity, R.color.colorBlack)) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            } else {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            window.setStatusBarColor(color);
        } else {
            // window.setStatusBarColor(Color.parseColor("#20000000"));
            window.setStatusBarColor(ContextCompat.getColor(activity, R.color.colorBlack13));
        }
    }


    public static void changeStatusBarTransparent(Activity activity) {
        // changeStatusBarTransparent(activity, Color.parseColor("#FF000000"));
        changeStatusBarTransparent(activity, ContextCompat.getColor(activity, R.color.colorBlack));
    }

    // 通过此方法获取资源对应的像素值
    public static int getStatusBarHeight(Context context) {
        if (mStatusBarHeight != -1) {
            return mStatusBarHeight;
        }

        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            mStatusBarHeight = res.getDimensionPixelSize(resourceId);
        }
        return mStatusBarHeight;
    }

    // 获取导航栏高度
    public static int getNavigationBarHeight(Context context) {
        if (mNavigationBarHeight == -1) {
            boolean mInPortrait = true;
            Resources res = context.getResources();
            if (hasNavBar(context)) {
                String key;
                if (mInPortrait) {
                    key = NAV_BAR_HEIGHT_RES_NAME;
                } else {
                    key = NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME;
                }
                mNavigationBarHeight = getInternalDimensionSize(res, key);
            }
        }
        if (mNavigationBarHeight == -1) {
            mNavigationBarHeight = 0;
        }
        return mNavigationBarHeight;
    }

    // 通过此方法获取资源对应的像素值
    private static int getInternalDimensionSize(Resources res, String key) {
        int result = 0;
        int resourceId = res.getIdentifier(key, "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private static boolean hasNavBar(Context context) {
        Resources res = context.getResources();
        int resourceId = res.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", "android");
        if (resourceId != 0) {
            boolean hasNav = res.getBoolean(resourceId);
            // 查看是否有通过系统属性来控制navigation bar。
            if ("1".equals(getNavBarOverride())) {
                hasNav = false;
            } else if ("0".equals(getNavBarOverride())) {
                hasNav = true;
            }
            return hasNav;
        } else {
            // 可通过此方法来查看设备是否存在物理按键(menu,back,home键)。
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
    }

    // 安卓系统允许修改系统的属性来控制navigation bar的显示和隐藏，此方法用来判断是否有修改过相关属性。
    // (修改系统文件，在build.prop最后加入qemu.hw.mainkeys=1即可隐藏navigation bar)
    // 相关属性模拟器中有使用。
    // 当返回值等于"1"表示隐藏navigation bar，等于"0"表示显示navigation bar。
    @TargetApi(19)
    private static String getNavBarOverride() {
        String isNavBarOverride = null;
        try {
            Class c = Class.forName("android.os.SystemProperties");
            Method m = c.getDeclaredMethod("get", String.class);
            m.setAccessible(true);
            isNavBarOverride = (String) m.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable e) {
            isNavBarOverride = null;
        }
        return isNavBarOverride;
    }

    public static void fullScreen(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(LayoutParams.FLAG_FULLSCREEN);
        window.clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        LayoutParams layoutParams = window.getAttributes();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            layoutParams.layoutInDisplayCutoutMode =
                    LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        window.setAttributes(layoutParams);
    }
}
