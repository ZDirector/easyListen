package com.example.common.baseui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.utils.showToast

open class BaseViewModel : LifeViewModel(), IViewModel {

    private val _loadingEvent = MutableLiveData<Boolean>()
    val loadingEvent: LiveData<Boolean> = _loadingEvent

    override fun showLoading() = _loadingEvent.postValue(true)

    override fun closeLoading() = _loadingEvent.postValue(false)

    override fun onError(msg: String) = showToast(msg)
}