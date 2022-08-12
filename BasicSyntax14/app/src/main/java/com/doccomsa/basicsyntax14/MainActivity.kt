package com.doccomsa.basicsyntax14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    //코틀린에서는 클래스에서 필드선언 시 초기값을 필수로 주어야 함
//    var name: String
    lateinit var name: String
    //val 변수 선언 키워드 사용 X
    //primitive type(원시타입) 사용 불가 (int, boolean 등)

    //객체 생성
//    val person = Person()
    val person : Person by lazy { Person() }
    //by lazy { Person() } : person이라는 변수는 뒤에서 사용할 것이므로 초기값 할당 안할거라는 의미
    //person 변수가 사용이 될 때 {} 안에 있는 코드가 동작이 됨

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Null Safety : 자바의 NullPointerException 문제를 예방하는 목적
        //변수 선언시 Nullable, Null 사용을 엄격하게 허용하는 의미

        //lateinit
        //Nullable 하지 않은 변수를 선언하면서, 값을 할당하는 작업을 뒤로 미루고 싶을 때 사용
        //성능으로 나중에 쓸 때

        name = "Alice"
        //lateinit var name: String 이 필드에 지금 값 준거임

        checkLazy() //by lazy 키워드로 지금 객체가 생성되는 것

    }

    fun checkLazy(){
        print("name=${person.name}")
        //person.name 코드가 동작이 되려면 Person클래스의 객체가 생성되어야만 한다!
        //위의 val person : Person by lazy { Person() } 구문에 의해 사용이 된 순간 객체가 생성됨
        //만약 val person = Person() 이 구문이었다면 미리 메모리에 객체가 생성되어 붙잡고 있는 것 -> 성능 딸림
    }
}

class Person {
    var name: String = "Scott"
}