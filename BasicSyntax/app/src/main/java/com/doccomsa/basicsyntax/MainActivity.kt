package com.doccomsa.basicsyntax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //로그 출력 명령어
        Log.d("BasicSyntax", "로그를 출력합니다. method = Log.d")

        //변수 선언
        //1) 변수 타입을 우측의 값을 보고 유추하여 타입이 지정됨
        var myName = "홍길동"
        //2) 데이터타입을 명시적으로 제공하는 방법
        var myAge : Int
        myAge = 27
        myAge = myAge + 1

        //문자열 템플릿인 "" 문자열 안에서 변수명을 사용하고자 할 경우 $변수명 형식을 사용
        Log.d("BasicSyntax", "myName = $myName, myAge = $myAge")
    }
}