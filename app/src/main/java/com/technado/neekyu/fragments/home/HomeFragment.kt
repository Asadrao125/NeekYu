package com.technado.neekyu.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.technado.neekyu.R
import com.technado.neekyu.base.BaseFragment
import com.technado.neekyu.databinding.HomeFragmentBinding
import com.technado.neekyu.helper.Titlebar

class HomeFragment : BaseFragment() {
    var binding: HomeFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        getActivityContext?.unlockMenu()

        return binding?.root
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setTitle(getActivityContext!!, "Home")
    }
}