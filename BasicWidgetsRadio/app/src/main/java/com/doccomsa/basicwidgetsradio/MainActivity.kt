package com.doccomsa.basicwidgetsradio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.doccomsa.basicwidgetsradio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //group : radioGroup
        //checkedId : 선택된 radio버튼 ID
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                //R : res라는 리소스 폴더를 가리킴
                //Toast : 사용자에게 실행하며 안내메시지를 줄 때 사용
                R.id.radioApple -> Toast.makeText(this, "사과가 선택됨", Toast.LENGTH_LONG)
                R.id.radioBanana -> Toast.makeText(this, "바나나가 선택됨", Toast.LENGTH_LONG)
                R.id.radioButton3 -> Toast.makeText(this,"오렌지가 선택됨", Toast.LENGTH_LONG)
            }
        }
    }
}