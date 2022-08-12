package com.doccomsa.basicstopwatchevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import com.doccomsa.basicstopwatchevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lazy 키워드로 val 만 사용 가능 (var X)
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //뒤로가기 버튼을 누른 시각을 저장하는 속성
   var initTime = 0L
    //멈춘 시각을 저장
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //start event
        //SystemClock.elapsedRealtime() : 시스템이 부팅된 이후 경과된 시간을 반환(절전모드에서 지속됨)
        binding.startButton.setOnClickListener {
            //기준시간을 지정(시작하는 시간을 지정)
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start() //스탑워치 기능 시작

            //버튼표시
            binding.resetButton.isEnabled = true //setter가 작동
            binding.stopButton.isEnabled = true
            binding.startButton.isEnabled = false
        }

        //stop event
        binding.stopButton.setOnClickListener {
            pauseTime = binding.chronometer.base
            binding.chronometer.stop()

            //버튼표시
            binding.resetButton.isEnabled = true
            binding.stopButton.isEnabled = false
            binding.startButton.isEnabled = true
        }

        //reset event
        binding.stopButton.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            //버튼표시
            binding.resetButton.isEnabled = false
            binding.stopButton.isEnabled = false
            binding.startButton.isEnabled = true
        }

    }

    //뒤로가기 버튼 이벤트 핸들러 : 액티비티 클래스에서 제공하는 이벤트
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        //뒤로가기 버튼 클릭
        if(keyCode === KeyEvent.KEYCODE_BACK){
            //뒤로가기 버튼을 처음 눌렀거나 누른 지 3초가 경과한 후 처리
            if(System.currentTimeMillis() - initTime > 3000) { //3000 = 3초
                Toast.makeText(this, "종료하려면 한 번 더 누리세요", Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }

        return super.onKeyDown(keyCode, event)
    }

}