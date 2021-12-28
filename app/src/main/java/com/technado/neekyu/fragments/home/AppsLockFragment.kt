package com.technado.neekyu.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.technado.neekyu.R
import com.technado.neekyu.adapters.AppsLockAdapter
import com.technado.neekyu.base.BaseFragment
import com.technado.neekyu.databinding.AppsLockFragmentBinding
import com.technado.neekyu.helper.Titlebar

class AppsLockFragment : BaseFragment() {
    var binding: AppsLockFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_apps_lock, container, false)

        getActivityContext?.lockMenu()

        binding?.recyclerView?.layoutManager = LinearLayoutManager(getActivityContext)
        binding?.recyclerView?.setHasFixedSize(true)
        binding?.recyclerView?.adapter =
            AppsLockAdapter(
                getActivityContext!!,
                resources.getStringArray(R.array.dummy2).toList()
            )

        return binding?.root
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setBackTitle(getActivityContext!!, "Apps")
    }
}