package com.example.search.viewmodel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.baseui.BaseViewModel
import com.example.common.bean.searchBean.Userprofile
import com.example.common.network.collectNetwork
import com.example.search.repository.SearchRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class SearchUserViewModel : BaseViewModel() {

    private val userList = mutableListOf<Userprofile>()
    private val _searchUserList : MutableLiveData<List<Userprofile>> = MutableLiveData()
    val mSearchUserList : LiveData<List<Userprofile>> get() = _searchUserList

    var offset : Int = 0

    fun getSearchUserList(keyWords : String){
        viewModelScope.launch {
            flow {
                emit(SearchRepository.getSearchUserResultList(keyWords, offset * 20))
            }.collectNetwork {
                success { response ->
                    if (offset == 0) userList.clear()
                    if (response.code == 200 && !response.result.userprofiles.isNullOrEmpty()){
                        userList.addAll(response.result.userprofiles!!)
                        _searchUserList.postValue(userList)
                    }else _searchUserList.postValue(null)
                }
                failure {
                    _searchUserList.postValue(null)
                }
                toastError()
            }
        }
    }

}