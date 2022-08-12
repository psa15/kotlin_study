package com.doccomsa.basicsyntax12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. 부모 클래스 사용하기 자바에서 사용하는 new 키워드 사용 X
        var parent = Parent()
        parent.sayHello()

        //2. 자식 클래스 사용하기
        var child = Child()
        child.myHello()

        testStringExtension()

    }

    //String클래스 확장 사용
    fun testStringExtension() {
        var original = "Hello"
        var added = " Guys~"

        //String인 변수에 plus()함수를 사용
        Log.d("extension", "added를 더한 값은 ${original.plus(added)}")
    }
}

//상속
//상속 목적으로 정의한 클래스는 open 키워드가 필요
open class Parent {
    var hello : String = "안녕"
    fun sayHello() {
        Log.d("상속", "${hello}")
    }
}

//부모 클래스에 () 필수!
class  Child : Parent() {
    fun myHello() {
        hello = "Hello"
        sayHello()
    }
}

//메소드 overriding : 부모 클래스의 메소드를 자식 클래스에서 재정의하는 문법
open class BaseClass {
    //open 키워드를 사용해야 자식클래스에서 재정의가 가능
    open fun opened(){

    }
    fun notOpened(){

    }
}

class ChildClass : BaseClass() {
    override fun opened() {
        super.opened()
    }

    /*  재정의 X
        override fun notOpened() {

        }
     */
}

//프로퍼티 오버라이딩
open class BaseClass2{
    open var opened : String = "I am opened"
}

class ChildClass2 : BaseClass2(){
    override var opened : String = "You are"
}

//클래스에 메소드 확장 추가
//예) String 클래스에 plus 메소드를 추가해서 사용
fun String.plus(word: String) : String {
    return  this + word
}