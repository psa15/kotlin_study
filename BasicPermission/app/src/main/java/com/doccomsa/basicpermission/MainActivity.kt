package com.doccomsa.basicpermission

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.doccomsa.basicpermission.databinding.ActivityMainBinding

/*
권한 - 보통은 일반권한과 위험권한 2종류로 단순하게 분리
1) 설치 시간권한(일반 권한, 서명 권한)
2) 런타임권한(위험권한)
3) 특별 권한

권한의 종류 : 다양함(안드로이드 공식사이트 참조)

개념 : 앱 설치 및 실행을 할 경우, 안드로이드기기 사용자에게 권한을 요청하고 동의를 구하는 의미

권한 작업
1) AndroidManifest.xml 파일에서 권한 설정 필요
 */
class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    lateinit var activityResult : ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*
        권한 작업 앱개발 시 구현 방법 3단계
        1. 권한에 대한 사용자 승인 확인 (이전에 승인 했는지 여부 체크)
        2. 사용자에게 권한 요청하기
        3. 사용자 승인 후 처리
         */

        //1. 권한에 대한 승인 확인 여부 체크
        //승인된 상태라면 대화상자가 표시되지 않고 true로 진행이 되며 카메라가 동작하는 구문을 실행
        //사용자 승인 대화상자에서 권한을 승인하면 true
        //사용자 승인 대화상자에서 권한을 승인하지 않으면, false
        activityResult = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if(isGranted) {
                //승인된 상태
                openCamera()
                //사용자가 실행하고자 하는 기능이 시작되게

            } else {
                //종료
                Toast.makeText(this, "권한을 승인하지 않으면 앱이 종료됩니다.", Toast.LENGTH_LONG).show()
                finish()
            }
        }

        //카메라 버튼
        binding.btnCamera.setOnClickListener {
            //위험권한인 카메라 권한에 대한 승인 여부를 체크하는 코드 구문
            //Manifest : java가 아닌 android로 선택하기
            //Manifest.permission.CAMERA : AndroidManifest.xml에 권한 설정한 구문
            activityResult.launch(Manifest.permission.CAMERA)
            //승인 여부 대화상자에서 승인 또는 거부시 42번 라인 호출
            //승인된 상태라면 대화상자 X -> 바로 42번 라인 호출
        }
    }

    private fun openCamera() {
        //안드로이드 카메라기능 동작구문
        Toast.makeText(this, "카메라를 실행합니다.", Toast.LENGTH_LONG).show()

        //인텐트 작업
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 99)
    }
}