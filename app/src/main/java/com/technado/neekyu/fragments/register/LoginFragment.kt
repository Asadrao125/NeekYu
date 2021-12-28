package com.technado.neekyu.fragments.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.technado.neekyu.R
import com.technado.neekyu.activities.HomeActivity
import com.technado.neekyu.base.BaseFragment
import com.technado.neekyu.databinding.LoginScreenBinding
import com.technado.neekyu.helper.Titlebar

class LoginFragment : BaseFragment() {
    var binding: LoginScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding?.tvForgetPassword?.setOnClickListener(View.OnClickListener {
            getRegisterActivityContext?.replaceFragment(
                ForgotPasswordFragment(),
                ForgotPasswordFragment::class.java.simpleName,
                true,
                true
            )
        })

        binding?.btnLogin?.setOnClickListener(View.OnClickListener {
            moveToHomeActivity()
        })

        binding?.fbLayout?.setOnClickListener(View.OnClickListener {
            moveToHomeActivity()
        })

        binding?.googleLayout?.setOnClickListener(View.OnClickListener {
            moveToHomeActivity()
        })

        return binding?.root
    }

    private fun moveToHomeActivity() {
        val intent = Intent(getRegisterActivityContext, HomeActivity::class.java)
        startActivity(intent)
        getRegisterActivityContext?.finish()
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setHideTitle()
    }
}