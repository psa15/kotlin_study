package com.doccomsa.basicfragment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doccomsa.basicfragment3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by  lazy { ActivityMainBinding.inflate(layoutInflater) }

    //미리 객체를 생성
    private val aFragment = AFragment()
    private val bFragment = BFragment()
    private val cFragment = CFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutA, aFragment)
        transaction.commit()
    }

    //Afragment에서 메인 레이아웃의 frameLayoutB에 fragment를 추가
    fun openFragmentOnFrameLayoutB(code: Int) {
        val transaction = supportFragmentManager.beginTransaction()

        when(code){
            1 -> transaction.replace(R.id.frameLayout2, bFragment)
            2 -> transaction.replace(R.id.frameLayout2, cFragment)
        }
        transaction.commit()
    }

    fun changeText(str: String){
        //b프래그먼트 텍스트 내용 변경
        bFragment.setText(str)
    }
}