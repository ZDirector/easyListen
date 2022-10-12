package com.kokomi.preference.user.ui

import android.os.Bundle
import com.example.common.baseui.BaseFragment
import com.kokomi.preference.R
import com.kokomi.preference.databinding.FragmentUserBinding
import com.kokomi.preference.user.viewmodel.UserViewModel

class UserFragment : BaseFragment<FragmentUserBinding, UserViewModel>() {

    override val layoutId: Int = R.layout.fragment_user

    override fun initData(savedInstanceState: Bundle?) {

    }

}