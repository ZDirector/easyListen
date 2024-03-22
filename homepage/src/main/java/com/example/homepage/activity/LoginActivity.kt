package com.example.homepage.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.common.constants.HttpConstants
import com.example.common.utils.MyApplication
import com.example.common.utils.SystemUtils
import com.example.homepage.R
import com.example.homepage.databinding.ActivityLoginBinding
import com.example.homepage.viewModel.LoginViewModel
import com.example.homepage.viewModel.UserViewModel

class LoginActivity : FragmentActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val userViewModel: UserViewModel by lazy {
        MyApplication.getAppViewModel(UserViewModel::class.java)
    }
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUtils.changeStatusBarWithDayAndNight(
            this,
            ContextCompat.getColor(this, com.example.common.R.color.color_FF)
        )
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.executePendingBindings()

        initView()
        subscribeData()
    }

    private fun initView() {
        binding.tvLogin.setOnClickListener {
            viewModel.login()
        }
    }

    private fun subscribeData() {
        viewModel.loginData.observe(this) {
            saveCookie(it.cookie)
            userViewModel.updateUserInfo(it.profile)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun saveCookie(cookie: String) {
        HttpConstants.COOKIE = cookie
        val prefs = getSharedPreferences("data", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("cookie", cookie)
        editor.apply()
    }

}