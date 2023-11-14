package com.example.common.utils

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

/**
 * @author PengXin
 */
object FragmentUtil {

    /**
     * 根据 TAG 隐藏 DialogFragment
     *
     * @param activity FragmentActivity
     * @param tag String
     */
    fun hideDialog(activity: FragmentActivity, tag: String) {
        val oldFragment = activity.supportFragmentManager.findFragmentByTag(tag) as DialogFragment?
        oldFragment?.run {
            activity.supportFragmentManager.beginTransaction().remove(this)
                .commitAllowingStateLoss()
        }
    }

    /**
     * 展示 DialogFragment
     *
     * @param activity FragmentActivity
     * @param tag String
     * @param fragment DialogFragment
     */
    fun showDialog(activity: FragmentActivity, tag: String, fragment: DialogFragment) {
        val oldFragment = activity.supportFragmentManager.findFragmentByTag(tag) as DialogFragment?
        val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
        oldFragment?.run {
            fragmentTransaction.remove(this)
        }
        fragmentTransaction.add(fragment, tag).commitAllowingStateLoss()
    }

}