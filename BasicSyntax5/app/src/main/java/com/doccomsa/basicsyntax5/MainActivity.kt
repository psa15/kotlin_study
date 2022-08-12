package com.doccomsa.basicsyntax5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //while, do~while, for

        //1.일반적인 while
        var current = 1
        val until = 12
        while (current < until) {
            Log.d("While", "현재값은 ${current}")

            current = current + 1
        }

        //2. do ~ while
        var game = 1
        val match = 5
        do{
            Log.d("While", "${game}게임을 이겼습니다. 우승까지 ${match - game}")
            game += 1
        } while(game < match)

        //3.for 문
        for(index in 1..10) {
            Log.d("While", "break > 현재 index는 $index 입니다.")
            //$뒤에 바로 변수명이 온다면 변수명과 문자열을 붙이면 안됨(ex> $index입니다. (X)

            if(index > 5) {
                break
            }
        }

        for(except in 1..10) {
            if(except > 3 && except < 8) {
                continue
            }
            Log.d("While", "continue -> 현재 index는 $except 입니다")
        }

        //for문
        //1. 일반적인 형태
        for(index in 1..10) {
            Log.d("For", "현재 숫자는 ${index}")
        }
        //2. 배열 또는 컬렉션을 이용한 for문
        var array = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul","Aug")
        //arrayOf() 메소드 : 배열 만들어주는 메소드
        for(index in 0 until array.size) {
            //0 ~ 7까지 array.size는 8인데 until로 인해 7까지로 인식됨
            Log.d("For", "현재 월은 ${array.get(index)}")
        }
        //3. 건너뛰기 - 0, 3, 6, 9
        for(index in 0..10 step 3){
            Log.d("For", "건너뛰기 step 3 : ${index}")
        }
        //4.감소시키기 - 10부터 0까지
        for(index in 10 downTo 0) {
            Log.d("For", "감소시키기 : ${index}")
        }
        //4-1. 건너뛰면서 감소시키기
        for(index in 10 downTo 0 step 3) {
            Log.d("For", "건너뛰면서 감소시키기 step 3 : ${index}")
        }
        
        //5. 향상된 for 문
        for(month in array) {
            Log.d("For", "현재 월은 ${month} 입니다")
        }

    }
}
