package com.doccomsa.basicviewevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.doccomsa.basicviewevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //뷰 바인딩 설정을 한 후 동기화 작업을 하면, 레이아웃을 참조하는 클래스가 생성됨
    //레이아웃 파일 이름(activity_main.xml)을 참조하는 클래스명 : ActivityMainBinding
    //by lazy : 늦은 초기화 - binding 변수가 실제 사용되는 시점에 1번 초기화 작업이 발생
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    //binding : 레이아웃 참조하는 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root) //LinearLayout을 파라미터로 제공하면 액티비티 화면에 출력

        binding.btn1.setOnClickListener {
            Log.d("btn1", "버튼1이 선택되었습니다.")
            Toast.makeText(this, "버튼1이 클릭됨", Toast.LENGTH_LONG).show()
        }
    }
}