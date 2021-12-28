package com.technado.neekyu.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.technado.neekyu.R
import com.technado.neekyu.base.BaseActivity
import com.technado.neekyu.databinding.RegisterActivityBinding
import com.technado.neekyu.fragments.register.ScreenAfterSplashFragment

class RegisterActivity : BaseActivity() {
    var binding: RegisterActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        setMainFrameLayoutID()

        replaceFragment(ScreenAfterSplashFragment(), ScreenAfterSplashFragment::class.java.simpleName, false, false)
    }

    override fun setMainFrameLayoutID() {
        mainFrameLayoutID = binding?.mainContainer!!.id
    }
}