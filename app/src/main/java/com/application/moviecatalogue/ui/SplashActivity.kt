package com.application.moviecatalogue.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.application.moviecatalogue.R

class SplashActivity : AppCompatActivity() {
    private val timer: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler(mainLooper).postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, timer)
    }
}