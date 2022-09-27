package com.example.common.baseui

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.common.utils.MyApplication

open class BaseViewModel : LifeViewModel(), IViewModel {

    var loadingEvent = MutableLiveData<Boolean>()

    override fun showLoading() {
        loadingEvent.postValue(true)
    }

    override fun closeLoading() {
        loadingEvent.postValue(false)
    }

    override fun onError(msg : String) {
        Toast.makeText(MyApplication.context,msg,Toast.LENGTH_SHORT).show()
    }
}