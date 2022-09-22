package com.example.common.baseui

import androidx.lifecycle.MutableLiveData

open class BaseViewModel : LifeViewModel(), IViewModel {

    var loadingEvent = MutableLiveData<Boolean>()

    override fun showLoading() {
        loadingEvent.postValue(true)
    }

    override fun closeLoading() {
        loadingEvent.postValue(false)
    }

    override fun onError() {

    }
}