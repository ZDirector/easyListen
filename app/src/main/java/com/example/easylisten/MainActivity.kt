package com.example.easylisten

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.common.utils.showToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showToast("abc")
    }
}