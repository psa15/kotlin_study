package com.doccomsa.basicactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.doccomsa.basicactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    /*람다식 문법
    함수 {
     파라미터 1, 파라미터 2 ->
     구문
     }
     */

   //앱의 시작점(진입점)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       /* 예전 스타일로 주석
       binding.btnStart.setOnClickListener {

           //화면을 전환할 두번 째 액티비티 정보를 구성하고 있는 인텐트 선언
           val intent = Intent(this, SubActivity::class.java)

           //데이터 전달
           intent.putExtra("form1", "hello Bundle")
           intent.putExtra("form2", 2022)

           //제어를 Sub액티비티로 이동만 할 때 (다시 복귀 X)
//           startActivity(intent)

           //Sub액티비티에서 Main액티비티로 복귀할 때 사용하는 구문
           startActivityForResult(intent,10)

       }*/

       //onActivityResult메소드의 대안
       val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
           //it.resultCode : 서브액티비티에서 넘어온 resultCode
           if(it.resultCode == RESULT_OK) {
               val message = it.data?.getStringExtra("returnValue")
               Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
           }
       }

       //화면을 전환할 두번 째 액티비티 정보를 구성하고 있는 인텐트 선언
       val intent = Intent(this, SubActivity::class.java)

       //데이터 전달
       intent.putExtra("form1", "hello Bundle")
       intent.putExtra("form2", 2022)

       binding.btnStart.setOnClickListener { activityResult.launch(intent) }

   }

    //특정 위치에서 메소드를 구현하고자 할 경우 단축키 ctrl + o
    //Sub액티비티가 종료되면서 호출되는 함수(콜백함수- 자바 ajax의 success 안의 함수들이 다 콜백함수임)
    //콜백 : 데이털르 보낸 후 작업이 종료되어 돌아올 때 미리 준비된,,,,,작업?이 실행???
    /*
    requestCode : 위에서 버튼사용시 10번으로 줌
    resultCode : Sub액티비티의 RESULT_OK 값
    data : Sub액티비티의 인텐트 값
     */
    /*예전 스타일로 주석
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

 현재는 버튼이 1개이기 때문에 쓸 필요 없음
       if(requestCode ==10) {

        } else if(requestCode == 20) {
            //만약 버튼2가 있고 이 버튼의 requestCode가 20일 때
        }

        if(requestCode == Activity.RESULT_OK) {
            when (requestCode) {
                10 -> {
                    //onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) 의 data에 ? nullable 처리가 되어 있음
                    val returnValue = data?.getStringExtra("returnValue")
                    Toast.makeText(this, returnValue, Toast.LENGTH_LONG).show()
                }
            }
        }
    }*/
}