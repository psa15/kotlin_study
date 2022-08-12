package com.doccomsa.basicresourceintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //R class
        //레이아웃과 리소스 폴더에서 작업한 것들이 상수로 R class에 등록됨
    }
}