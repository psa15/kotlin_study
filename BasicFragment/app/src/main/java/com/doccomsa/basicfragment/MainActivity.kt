package com.doccomsa.basicfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doccomsa.basicfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    /*
    flag 0 : 처음
    flag 1 : 프래그먼트A
    flag 2 : 프래그먼트B
    가 나타나게
     */
    var flag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //이벤트 리스너 / 이벤트 핸들러 / 이벤트 의 구분
        //이벤트 : 사용자가 마우스나 키보드로 하는 행위
        //이벤트 핸들러 : 호출하는 함수
        //이벤트 리스너 : 연결
        binding.btnSwitch.setOnClickListener {
            //setFragment() : 연습용
            switchFragment()
        }
        binding.btnRemove.setOnClickListener {
            removeFragment()
        }
    }

    fun setFragment() {
        //프래그먼트는 트랜잭션 환경 하에서 제어가 되는 특징을 가지고 있다
        val transaction = supportFragmentManager.beginTransaction()

        //transaction.add(framelayout아이디, 프래그먼트 객체)
        transaction.add(R.id.frameLayout, AFragment())
        transaction.commit()
    }

    fun switchFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        when(flag) {
            0 -> {
                transaction.add(R.id.frameLayout, AFragment())
                flag = 1
            }
            1 -> {
                transaction.add(R.id.frameLayout, BFragment())
                flag = 2
            }
            2 -> {
                transaction.add(R.id.frameLayout, AFragment())
                flag = 1 //이제부터는 switch 버튼을 누르면 b와 a 가 번갈아가며 나타나게 됨
            }
        }

        //뒤로가기 선택 시 이전 프래그먼트를 표시
        transaction.addToBackStack(null)
        transaction.commit()

    }
    //코틀린 문법
    //? : null 을 의미
    // !! : null이 아님
    fun removeFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        val frameLayout = supportFragmentManager.findFragmentById(R.id.frameLayout)

        //fameLayout에 연결되어 있는 Fragment A, B가 삭제된다.
        transaction.remove(frameLayout!!)
        transaction.commit()
    }
}