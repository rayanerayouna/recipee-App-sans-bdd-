package com.example.myapplication1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScrenn : AppCompatActivity() {

    private  val SPLASH_TIME  : Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screnn)

        Handler().postDelayed( {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },SPLASH_TIME)


    }
}