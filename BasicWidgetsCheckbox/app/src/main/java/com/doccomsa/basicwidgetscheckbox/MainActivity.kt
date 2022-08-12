package com.doccomsa.basicwidgetscheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.doccomsa.basicwidgetscheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //공통 이벤트 핸들러(함수)
    val listener by  lazy {
        /*
        화면단에 작성한 것들은 클래스로 관리됨
        CompoundButton : CheckBox 클래스의 부모가 CompoundButton 임
        공통 이벤트 핸들러 작성을 위해 사용
         */
        CompoundButton.OnCheckedChangeListener { button, ischecked ->
            if(ischecked){
                when(button.id){
                    R.id.checkApple -> Toast.makeText(this, "사과가 선택됨", Toast.LENGTH_SHORT).show()
                    R.id.checkBanana -> Toast.makeText(this, "바나나가 선택됨", Toast.LENGTH_SHORT).show()
                    R.id.checkCherry -> Toast.makeText(this, "체리가 선택됨", Toast.LENGTH_SHORT).show()
                }
            } else {
                when(button.id){
                    R.id.checkApple -> Toast.makeText(this, "사과가 선택해제됨", Toast.LENGTH_SHORT).show()
                    R.id.checkBanana -> Toast.makeText(this, "바나나가 선택해제됨", Toast.LENGTH_SHORT).show()
                    R.id.checkCherry -> Toast.makeText(this, "체리가 선택해제됨", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.checkApple.setOnCheckedChangeListener(listener)
        binding.checkCherry.setOnCheckedChangeListener(listener)
        binding.checkBanana.setOnCheckedChangeListener(listener)

/*        binding.checkApple.setOnCheckedChangeListener { button, ischecked ->
            if(ischecked){
                Toast.makeText(this, "사과가 선택됨", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "사과가 선택해제됨", Toast.LENGTH_SHORT).show()
            }
        }
        binding.checkBanana.setOnCheckedChangeListener { button, ischecked ->
            if(ischecked){
                Toast.makeText(this, "바나나가 선택됨", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "바나나가 선택해제됨", Toast.LENGTH_SHORT).show()
            }
        }
        binding.checkCherry.setOnCheckedChangeListener { button, ischecked ->
            if(ischecked){
                Toast.makeText(this, "체리가 선택됨", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "체리가 선택해제됨", Toast.LENGTH_SHORT).show()
            }
        }*/


    }
}