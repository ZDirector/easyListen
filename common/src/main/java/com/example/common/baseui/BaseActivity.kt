package com.example.common.baseui

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.common.R
import com.example.common.baseui.dialog.LoadingDialog
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VDB : ViewDataBinding, VM : BaseViewModel> : FragmentActivity() {

    // Protected Field Start ----<<<<
    //
    //

    protected val viewModel: VM get() = _viewModel!!

    protected val binding: VDB get() = _binding!!




    /**
     * @LayoutRes
     */
    protected abstract val layoutId: Int


    protected abstract val activity:Activity

    /**
     * ViewModel 的 ID ，默认不设置 ID
     */
    protected open val variableId: Int = -1

    protected abstract fun initData(savedInstanceState: Bundle?)

    protected open fun initDialog(): Dialog =
        LoadingDialog(this, R.layout.dialog_loading)

    //
    //
    // Protected Field End ----<<<<

    private var _viewModel: VM? = null

    private var _binding: VDB? = null

    private val dialog: Dialog by lazy { initDialog() }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModelAndViewDataBinding()
        viewModel.loadingEvent.observe(this, ::showOrHideDialog)
        initData(savedInstanceState)
    }

    @Suppress("UNCHECKED_CAST")
    private fun initViewModelAndViewDataBinding() {
        _binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        val type = javaClass.genericSuperclass
        val clz = if (type is ParameterizedType) {
            type.actualTypeArguments[1] as Class<BaseViewModel> //获取第1个注解即VM的注解类型
        } else {
            //使用父类的类型
            BaseViewModel::class.java
        }
        _viewModel = ViewModelProvider(this)[clz] as VM
        if (variableId > 0) {
            lifecycle.addObserver(viewModel)
            binding.setVariable(variableId, viewModel)
        }
    }

    private fun showOrHideDialog(isVisible: Boolean) {
        if (isVisible && !dialog.isShowing) {
            dialog.show()
        } else if (!isVisible && dialog.isShowing) {
            dialog.hide()
        }
    }
}