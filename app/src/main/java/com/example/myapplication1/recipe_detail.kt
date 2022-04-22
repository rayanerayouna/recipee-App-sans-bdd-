package com.example.myapplication1

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.adapter.RecipeeAdapter

class recipe_detail(private val adapter: RecipeeAdapter) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE)

    }
}