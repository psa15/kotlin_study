package com.doccomsa.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doccomsa.scrollview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}