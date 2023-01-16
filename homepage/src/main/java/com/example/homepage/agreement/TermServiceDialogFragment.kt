package com.example.homepage.agreement

import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.homepage.R
import com.example.homepage.activity.ContentServiceActivity
import com.example.homepage.databinding.FragmentTermServiceDialogBinding
import com.example.homepage.utils.UiUtils

class TermServiceDialogFragment : DialogFragment() {

    lateinit var mBinding: FragmentTermServiceDialogBinding
    private  var mCallback: ClickCallBack?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_term_service_dialog,
            container,
            false
        )
        return mBinding.root
    }

    fun setCallBack(callBack: ClickCallBack) {
        mCallback = callBack
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWindow()
        initView()
    }

    private fun initView() {
        mBinding.apply {
            rvSure.setOnClickListener {
                mCallback?.confirm()
                dismiss()
            }
            tvNo.setOnClickListener {
                mCallback?.cancel()
                dismiss()
            }
        }
    }

    private fun initWindow() {
        //初始化window相关表现
        val window = dialog?.window
        //设置window宽高(单位px)
        window?.attributes?.width = UiUtils.dp2px(context, 280)
        window?.attributes?.height = UiUtils.dp2px(context, 480)
        window?.attributes?.gravity = Gravity.CENTER//居中
        initString()
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TermServiceDialogFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun initString(){
        val str = "本软件尊重并保护所有使用服务用户的个人隐私权。为了给您提供更准确、更有个性化的服务，本软件会按照本隐私权政策的规定使用和披露您的个人信息。但本软件将以高度的勤勉、审慎义务对待这些信息。除本隐私权政策另有规定外,在未征得您事先许可的情况下，本软件不会将这些信息对外披露或向第三方提供。本软件会不时更新本隐私权政策。请你认真阅读并了解《服务条款》和《隐私政策》，您在同意本软件服务使用协议之时,即视为您已经同意本隐私权政策全部内容。本隐私权政策属于本软件服务协议机不可分割的一部分。"
        val ssb = SpannableStringBuilder()
        ssb.append(str)
        //第一个出现的位置
        //第一个出现的位置
        val start = str.indexOf("《")
        ssb.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                //用户服务协议点击事件
                val bundle = Bundle()
                bundle.putString("title", "用户协议")
                bundle.putInt("showType", 0)
                val intent = Intent(activity,ContentServiceActivity::class.java)
                intent.putExtra("content_style",1)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                //设置文件颜色
                ds.color = resources.getColor(com.example.homepage.R.color.blue)
                // 去掉下划线
                ds.isUnderlineText = false

            }


        }, start, start + 6, 0)


        //最后一个出现的位置
        //最后一个出现的位置
        val end = str.lastIndexOf("《")
        ssb.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                //隐私协议点击事件
                val bundle = Bundle()
                bundle.putString("title", "隐私政策")
                bundle.putInt("showType", 0)
                val intent = Intent(activity,ContentServiceActivity::class.java)
                intent.putExtra("content_style",2)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                //设置文件颜色
                ds.color = resources.getColor(com.example.homepage.R.color.blue)
                // 去掉下划线
                ds.isUnderlineText = false
            }
        }, end, end + 6, 0)
        mBinding.tvContent.apply {
            movementMethod = LinkMovementMethod.getInstance();
            setText(ssb, TextView.BufferType.SPANNABLE);
            //设置点击后的背景颜色为透明
            highlightColor = ContextCompat.getColor(context, androidx.navigation.ui.ktx.R.color.mtrl_btn_transparent_bg_color);
        }
    }

}

interface ClickCallBack {
    fun cancel()
    fun confirm()
}
