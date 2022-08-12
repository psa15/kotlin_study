package com.doccomsa.basicsyntax7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //컬렉션 : List, Set, Map


        //immutable(불변(코틀린 기본), readonly) vs. mutable(가변, read & write)
        //자바에서는 무조건 mutable - 컬렉션을 생성하고 기억장소의 추가, 삭제, 변경 가능

        //1. 값으로 컬렉션 생성하기 - mutable
       var mutableList = mutableListOf("MON", "TUE", "Wed")
        //제너릭이 사용되지 않았기 때문에 int형도 모든 데이터타입의 데이터 사용 가능

        //값 추가하기
        mutableList.add("Thu")
//        mutableList.add(1) //빨간줄은 나오지만 가능?
        //값 꺼내기
        Log.d("Collection", "mutableList의 첫번째 값은 ${mutableList.get(0)}")

        //immutable
        var list = listOf(1,2,3, "String")
        //추가, 변경, 삭제 지원 X
        //list.add()   (X)

        //2. 빈 컬렉션  생성하기
        var stringList = mutableListOf<String>()
        //제너릭을 사용했기 때문에 String만 가능

        //값 추가
        stringList.add("월")
        stringList.add("화")
        stringList.add("수")
        //값 변경하기
        stringList.set(1, "날짜 변경")
        Log.d("Collection", "stringList에 입력된 두번째 값은 ${stringList.get(1)}") //"날짜 변경"
        //값 삭제
        stringList.removeAt(1) //두번째 값 삭제됨 -> 세번째의 값이 두번째 인덱스로 당겨짐
        Log.d("Collection", "stringList에 입력된 두번째 값은 ${stringList.get(1)}") //"수"
    }
}