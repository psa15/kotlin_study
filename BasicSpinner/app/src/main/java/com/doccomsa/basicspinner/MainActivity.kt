package com.doccomsa.basicspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.doccomsa.basicspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        /*
        코틀린 문법
         - 컬렉션
            - 1) immutable(불변) : read-only - 데이터 추가/변경/삭제 X
            - 2) mutable(가변) : read & write - 데이터 추가/변경/삭제 O
         */
        //핸들바 템플릿과 비슷하게 작업 예정
        //데이터와 Spinner위젯을 연결하는 것이 바인딩(Adapter-연결)
        //어댑터는 기본적으로 제공되기도 하고 사용자가 정의할 수도 있음

        //1) Spinner 위젯에 보여 줄 데이터
        var data = listOf("--선택하세요--", "1월", "2월", "3월", "4월", "5월")

        //2) Adapter 준비 : 데이터와 위젯의 데이터 연결(바인딩)
        //데이터를 아이템 레이아웃에 담아 Spinner에 담는 것@
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        //context : MainActivity를 가리킴 -> this

        //3) spinner의 adapter속성에 adapter 객체 대입
        binding.spinner.adapter = adapter

        //이벤트 설정
       binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //object 가 오류가 나는데 OnItemSelectedListener가 인터페이스라 재정의 해야함
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.result.text = data.get(position)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }
}
