package com.doccomsa.basicsyntax8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //collection : Map
        //데이터 저장 순서의 의미가 없고, 데이터를 key로 관리

        //1. map 객체 생성하기 - key : value 쌍으로 구성
        var map = mutableMapOf<String, String>()

        //2.값 저장하기
        map.put("key1", "value1")
        map.put("key2", "value2")
        map.put("key3", "value3")

        //3. 값 사용
        var variable = map.get("key2")
        Log.d("collection", "key2 value : ${variable}")

        //4. 값 수정
        map.put("key2", "value modified")
        Log.d("collection", "key2 modified value : ${map.get("key2")}")

        //5. 값 삭제하기
        map.remove("key2")
        //키가 존재하지 않으면, null값이 출력된다.
        Log.d("collection", "key2 removed value : ${map.get("key2")}")

    }
}