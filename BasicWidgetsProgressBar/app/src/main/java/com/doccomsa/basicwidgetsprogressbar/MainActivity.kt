package com.doccomsa.basicwidgetsprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.doccomsa.basicwidgetsprogressbar.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*쓰레드
        1) 주 쓰레드 : onCreate메소드 안에서 사용하는 쓰레드는 주 쓰레드
        2) 작업자 쓰레드 :
            - 코틀린에서 간단하고 빠르게 쓰레드를 작업하는 코틀린 스레드 문법
                thread(start = true) {

                }
                위의 코드가 쓰레드로 동작됨 - 독립적인 동작
         */

        //메인 스레드 안에서는 UI접근 가능
        //binding.progressBar

        thread(start = true) {
            Thread.sleep(3000) //1초 일시정지

            //UI 의 ProgressBar를 접근하여 동작
            //메인 스레드가 아닌 스레드에서는 UI를 접근할 수 없도록 설계
            //작업자스레드에서 UI를 접근 가능하게 해줌
            runOnUiThread{
                showProgress(false)
                //binding.progressBar.visibility = View.GONE 으로 작동
            }
        }

    }

    //함수 선언
    fun showProgress(show: Boolean) {
        binding.progressBar.visibility = if(show) View.VISIBLE else View.GONE
        binding.textView.text="다운로드 완료"
    }
}