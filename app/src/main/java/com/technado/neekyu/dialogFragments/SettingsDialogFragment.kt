package com.technado.neekyu.dialogFragments

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.technado.neekyu.R
import com.technado.neekyu.activities.RegisterActivity
import com.technado.neekyu.databinding.SettingsScreenBinding

class SettingsDialogFragment : DialogFragment() {
    var binding: SettingsScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_settings_dialog, container, false)

        getDialog()?.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding?.tvLogout?.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, RegisterActivity::class.java)
            activity?.startActivity(intent)
            activity?.finish()
        })

        binding?.tvSetPattern?.setOnClickListener(View.OnClickListener {
            dialog?.dismiss()
        })

        return binding?.root
    }
}