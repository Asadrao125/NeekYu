package com.technado.neekyu.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technado.neekyu.R
import com.technado.neekyu.adapters.OwnTemplatesAdapter
import com.technado.neekyu.adapters.PasswordScreenAdapter
import com.technado.neekyu.adapters.SubscriptionsAdapter
import com.technado.neekyu.adapters.WallpapersAdapter
import com.technado.neekyu.base.BaseFragment
import com.technado.neekyu.databinding.HomeFragmentBinding
import com.technado.neekyu.helper.Titlebar

class HomeFragment : BaseFragment() {
    var binding: HomeFragmentBinding? = null
    lateinit var recyclerViewWallpapers: RecyclerView
    lateinit var recyclerViewPaswordScreen: RecyclerView
    lateinit var recyclerViewOwnTemplates: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding?.btnDrawPattern?.setOnClickListener(View.OnClickListener {
            getActivityContext?.replaceFragment(
                DrawPatternFragment(),
                DrawPatternFragment::class.java.simpleName,
                true,
                true
            )
        })

        getActivityContext?.unlockMenu()

        recyclerViewWallpapers = binding?.recyclerViewWallpapers!!
        recyclerViewWallpapers.layoutManager =
            LinearLayoutManager(getActivityContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewWallpapers.setHasFixedSize(true)
        recyclerViewWallpapers.adapter = WallpapersAdapter(
            getActivityContext!!,
            resources.getStringArray(R.array.dummy).toList()
        )

        recyclerViewPaswordScreen = binding?.recyclerViewPaswordScreen!!
        recyclerViewPaswordScreen.layoutManager =
            LinearLayoutManager(getActivityContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPaswordScreen.setHasFixedSize(true)
        recyclerViewPaswordScreen.adapter = PasswordScreenAdapter(
            getActivityContext!!,
            resources.getStringArray(R.array.dummy).toList()
        )

        recyclerViewOwnTemplates = binding?.recyclerViewOwnTemplates!!
        recyclerViewOwnTemplates.layoutManager =
            LinearLayoutManager(getActivityContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewOwnTemplates.setHasFixedSize(true)
        recyclerViewOwnTemplates.adapter = OwnTemplatesAdapter(
            getActivityContext!!,
            resources.getStringArray(R.array.dummy).toList()
        )

        binding?.imgWallpaper?.setOnClickListener(View.OnClickListener {

        })

        binding?.imgPasswordScreen?.setOnClickListener(View.OnClickListener {

        })

        binding?.imgOwnTemplates?.setOnClickListener(View.OnClickListener {

        })

        return binding?.root
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setTitle(getActivityContext!!, "Home")
    }
}