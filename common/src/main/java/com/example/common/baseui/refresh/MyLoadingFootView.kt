package com.example.common.baseui.refresh

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.common.R
import com.scwang.smart.refresh.layout.api.RefreshFooter
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.constant.RefreshState
import com.scwang.smart.refresh.layout.simple.SimpleComponent
import com.wang.avi.AVLoadingIndicatorView

/**
 * 自定义smartRefresh的Footer
 */
class MyLoadingFootView : SimpleComponent,RefreshFooter  {

    companion object{
        const val ON_LOADING = "正在加载..."
        const val RELEASE_LOADING = "释放立即加载"
        const val FINISH_LOADING = "加载成功"
        const val FAILED_LOADING = "加载失败"
        const val DOWN_CANCEL = "下拉取消"
        const val UP_TO_LOADING = "上拉可以刷新"
    }

    private val loadingTv: TextView
    private val loadingAnim: AVLoadingIndicatorView

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_loading, this)
        loadingTv = view.findViewById(R.id.search_loading_text)
        loadingAnim = view.findViewById(R.id.search_loading_anim)
    }

    override fun onFinish(refreshLayout: RefreshLayout, success: Boolean): Int {
        if (success) loadingTv.text = FINISH_LOADING
        else loadingTv.text = FAILED_LOADING
        loadingAnim.visibility = View.GONE
        super.onFinish(refreshLayout, success)
        return 500
    }

    override fun onStateChanged(
        refreshLayout: RefreshLayout,
        oldState: RefreshState,
        newState: RefreshState
    ) {
        when(newState){
            RefreshState.PullUpToLoad -> loadingTv.text = UP_TO_LOADING
            RefreshState.PullUpCanceled -> loadingTv.text = DOWN_CANCEL
            RefreshState.ReleaseToLoad -> loadingTv.text = RELEASE_LOADING
            RefreshState.Loading -> {
                loadingAnim.visibility = View.VISIBLE
                loadingTv.text = ON_LOADING
            }
            else -> {}
        }
    }
}