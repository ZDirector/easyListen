package com.example.common.baseui

interface IViewModel {
    fun showLoading()
    fun closeLoading()
    fun onError(msg : String)
}
