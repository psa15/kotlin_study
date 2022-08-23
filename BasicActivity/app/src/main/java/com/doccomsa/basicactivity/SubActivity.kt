package com.doccomsa.basicactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doccomsa.basicactivity.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.to1.text = intent.getStringExtra("form1")
        binding.to2.text = "${intent.getIntExtra("form2",0)}"

        //자신을 호출한 MainActivity로 화면이 이동하기 위한 목적의 버튼 이멘트
        binding.btnClose.setOnClickListener {

            //Intent() : ()안에 아무것도 작성 안하면(파라미터 사용 안하면) 자신을 호출한 MainActivity를 의미
            val returnIntent = Intent() //java에서 new 키워드로 객체 생성한 것과 같은 의미!

            returnIntent.putExtra("returnValue", binding.editMessage.text.toString())

            //setResult(resultCode : Int, data: Intent) - result코드 : 자기자신의 상태를 가리킴
            setResult(RESULT_OK, returnIntent) //메인 액티비티로 복귀시 사용할 값
            finish()
        }
    }
}