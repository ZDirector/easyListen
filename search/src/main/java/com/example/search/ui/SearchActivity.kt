package com.example.search.ui

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.baseui.BaseActivity
import com.example.common.utils.setAndroidNativeLightStatusBar
import com.example.common.utils.setStatusBarColor
import com.example.search.BR
import com.example.search.R
import com.example.search.adapter.SearchSuggestListAdapter
import com.example.search.databinding.ActivitySearchBinding
import com.example.search.viewmodel.SearchViewModel
import com.google.android.material.textfield.TextInputEditText

class SearchActivity : BaseActivity<ActivitySearchBinding,SearchViewModel>() ,
    View.OnClickListener{
    override var layoutId: Int = R.layout.activity_search
    override var variableId: Int = BR.searchViewModel

    private lateinit var searchBackImg : ImageView
    private lateinit var searchTextInput : TextInputEditText
    private lateinit var searchEditTextClear : ImageView
    private lateinit var searchHistoryLayout : ConstraintLayout
    private lateinit var searchHistoryClear : ImageView
    private lateinit var searchHistoryRel : RecyclerView
    private lateinit var searchRecommendRel : RecyclerView
    private lateinit var searchSuggestRel : RecyclerView
    private lateinit var searchHotRel : RecyclerView
    private lateinit var searchScroll : NestedScrollView

    private val searchSuggestLayoutManager = LinearLayoutManager(this)

    override fun initData(savedInstanceState: Bundle?) {
        setStatusBarColor(Color.WHITE)
        setAndroidNativeLightStatusBar()
        initView()
        initListener()
        initObserve()
    }

    private fun initView(){
        searchBackImg = binding.searchBack
        searchTextInput = binding.searchTextInput
        searchEditTextClear = binding.searchEditTextClear
        searchHistoryLayout = binding.searchHistoryLayout
        searchHistoryClear = binding.searchHistoryClear
        searchHistoryRel = binding.searchHistoryList
        searchRecommendRel = binding.searchRecommendList
        searchHotRel = binding.searchHotList
        searchSuggestRel = binding.searchSuggestList
        searchScroll = binding.searchMain

        searchSuggestRel.layoutManager = searchSuggestLayoutManager
    }

    private fun initListener(){
        searchBackImg.setOnClickListener(this)
        searchEditTextClear.setOnClickListener(this)
        searchHistoryClear.setOnClickListener(this)

        //输入过程中的搜索建议监听
        searchTextInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString() == ""){
                    searchSuggestRel.visibility = View.GONE
                    searchScroll.visibility = View.VISIBLE
                }
                else{
                    viewModel.getSearchSuggest(s.toString())
                    searchSuggestRel.visibility = View.VISIBLE
                    searchScroll.visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        //设置搜索回车监听和相关逻辑
        searchTextInput.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && keyCode != KeyEvent.ACTION_UP) {
                val text = searchTextInput.text

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
                }
                return@setOnKeyListener true
            } else return@setOnKeyListener false
        }
    }

    private fun initObserve(){
        viewModel.mSearchSuggestList.observe(this@SearchActivity){
            val adapter = SearchSuggestListAdapter(it)
            searchSuggestRel.adapter = adapter
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.search_back ->{
                finish()
            }
            R.id.search_editText_clear ->{
                searchTextInput.setText("")
            }
            R.id.search_history_clear ->{
                searchHistoryLayout.visibility = View.GONE
            }
        }
    }

}