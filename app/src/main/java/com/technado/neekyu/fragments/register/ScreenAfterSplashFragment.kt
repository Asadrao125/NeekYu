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
import com.technado.neekyu.databinding.ScreenAfterSplashBinding
import com.technado.neekyu.helper.Titlebar

class ScreenAfterSplashFragment : BaseFragment() {
    var binding: ScreenAfterSplashBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_screen_after_splash,
            container,
            false
        )

        binding?.loginWithEmail?.setOnClickListener(View.OnClickListener {
            getRegisterActivityContext?.replaceFragment(
                LoginFragment(),
                LoginFragment::class.java.simpleName,
                true,
                true
            )
        })

        binding?.loginWithFacebook?.setOnClickListener(View.OnClickListener {
            val intent = Intent(getRegisterActivityContext, HomeActivity::class.java)
            startActivity(intent)
            getRegisterActivityContext?.finish()
        })

        binding?.loginWithGoogle?.setOnClickListener(View.OnClickListener {
            val intent = Intent(getRegisterActivityContext, HomeActivity::class.java)
            startActivity(intent)
            getRegisterActivityContext?.finish()
        })

        binding?.signUpLayout?.setOnClickListener(View.OnClickListener {
            getRegisterActivityContext?.replaceFragment(
                SignUpFragment(),
                SignUpFragment::class.java.simpleName,
                true,
                true
            )
        })

        return binding?.root
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.hideTitleBar()
    }
}