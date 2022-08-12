package com.doccomsa.basicsyntax11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. 생성자가 없는 클래스 호출
        Kotlin()

        //2. 클래스의 생성자 사용
        KotlinTwo("Hello")

        //3. 클래스의 프로퍼티와 메소드 사용하기
        var kotlin = KotlinThree()
        kotlin.printOne()
        kotlin.one = "Hi"
        kotlin.printOne()

        //4. companion object 사용하기 -> 클래스명.필드, 클래스명.메소드()
        KotlinFour.printOne()
        KotlinFour.one = "Bye"
        KotlinFour.printOne()

        //5. 데이터 클래스 사용하기
        var dataUser = DataUser("Alice", 27)
        var newUser = dataUser.copy() //복사
        newUser.name = "Cindy"

        Log.d("class", "원본 dataUser는 ${dataUser.toString()}")
        Log.d("class", "복사본 newUser는 ${newUser.toString()}")


    }
}

//코틀린 : 클래스

//파라미터가 없는 클래스
class Kotlin(){
    //자바와 다른 점 클래스명 옆에 () 가 들어감 -> 디폴트 생성자 역할을 함
    init { //객체가 생성되면 초기화 해주는 작업
        Log.d("class", "Kotlin 클래스 생성됨")
    }
}

//파라미터가 있는 세컨더리 생성자(default 생성자가 아닌 다른 생성자)
class  KotlinTwo {
    constructor(value: String) {
        Log.d("class", "KotlinTwo : 파라미터값은 ${value}입니다.")
    }
}

//property(속성)과 메소드가 있는 클래스
//필드(프로퍼티)는 선언과 동시에 초기화(값을 주어야)해야 한다.
class KotlinThree {
    var one: String = "None" //필드 혹은 속성
    fun printOne(){ //메소드
        Log.d("class", "KotlinThree : one의 값은 ${one}입니다.")
    }
}

//static멤버를 갖는 클래스 - static(java), companion object(Kotlin)
class KotlinFour{
    companion object {
        var one: String = "None"
        fun printOne(){
            Log.d("class", "KotlinFour : one의 값은 ${one}입니다.")
        }
    }
}

//데이터 클래스 자바의 VO 클래스 - {} 사용 X
data class DataUser(var name: String, var age: Int)