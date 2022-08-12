package com.doccomsa.basicevent2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //키이벤트
    //soft key : 카톡, 문자보낼 때 팝업으로 나오는 키는 키 이벤트 적용 X
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("onKeyDown", "키 다운 이벤트 발생")
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("onKeyUp", "키 업 이벤트 발생")

        when(keyCode) {
            KeyEvent.KEYCODE_0 -> Log.d("0키", "0번 키를 누름")
            KeyEvent.KEYCODE_1 -> Log.d("1키", "1번 키를 누름")

            //KeyEvent.KEYCODE_ 로 확인 가능
        }
        return super.onKeyUp(keyCode, event)
    }

}