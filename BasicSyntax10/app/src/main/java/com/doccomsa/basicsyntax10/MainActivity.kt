package com.doccomsa.basicsyntax10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //코틀린 함수
        /*
        함수 선언(정의)
            fun 함수명 () : 리턴타입
            - onCreate함수 밖에서 선언해야 함
         */

        var squareResult = square(10)
        Log.d("fun", "10의 제곱은 ${squareResult}")

        printSum(3,5)

        //val : 자바의 final로 대문자로 작성함
        val PI = getPi()
//        PI = 100 -> PI는 변경될 수 없기 때문에 에러
        Log.d("fun", "지름이 10인 원의 둘레는 ${10 * PI}")

        newFunction("안녕")
        newFunction("Alice", weight = 70.0)
    }

    //1. 반환값이 있는 함수
    //자바는 int x, 리턴타입 변수 이렇게 선언
    //코틀린 변수 = x : Int, 리턴타입 = : Int
    fun square(x : Int) : Int {
        return x * x
    }

    //2. 반환값이 없는 함수
    fun printSum(x: Int, y: Int) : Unit {
        //: Unit 은 생략 가능 - 자바의 void와 같은 의미
        Log.d("fun", "x + y = ${x + y}")
    }

    //3. 매개변수가 없고 반환값이 있는 함수
    fun getPi() : Double {
        return 3.14
    }

    //4. 매개변수가 기본값을 갖는 함수
    fun newFunction (name: String, age: Int = 29, weight: Double = 65.5) {
        Log.d("fun", "name의 값은 ${name}입니다.")
        Log.d("fun", "age의 값은 ${age}입니다.")
        Log.d("fun", "weight의의 값은${weight}입니다.")
    }
}