package com.technado.neekyu.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.technado.neekyu.activities.HomeActivity
import com.technado.neekyu.activities.RegisterActivity
import com.technado.neekyu.helper.Titlebar

abstract class BaseFragment : Fragment() {
    var getActivityContext: HomeActivity? = null
    var getRegisterActivityContext: RegisterActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    abstract fun setTitlebar(titlebar: Titlebar)

    fun getActivityContext(): HomeActivity? {
        return getActivityContext
    }

    fun getRegisterActivityContext(): RegisterActivity? {
        return getRegisterActivityContext
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HomeActivity) {
            val contex = context as HomeActivity?
            if (contex != null)
                getActivityContext = context

        } else if (context is RegisterActivity) {
            val contex = context as RegisterActivity?
            if (contex != null)
                getRegisterActivityContext = context
        }
    }

    override fun onResume() {
        super.onResume()
        if (getActivityContext != null) {
            setTitlebar(getActivityContext!!.getTitlebar())
        }
    }
}