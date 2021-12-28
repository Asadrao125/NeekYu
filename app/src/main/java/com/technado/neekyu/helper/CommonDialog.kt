package com.technado.neekyu.helper

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.technado.neekyu.R
import com.technado.neekyu.activities.RegisterActivity

class CommonDialog {
    companion object {
        fun SettingsDialog(activity: Activity) {
            val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(activity)
            val inflater: LayoutInflater = activity.getLayoutInflater()
            val dialogView: View = inflater.inflate(R.layout.setting_dialog, null)
            dialogBuilder.setView(dialogView)
            val alertDialog: AlertDialog = dialogBuilder.create()

            val tvLogout: TextView = dialogView.findViewById(R.id.tvLogout)
            val tvSetPattern: TextView = dialogView.findViewById(R.id.tvSetPattern)

            tvLogout.setOnClickListener(View.OnClickListener {
                val intent = Intent(activity, RegisterActivity::class.java)
                activity.startActivity(intent)
                activity.finish()
            })

            tvSetPattern.setOnClickListener(View.OnClickListener {

            })

            alertDialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            alertDialog.show()
        }
    }
}