package com.doccomsa.basicwidgetsseekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.doccomsa.basicwidgetsseekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*
    SeekBar : 사용자가 범위내에서 값을 선택할 수 있도록 도와주는 기능, 막대형태의 뷰
    음량, 밝기 조절, 이미지 필터 적용, 동영상 재생 등에 사용
     */

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            //3개의 메소드 구현 필!
            //seekbar 조작하고 있는 중에 발생 - p1(파라미터): Int(데이터타입)
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textView.text="$progress"
            }
            //seekbar를 처음 터치했을 때 발생
            override fun onStartTrackingTouch(p0: SeekBar?) {

            }
            //seekbar 터치카 끝났을 때 발생
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
}