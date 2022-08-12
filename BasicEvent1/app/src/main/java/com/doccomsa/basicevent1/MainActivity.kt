package com.doccomsa.basicevent1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    
    //override : 재정의 키워드
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //터치 이벤트 재정의
    /*
    ACTION_DOWN : 화면에 손가락으로 눌렀을 때
    ACTION_UP : 화면에 손가락을 떼었을 때
    ACTION_MOVE : 화면에 손가락으로 누른채 이동할 때
    onTouchEvent() : 손가락으로 이벤트가 발생이 되면 자동 호출되는 함수
     */
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        
        //event 변수가 널이 아니었을 꼉우 action명령어를 호출
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                //Log.d("ACTION_DOWN ","터치 다운")
                //좌표구하기 - p.215
                /*
                event.rzwX = event.x : 버튼, 텍스트 뷰 등을 사용하지 ㅇ낳고, 화면에서만 터치이벤트가 발생했을 경우
                  - 화면을 기준으로 event.x, evnt.y, eventrawX, eventrawY
                event.x == event.rawX : 화면에 터치가 발생도니 경우네는 값이 동일
                event.x != event.rawX : 버튼에 터치가 발생된 경우에는 값이 다름
                                        event.x : 버튼 기준
                                        event.rawX : 액티비티 화면 기준
                 */
                Log.d("ACTION_DOWN ","x: ${event.x}, rawX : ${event.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("ACTION_UP", "터치 업")
            }
        }
            
        
        return super.onTouchEvent(event)
    }
}