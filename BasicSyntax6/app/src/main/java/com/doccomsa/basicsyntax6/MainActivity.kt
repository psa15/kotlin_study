package com.doccomsa.basicsyntax6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        - 기본타입
            숫자 : Byte, Short, Int, Long, Float, Double
            논리 : Boolean
            문자 : 1)Char : '문자'
                  2)String : "문자열"
         */
        //1. 기본타입 배열 선언하기 - 10개의 빈 공간 생성
        var students = IntArray(10)
        var longArray = LongArray(10)
        var charArray = CharArray(10)
        var floatArray = FloatArray(10)
        var doubleArray = DoubleArray(10)

        //arrayOf() : 선언과 동시에 값 사용 가능
        var intArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        //2. 문자열 타입 선언 - 10개의 빈공간이 생성되고, 하나하나의 요소값이 "" 이다.
        var stringArray = Array(10, {item->""})
        //arrayOf
        var dayArray = arrayOf("MON", "TUE", "WED")

        //3. 배열 사용하기
        //가. [] 대괄호를 사용하는 방법
        students[0] = 90
        students[1] = 91
        students[2] = 92
        //나. set 함수 사용
        students.set(3, 93)
        students.set(4, 94)
        students.set(5, 95)

        //4. 값 변경하기
        intArray[6] = 137 //인덱스 6번의 값이 7에서 -> 137 로 변경
        intArray.set(9, 200)

        //5. 배열 값 사용하기
        var seventhValue = intArray[6]
        Log.d("Array", "7번째 intArray의 값은 ${seventhValue}입니다.")
        var tenthValue = intArray.get(9)
        Log.d("Array", "10번째 intArray의 값은 ${tenthValue}입니다.")

        Log.d("Array", "1번째 ${dayArray[0]}")
        Log.d("Array", "2번째 ${dayArray.get(2)}")
    }
}