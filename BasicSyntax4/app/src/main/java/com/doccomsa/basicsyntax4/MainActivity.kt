package com.doccomsa.basicsyntax4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //when구문의 일반적인 형태
        var now = 9 //타입 유추 == var now : Int = 9
        when(now) {
            8 -> {
                Log.d("When", "현재 시간은 8시 입니다.")
            }
            9, 10 -> {
                Log.d("When", "현재 시간은 9시 또는 10시 입니다.")
            }
            else -> {
                Log.d("When", "지금은 8 ~ 10시가 아닙니다.")
            }
        }
        
        //in을 사용하여 범위 비교
        var aqeOfJack = 19
        when (aqeOfJack) {
            in 10..19 -> Log.d("When", "잭은 10대 입니다.")
            //10..19 : 10~19
            //하나의 케이스만 쓸 경우에는 {} 필요 없음
            
            !in 10..19 -> Log.d("When", "잭은 10대가 아님")
            
            else -> Log.d("When", "잭의 나이를 알 수 없음")
        }

        //인자가 없이 if처럼 조건식 사용
        var currentTime = 6
        when{
            currentTime == 5 -> {
                Log.d("When", "현재 시간은 5시 입니다.")
            }
            currentTime > 5 -> {
                Log.d("When", "현재 시간은 5시가 넘었습니다.")
            }
            else -> {
                Log.d("When", "현재 시간은 5시 이전입니다.")
            }
        }

        var eraOfRyu = 2.32
        var eraOfDegrom = 2.43

        //var : 일반 변수 선언 키워드
        //val : 상수로 값 변경 X(자바의 final)
        val era = if(eraOfRyu < eraOfDegrom) {
            Log.d("MLB_Result", "2019류현진이 디그롬을 이김")
            eraOfRyu
        } else {
            Log.d("MLB_Result",  "2019 디그롬이 류현진을 이김")
            eraOfDegrom
        }
        Log.d("MLB_Result", "2019 MLB 가장 높은 ERA는 ${era}입니다.")
    }
}