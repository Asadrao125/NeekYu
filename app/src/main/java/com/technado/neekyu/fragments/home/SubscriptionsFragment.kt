package com.technado.neekyu.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technado.neekyu.R
import com.technado.neekyu.adapters.SubscriptionsAdapter
import com.technado.neekyu.base.BaseFragment
import com.technado.neekyu.databinding.SubscriptionsScreenBinding
import com.technado.neekyu.helper.RecyclerItemClickListener
import com.technado.neekyu.helper.Titlebar

class SubscriptionsFragment : BaseFragment() {
    var binding: SubscriptionsScreenBinding? = null
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_subscriptions, container, false)

        getActivityContext?.lockMenu()

        recyclerView = binding?.recyclerView!!
        recyclerView.layoutManager = LinearLayoutManager(getActivityContext)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SubscriptionsAdapter(
            getActivityContext!!,
            resources.getStringArray(R.array.dummy).toList()
        )

        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(
                getActivityContext,
                recyclerView,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        getActivityContext!!.replaceFragment(
                            CardDetailsFragment(),
                            CardDetailsFragment::class.java.simpleName,
                            true,
                            true
                        )
                    }

                    override fun onItemLongClick(view: View?, position: Int) {

                    }
                })
        )

        return binding?.root
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setBackTitle(getActivityContext!!, "Subscriptions")
    }
}