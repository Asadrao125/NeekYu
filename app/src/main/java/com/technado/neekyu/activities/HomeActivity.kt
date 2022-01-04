package com.technado.neekyu.activities

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.technado.neekyu.R
import com.technado.neekyu.base.BaseActivity
import com.technado.neekyu.databinding.HomeActivityBinding
import com.technado.neekyu.dialogFragments.ExitDialog
import com.technado.neekyu.dialogFragments.SettingsDialogFragment
import com.technado.neekyu.fragments.home.*
import com.technado.neekyu.helper.Titlebar

class HomeActivity : BaseActivity(), View.OnClickListener {
    var binding: HomeActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        setMainFrameLayoutID()
        setListener()
        replaceFragment(HomeFragment(), HomeFragment::class.java.simpleName, true, false)
    }

    fun setListener() {
        binding?.llHome?.setOnClickListener(this)
        binding?.llProfile?.setOnClickListener(this)
        binding?.llSubscriptions?.setOnClickListener(this)
        binding?.llSetPattern?.setOnClickListener(this)
        binding?.llSettings?.setOnClickListener(this)
        binding?.llAppsLock?.setOnClickListener(this)
    }

    fun getTitlebar(): Titlebar {
        return binding!!.titlebar
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            val fragmentManager = supportFragmentManager
            val fragments: List<Fragment> = fragmentManager.fragments
            val last: Fragment = fragments.get(fragments.size - 1)
            supportFragmentManager.popBackStack()
        } else {
            if (binding?.drawerlayout!!.isDrawerOpen(GravityCompat.START)) {
                closeDrawers()
            } else {
                val exitDialog = ExitDialog()
                exitDialog.show(supportFragmentManager, "exitDialog")
            }
        }
    }

    fun mainHideTitle() {
        binding!!.titlebar.visibility = View.GONE
    }

    fun mainShowTitle() {
        binding!!.titlebar.visibility = View.VISIBLE
    }

    fun clearBackStack() {
        val fragmentManager = supportFragmentManager
        for (i in 0 until fragmentManager.backStackEntryCount) {
            fragmentManager.popBackStack()
        }
    }

    override fun setMainFrameLayoutID() {
        mainFrameLayoutID = binding?.mainContainer!!.id
    }

    fun unlockMenu() {
        binding!!.drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    fun lockMenu() {
        binding!!.drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    fun openDrawer() {
        binding!!.drawerlayout.openDrawer(GravityCompat.START)
    }

    fun closeDrawers() {
        binding!!.drawerlayout.closeDrawers()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.llHome -> {
                closeDrawers()
            }

            R.id.llProfile -> {
                replaceFragment(
                    ProfileFragment(),
                    ProfileFragment::class.java.simpleName,
                    true,
                    true
                )
                closeDrawers()
            }

            R.id.llSubscriptions -> {
                replaceFragment(
                    SubscriptionsFragment(),
                    SubscriptionsFragment::class.java.simpleName,
                    true,
                    true
                )
                closeDrawers()
            }

            R.id.llSetPattern -> {
                replaceFragment(
                    SetPatternFragment(),
                    SetPatternFragment::class.java.simpleName,
                    true,
                    true
                )
                closeDrawers()
            }

            R.id.llSettings -> {
                val settingDialog = SettingsDialogFragment()
                settingDialog.show(supportFragmentManager, "settingsDialog")
                closeDrawers()
            }

            R.id.llAppsLock -> {
                replaceFragment(
                    AppsLockFragment(),
                    AppsLockFragment::class.java.simpleName,
                    true,
                    true
                )
                closeDrawers()
            }
        }
    }
}