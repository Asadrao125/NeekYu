package com.technado.neekyu.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technado.neekyu.R
import com.technado.neekyu.adapters.DrawPatternAdapter
import com.technado.neekyu.adapters.SubscriptionsAdapter
import com.technado.neekyu.base.BaseFragment
import com.technado.neekyu.databinding.CardDetailsFragmentBinding
import com.technado.neekyu.databinding.DrawPatternFragmentBinding
import com.technado.neekyu.helper.Titlebar

class DrawPatternFragment : BaseFragment() {
    var binding: DrawPatternFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_draw_pattern, container, false)

        binding?.recyclerViewPattern?.layoutManager = GridLayoutManager(getActivityContext, 3)
        binding?.recyclerViewPattern?.setHasFixedSize(true)

        binding?.recyclerViewPattern?.adapter = DrawPatternAdapter(
            getActivityContext!!,
            resources.getStringArray(R.array.pattern).toList()
        )

        return binding?.root
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setBackTitle(getActivityContext!!, "Draw a pattern")
    }
}