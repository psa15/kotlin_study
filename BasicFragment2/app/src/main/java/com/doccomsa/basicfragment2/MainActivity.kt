package com.doccomsa.basicfragment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doccomsa.basicfragment2.databinding.ActivityMainBinding

/* 액티비티에서 프래그먼트에 데이터전달 및 상호작용 */
class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            //액티비티 위치에서 fragment 추가작업 및 데이터 전달
            //데이터 구성하기 위한 클래스 : 번들Bundle
            //액티비티에 데이터를 절달할 때 혹은, 액티비티 입장에서 fragment에 데이터를 전달할 때 사용
            val bundle = Bundle()
            bundle.putString("Key", "Hello FragmentA!")
            //bundle이라는 기억장소를 key 와 value로 데이터를 관리

            val fragmentA = AFragment() //AFragment 객체 생성, 코틀린 파일과 레이아웃 파일을 관리
            fragmentA.arguments = bundle
            //arguments : 프래그먼트에 데이터 전달할 때 사용하는 속성

            //fragment 추가 작업
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.frameLayout, fragmentA) //R : res폴더를 가리키는 의미미
            transaction.commit()

       }
    }
}