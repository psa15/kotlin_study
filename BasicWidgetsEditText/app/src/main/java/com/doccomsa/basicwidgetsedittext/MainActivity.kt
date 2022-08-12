package com.doccomsa.basicwidgetsedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.doccomsa.basicwidgetsedittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //editText 뷰에 이벤트 설정
        //뷰마다 기본 이벤트가 있음
        //뷰는 대표적인 이벤트가 있음
        //이벤트 리스너 : 함수인 이벤트 핸들러와 행위를 연결해주는 이벤트
        binding.editText1.addTextChangedListener {
            if(it.toString().length >= 8) {
                Log.d("EditText","8자 이상일 때만 출력 ${it.toString()}")
            }
        }
    }
}