package com.doccomsa.basicpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.doccomsa.basicpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*
    SharedPreferences : 간단한 값을 저장할 때 사용, 초기 설정 값 또는 자동로그인 여부 등
    - 앱 단위로 관리(앱 삭제 시 함께 삭제)
    - xml 파일 형식
    - 데이터 구성(key, value)
    - 읽어올 때 : get타입메소드()
    - 저장할 때 : put타입메소드()
        - 저장할 때는 editor 객체를 생성하고 editor 객체를 통해 저장
    - 파일은 Device File Explorer 메뉴에서 data/data/패키지명/shared_prefs 폴더에서 관리
     */
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //intro.xml 파일 참조
        //Context.MODE_PRIVATE : 보안적인 이유로 대표적인 모드
        val shared = getSharedPreferences("intro", Context.MODE_PRIVATE)
        val intro = shared.getBoolean("first_open", false)

        //앱이 처음 실행이 되었을 때 intro 텍스트 보이기
        //2번째 부터는 실행 시 intro 텍스트 안보이기
        if (intro) {
            binding.textIntro.visibility = View.GONE
        }

        //intro.xml파일 생성, 내용으로 first_open 키의 값으로 true 저장
        val editor = shared.edit()
        editor.putBoolean("first_open", true)
        editor.apply()

    }
}