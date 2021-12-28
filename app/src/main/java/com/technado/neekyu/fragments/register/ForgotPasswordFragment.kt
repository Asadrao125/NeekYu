package com.technado.neekyu.fragments.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.technado.neekyu.R
import com.technado.neekyu.base.BaseFragment
import com.technado.neekyu.databinding.EditProfileFragmentBinding
import com.technado.neekyu.databinding.ForgotPasswordScreenBinding
import com.technado.neekyu.helper.Titlebar

class ForgotPasswordFragment : BaseFragment() {
    var binding: ForgotPasswordScreenBinding? = null
    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setHideTitle()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_forgot_password, container, false)

        getActivityContext?.lockMenu()

        return binding?.root
    }
}