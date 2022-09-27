package com.example.common.baseui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.common.R
import com.example.common.baseui.dialog.LoadingDialog
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    private lateinit var _sViewModel : VM
    open val viewModel get() = _sViewModel
    private lateinit var _sViewDateBinding: VDB
    open val viewDateBinding get() = _sViewDateBinding
    private lateinit var loadingDialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _sViewDateBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return run {
            _sViewDateBinding.lifecycleOwner = this
            _sViewDateBinding.root
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        handlerVM()
        loadingDialog = LoadingDialog(requireActivity(), R.style.trans_Dialog)
        receiveLiveData()
        initData(savedInstanceState)
    }

    private fun handlerVM() {
        val viewModelClass: Class<BaseViewModel>
        val type = javaClass.genericSuperclass
        viewModelClass = if (type is ParameterizedType) {
            type.actualTypeArguments[1] as Class<BaseViewModel> //获取第1个注解即VM的注解类型
        } else {
            //使用父类的类型
            BaseViewModel::class.java
        }
        _sViewModel = ViewModelProvider(requireActivity())[viewModelClass] as VM //找到Activity对于的VM
        if (getVariableId() > 0) {
            lifecycle.addObserver(_sViewModel)
            _sViewDateBinding.setVariable(getVariableId(), _sViewModel)
        }
    }

    private fun receiveLiveData() {
        _sViewModel.loadingEvent.observe(viewLifecycleOwner){ aBoolean ->
            if (aBoolean) {
                showLoading()
            } else {
                dismissLoading()
            }
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun initData(savedInstanceState: Bundle?)

    open fun setLoadingDialog(dialog : Dialog){
        loadingDialog = dialog
    }

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    abstract fun getVariableId(): Int

    open fun showLoading() {
        if (!loadingDialog.isShowing) {
            loadingDialog.show()
        }
    }

    open fun dismissLoading() {
        loadingDialog.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        _sViewDateBinding.unbind()
    }

}