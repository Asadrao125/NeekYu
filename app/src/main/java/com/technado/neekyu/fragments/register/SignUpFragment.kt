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
import com.technado.neekyu.databinding.SignUpActivityBinding
import com.technado.neekyu.helper.Titlebar

class SignUpFragment : BaseFragment() {
    var binding: SignUpActivityBinding? = null
    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setHideTitle()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)

        binding?.btnContinue?.setOnClickListener(View.OnClickListener {
            val intent = Intent(getRegisterActivityContext, HomeActivity::class.java)
            startActivity(intent)
            getRegisterActivityContext?.finish()
        })

        return binding?.root
    }
}