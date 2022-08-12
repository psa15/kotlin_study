package com.doccomsa.basicsyntax12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //프로젝트 -> 모듈 -> 패키지 -> 클래스

        /*======상속==========*/

        //상속 시 접근자 테스트
        var child = Child()
        child.callVariable()

        //부모 클래스 호출
        var parent = Parent()
        //protected, private 접근자의 멤버는 인식 X
        Log.d("Visibility", "Parent : protected변수의 값은 ${parent.defaultVal}")
        Log.d("Visibility", "Parent : protected변수의 값은 ${parent.internalVal}")

    }
}
/*
추상 클래스와 인터페이스
1) 추상 클래스 : 일반 메소드, 추상메소드, 필드 = 초기값
2)인터페이스 : 필드, 일반 메소드, 추상 메소드를 구성요소
*/

//추상 클래스 정의
abstract class Animal {
    //일반 메소드
    fun walk() {
        Log.d("abstract", "걷습니다.")
    }

    //추상메소드
    abstract fun move()
}

//구현
class Bird : Animal() {
    //추상 메소드 구현 -> 구체화
    override fun move() {
        Log.d("abstract", "날아 갑니다.")
    }

}

//인터페이스 정의
interface InterfaceKotlin{
    var variable : String

    //abstrack 키워드 사용 X - 자바와 동일
    //variable 필드에 대한 getter, setter메소드드
   fun get()
    fun set()
}

//구현(implement)
class KotlinImpl : InterfaceKotlin {
    //속성(필드) 재정의
    override var variable: String = "init value"

    override fun get() {

    }

    override fun set() {

    }
}

//접근자
//private : 동일 파일 또는 클래스 내부에서 사용 가능
//public : 어디서나 사용 가능
//protected : 상속받은 클래스에서만 사용 가능
//(추가) internal : 동일 모듈 안에서만 접근이 가능
open class Parent {
    private val privateVal = 1
    protected open  val protectedVal = 2
    internal  val internalVal = 3
    val defaultVal = 4
}

//자식 클래스
class Child : Parent() {
    fun callVariable () {
        //privateVal 접근 X (접근자가 private)
        Log.d("visibility", "Child: protected 변수의 값은 ${protectedVal}")
        Log.d("visibility", "Child: internal 변수의 값은 ${internalVal}")
        Log.d("visibility", "Child: 기본 접근자 defaultVal 변수의 값은 ${defaultVal}")
    }
}