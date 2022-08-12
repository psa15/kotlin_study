package com.doccomsa.basicsyntax9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //collection : set
        //순서가 없음, 중복 허용 X, 주머니에 공을 보관한다고 생각

        //1. set 객체 생성하기
        var set = mutableSetOf<String>()

        //2. 값 추가
        set.add("Jan")
        set.add("Aug")
        set.add("Nov")
        set.add("May")
        set.add("Dec")

        //3. 값 출력
        Log.d("Collection", "Set : ${set}")

        //4. 값 삭제
        set.remove("Jan")
        Log.d("Collection", "Set : ${set}")
    }
}