package com.doccomsa.basicrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.doccomsa.basicrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //1) 데이터 생성
        val data:MutableList<Memo> = loadData()

        //2) Adapter 생성
        var adapter = CustomAdapter()
        adapter.listData = data

        //3) RecyclerView에 Adapter 연결
        binding.recyclerView.adapter = adapter

        //4) RecyclerView에 레이아웃매니저를 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    //데이터 생성 메소드
    fun loadData() : MutableList<Memo>{

        val data:MutableList<Memo> = mutableListOf()
        //java에서는 List<Memo> data = new ArrayList<Memo>()

        for(no in 1..100){
            val title = "우리는 개발자다. ${no+1}"
            val date = System.currentTimeMillis()

            var memo = Memo(no, title, date)
            data.add(memo)
        }
        return data
    }
}