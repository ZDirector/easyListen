package com.example.common.baseui


import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.common.R
import com.example.common.utils.setStatusBarColor
import java.lang.reflect.ParameterizedType
import com.example.common.baseui.dialog.LoadingDialog

abstract class BaseActivity<VDB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    private lateinit var _sViewModel : VM
    open val viewModel get() = _sViewModel
    private lateinit var _sViewDateBinding: VDB
    open val viewDateBinding get() = _sViewDateBinding
    private lateinit var loadingDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        setStatusBarColor(Color.BLACK)
        super.onCreate(savedInstanceState)
        handlerVDB()
        handlerVM()
        loadingDialog = getLoadingDialog()
        receiveLiveData()
        initData(savedInstanceState)
    }

    private fun handlerVDB() {
        _sViewDateBinding = DataBindingUtil.setContentView(this, getLayoutId())
        _sViewDateBinding.lifecycleOwner = this
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
        _sViewModel = ViewModelProvider(this)[viewModelClass] as VM
        if (getVariableId() > 0) {
            lifecycle.addObserver(_sViewModel)
            _sViewDateBinding.setVariable(getVariableId(), _sViewModel)
        }
    }

    abstract fun getLayoutId(): Int

    private fun receiveLiveData() {
        _sViewModel.loadingEvent.observe(this) { aBoolean ->
            if (aBoolean) {
                showLoading()
            } else {
                dismissLoading()
            }
        }
    }

    open fun showLoading() {
        if (!loadingDialog.isShowing) {
            loadingDialog.show()
        }
    }

    private fun getLoadingDialog(): LoadingDialog =
        LoadingDialog(this, R.style.trans_Dialog)


    open fun dismissLoading() {
        if (loadingDialog.isShowing) {
            loadingDialog.dismiss()
        }
    }

    open fun setLoadingDialog(dialog : Dialog){
        loadingDialog = dialog
    }

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    abstract fun getVariableId(): Int

    /**
     * 初始化数据，相当于OnCreate方法
     */
    abstract fun initData(savedInstanceState: Bundle?)
}