package com.technado.neekyu.helper

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.databinding.DataBindingUtil
import com.technado.neekyu.R
import com.technado.neekyu.activities.HomeActivity
import com.technado.neekyu.databinding.Titlebarbinding
import com.technado.neekyu.fragments.home.EditProfileFragment

class Titlebar : RelativeLayout {
    var binding: Titlebarbinding? = null

    constructor(context: Context) : super(context) {
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initLayout(context)
    }

    fun initLayout(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflater, R.layout.titlebar, this, true)
    }

    fun hideTitleBar() {
        resetTitlebar()
    }

    fun resetTitlebar() {
        binding?.rlTitlebarMainLayout?.setVisibility(View.GONE)
    }

    fun setBtnLeft(drawable: Int, listener: OnClickListener?) {
        binding?.ivBack!!.setImageResource(drawable)
        binding?.ivBack!!.setOnClickListener(listener)
    }

    fun setTitle(getActivityContext: HomeActivity, title: String) {
        binding?.rlTitlebarMainLayout?.setVisibility(View.VISIBLE)
        binding?.tvTitle?.text = title
        binding?.ivBack?.visibility = View.GONE
        binding?.icTick?.visibility = View.GONE
        binding?.icEdit?.visibility = View.GONE
        binding?.ivMenu?.visibility = View.VISIBLE

        binding?.ivMenu?.setOnClickListener {
            getActivityContext.openDrawer()
        }
    }

    fun setBackTitle(getActivityContext: HomeActivity, title: String) {
        binding?.rlTitlebarMainLayout?.setVisibility(View.VISIBLE)
        binding?.tvTitle?.text = title
        binding?.ivBack?.visibility = View.VISIBLE
        binding?.ivMenu?.visibility = View.GONE
        binding?.icTick?.visibility = View.GONE
        binding?.icEdit?.visibility = View.GONE

        binding?.ivBack?.setOnClickListener {
            getActivityContext.onBackPressed()
        }
    }

    fun setTickTitle(getActivityContext: HomeActivity, title: String) {
        binding?.rlTitlebarMainLayout?.setVisibility(View.VISIBLE)
        binding?.tvTitle?.text = title
        binding?.ivMenu?.visibility = View.GONE
        binding?.icEdit?.visibility = View.GONE
        binding?.ivBack?.visibility = View.VISIBLE
        binding?.icTick?.visibility = View.VISIBLE

        binding?.icTick?.setOnClickListener {
            getActivityContext.onBackPressed()
        }

        binding?.ivBack?.setOnClickListener {
            getActivityContext.onBackPressed()
        }
    }

    fun setEditTitle(getActivityContext: HomeActivity, title: String) {
        binding?.rlTitlebarMainLayout?.setVisibility(View.VISIBLE)
        binding?.tvTitle?.text = title
        binding?.ivMenu?.visibility = View.GONE
        binding?.icTick?.visibility = View.GONE
        binding?.ivBack?.visibility = View.VISIBLE
        binding?.icEdit?.visibility = View.VISIBLE

        binding?.icEdit?.setOnClickListener {
            getActivityContext.replaceFragment(EditProfileFragment(), EditProfileFragment::class.java.simpleName, true, false)
        }

        binding?.ivBack?.setOnClickListener {
            getActivityContext.onBackPressed()
        }
    }

    fun setHideTitle() {
        resetTitlebar()
        binding?.rlTitlebarMainLayout?.setVisibility(View.VISIBLE)
        binding?.ivBack?.visibility = View.INVISIBLE
    }
}