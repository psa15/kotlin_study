package com.doccomsa.basicsyntax13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Null Safety : 널을 허용하겠다는 의미

//        String str = null;
        //java에서 사용하는 문법으로 NPE(NullPointerException)가 자주 일어남
        //객체가 null인 상태에서 실행되어(참조가 되지 않아) 발생하는 예외

        //코틀린에서는 null을 사용가능하게 하려면 변수 선언시 미리 허용해줘야 함 -> 타입에 ? 추가하기
        var nullable1: String?
        nullable1 = null //변수 선언시 String에 ?가 없으면 에러가 남

        var nullable: String? = null
//        var size = nullable.length //.은 참조 연산자인데 nullable이 null인 상태이기 때문에 참조 불가로 에러
        //자바에서는 문법에선 에러가 안나지만 컴파일 과정에서 예외가 발생하게 됨 -> 에러 찾기 힘듦
        //코틀린에서는 문법에서부터 에러가 나서 바로 고칠 수 있음

        var size = nullable?.length
        //nullable변수가 null이면 .length가 동작이 안됨

        var size1 = nullable?.length?:33
        //nullable이 not null이면 length값이 size1에 할당
        //nullable이 null이면 33이 size1에 할당
        //-> 내부적으로 if문이 돌고 있는 것!

        Log.d("Nullable", "문자열의 길이 = ${size1}")
    }

    //java식으로 풀어내면
    fun nullParameter(str : String?) {
        if(str != null) {
            var length2 = str.length
            Log.d("Null Safety", "문자열 길이 = $length2")
        }
        Log.d("Null Safety", "문자열이 입력되지 않았습니다")
    }

    fun nullReturn() : String? {
        return null
    }
}
