package com.example.homepage.widget

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator


@Navigator.Name("customNavigator")
class CustomNavigator(context: Context, fragmentManager: FragmentManager, containerId: Int) :
    FragmentNavigator(context, fragmentManager, containerId) {
    private val context: Context
    private val fragmentManager: FragmentManager
    private val containerId: Int




    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
        val ft: FragmentTransaction = fragmentManager.beginTransaction()
        // 获取当前显示的Fragment
        var fragment: Fragment? = fragmentManager.primaryNavigationFragment
        if (fragment != null) {
            ft.hide(fragment)
        }
        val tag = destination.id.toString()
        fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            ft.show(fragment)
        } else {
            fragment = instantiateFragment(context, fragmentManager, destination.className, args)
            ft.add(containerId, fragment, tag)
        }
        ft.setPrimaryNavigationFragment(fragment)
        ft.setReorderingAllowed(true)
        ft.commit()
        return destination
    }

    init {
        this.context = context
        this.fragmentManager = fragmentManager
        this.containerId = containerId
    }
}
