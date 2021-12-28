package com.technado.neekyu.fragments.home

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technado.neekyu.R
import com.technado.neekyu.adapters.AppsLockAdapter
import com.technado.neekyu.base.BaseFragment
import com.technado.neekyu.databinding.AppsLockFragmentBinding
import com.technado.neekyu.helper.Titlebar
import com.technado.neekyu.models.AppModel
import java.util.*
import kotlin.collections.ArrayList

class AppsLockFragment : BaseFragment() {
    var binding: AppsLockFragmentBinding? = null
    var progRessDialog: ProgressDialog? = null
    private lateinit var installedAppsList: ArrayList<AppModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_apps_lock, container, false)

        installedAppsList = ArrayList()
        getActivityContext?.lockMenu()
        progRessDialog = ProgressDialog(getActivityContext)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(getActivityContext)
        binding?.recyclerView?.setHasFixedSize(true)

        progRessDialog!!.setMessage("Loading...")
        progRessDialog!!.show()

        Handler(Looper.getMainLooper()).postDelayed({
            getInstalledApps()
            progRessDialog!!.dismiss()
            binding?.recyclerView?.adapter =
                AppsLockAdapter(
                    getActivityContext!!,
                    getInstalledApps()
                )
        }, 500)
        return binding?.root
    }

    override fun setTitlebar(titlebar: Titlebar) {
        titlebar.setBackTitle(getActivityContext!!, "Apps")
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun getInstalledApps(): ArrayList<AppModel> {
        val packs = context?.packageManager?.getInstalledPackages(0)
        for (i in packs?.indices!!) {
            val p = packs[i]
            if (!isSystemPackage(p)) {
                val appName = p.applicationInfo.loadLabel(context?.packageManager!!).toString()
                val icon = p.applicationInfo.loadIcon(context?.packageManager!!)
                val packages = p.applicationInfo.packageName
                installedAppsList.add(AppModel(appName, icon, packages))
            }
        }
        return installedAppsList
    }

    private fun isSystemPackage(pkgInfo: PackageInfo): Boolean {
        return pkgInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0
    }
}