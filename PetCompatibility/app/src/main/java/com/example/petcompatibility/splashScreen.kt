package com.example.petcompatibility

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate to MainActivity after 2 seconds
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000) // 2000ms = 2 seconds
    }
}
