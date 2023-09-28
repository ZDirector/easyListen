package com.example.common.baseui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.utils.showToast

open class BaseViewModel : LifeViewModel(), IViewModel {

    private val _loadingEvent = MutableLiveData<Boolean>()
    val loadingEvent: LiveData<Boolean> = _loadingEvent

    /**
     * 该LiveData用于状态管理，ViewModel在请求完数据之后，根据请求的结果，对status设置不同的
     * 状态，Activity可以去观察该LiveData，可以根据不同的状态，显示出不同的UI
     * */
    val status: MutableLiveData<String> = MutableLiveData()

    override fun showLoading() = _loadingEvent.postValue(true)

    override fun closeLoading() = _loadingEvent.postValue(false)

    override fun onError(msg: String) = showToast(msg)
}