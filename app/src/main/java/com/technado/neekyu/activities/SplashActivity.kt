package com.technado.neekyu.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.technado.neekyu.R
import com.technado.neekyu.databinding.SplashActivityBinding

class SplashActivity : AppCompatActivity() {
    var binding: SplashActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}