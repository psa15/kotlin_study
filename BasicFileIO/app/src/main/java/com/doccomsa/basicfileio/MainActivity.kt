package com.doccomsa.basicfileio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doccomsa.basicfileio.databinding.ActivityMainBinding
import java.io.*
import java.lang.StringBuilder

/*
데이터 저장소
 - DB
 - 파일 : txt, xml 등

 안드로이드 저장소
  - 파일 데이터를 저장하는 저장소
    - 내부 저장소 : 안드로이드 기기 내부에 저장, 비휘발성
        - 특징
            - 앱을 통해서만 접근이 가능
            - 앱이 삭제되면 사용한 저장소(파일)도 함께 삭제
            - 다른 앱이 저장소(파일)에 접근을 하지 못하게 함
     - 외부 저장소 : 단말기 내부의 공유영역으로 모든 앱이 접근 가능(ex. sd카드)
        - 특징
            - 앱이 삭제되어도 저장소는 삭제되지 않음
            - 접근 제한이 필요하지 않고, 다른 앱과 공유하고 싶은 파일

      - Shared Preferences 저장소
        - 특징
            - 간단한 정보를 저장 시 주로 사용
            - 앱의 초기설정 값 또는 자동 로그인 여부
            - DB로 저장하기에는 부하 및 적당하지 않는 단순 정보
            - 앱이 삭제될 때 함께 삭제
            - 위치 : data/data/패키지명/shared_prefs 폴더에 xml파일 형식으로 관리

 */

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val directory_name = "memo"
        val filename = "memo01.txt"

        binding.btnSave.setOnClickListener {
            val content = binding.textWrite.text.toString()
            writeTextFile(directory_name, filename, content)
        }

        //첫 앱이 실행 시 텍스트 파일의 내용 읽기
        val path = directory_name + "/" + filename
        val writeTextString = readTextFile(path)
        binding.textRead.text =writeTextString
    }

    private fun writeTextFile(directory: String, filename: String, content: String) {
        //앱기본경로/files/memo 폴더 생성
        val dir = File(filesDir.path + "/" + directory) //폴더 생성 X, 객체만 생성
        if(!dir.exists()) dir.mkdirs()

        val fullpath = dir.path + "/" + filename
        val writer = FileWriter(fullpath) //파일 생성 - 1차스트림
        val buffer = BufferedWriter(writer)
        buffer.write(content) //빨대에 내용물 담기
        buffer.close() //flush() 생략 가능! close()메소드가 flush()메소드를 끌고 들어감
        writer.close()
    }

    private fun readTextFile(path: String) : String {
        val fullpath = File(filesDir.path + "/" + path)
        //filesDir.path : 앱기본경로/files 까지
        if(!fullpath.exists()) return ""

        val reader = FileReader(fullpath)
        val buffer = BufferedReader(reader)

        val result = StringBuilder()
        var temp:String? = ""
        //더이상 읽어올 것이 없어지면 null이 되기 때문에 ? 필수!
        while (true) {
            temp = buffer.readLine()
            if(temp == null) break
            result.append(temp).append("\n")
        }
        buffer.close()
        reader.close()
        return result.toString()

    }
}