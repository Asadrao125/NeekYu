package com.technado.neekyu.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.technado.neekyu.R
import com.technado.neekyu.base.BaseFragment
import com.technado.neekyu.databinding.SetPatternBinding
import com.technado.neekyu.helper.Titlebar

class SetPatternFragment : BaseFragment() {
    var binding: SetPatternBinding? = null
    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setBackTitle(getActivityContext!!, "Set Pattern")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_pattern, container, false)

        getActivityContext?.lockMenu()

        return binding?.root
    }
}