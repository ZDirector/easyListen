package com.example.common.baseui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.common.R
import com.example.common.baseui.dialog.LoadingDialog
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    // Protected Field Start ----<<<<
    //
    //

    protected val viewModel: VM get() = _viewModel!!

    protected val binding: VDB get() = _binding!!

    /**
     * @LayoutRes
     */
    protected abstract val layoutId: Int

    /**
     * ViewModel 的 ID ，默认不设置 ID
     */
    protected val variableId: Int = -1

    protected abstract fun initData(savedInstanceState: Bundle?)

    protected open fun initDialog(): Dialog =
        LoadingDialog(requireContext(), R.layout.dialog_loading)

    //
    //
    // Protected Field End ----<<<<

    private var _viewModel: VM? = null

    private var _binding: VDB? = null

    private val dialog: Dialog by lazy { initDialog() }

    // final
    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        viewModel.loadingEvent.observe(viewLifecycleOwner, ::showOrHideDialog)
        initData(savedInstanceState)
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
        _binding = null
    }

    @Suppress("UNCHECKED_CAST")
    private fun initViewModel() {
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