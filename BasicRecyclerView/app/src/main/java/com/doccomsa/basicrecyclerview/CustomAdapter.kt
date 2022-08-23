package com.doccomsa.basicrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.doccomsa.basicrecyclerview.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

//1)사용자 정의 어댑터 클래스를 만들기 위해서는 RecyclerView.Adapter<홀더> 를 상속받아야 한다.
//2) 홀더 클래스가 먼저 생성되어야 한다.
    //1) 어댑터 클래스 안에 inner클래스로 생성
    //2) 별도 클래스 파일에 생성

//데이터(음식)와 아이템레이아웃(item_recycler.xml-접시)을 바인딩하는 기능(연결)
class CustomAdapter : RecyclerView.Adapter<Holder>() {
    //RecyclerView.Adapter<VH> : VH : ViewHolder를 의미

    //데이터를 받을 변수
    var listData = mutableListOf<Memo>()

    //아래 3개의 추상메소드 재정의의
   //뷰홀더를 만들고, 뷰를 초기화작업, 바인딩 전 상태(데이터와 아이템레이아웃의 연결작업 전)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    //뷰와 데이터의 결합이 이루어짐
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    //데이터의 총 개수
    override fun getItemCount(): Int {
        return listData.size
    }
}

//Holder객체 : 성능 향상을 위하여, 재사용목적으로 만든 것
//-> 아이템 레이아웃과 데이터를, 어댑터 안에서 실제 작업하는 기능
//스크롤을 올릴 때 위에 있던 데이터에 적용된 여러가지를 새롭게 아래 나타나는 데이터에 그대로 적용하는 것!
//옛날에는 아예 새롭게 객체 생성을 했었음 -> 엄청난 성능 과부화
class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        //recyclerView 이벤트 설정작업 -> 목록 클릭했을 때 이벤트 작업
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context
                            , "클릭된 아이템=${binding.textTitle.text}"
                            , Toast.LENGTH_LONG ).show()
        }
    }

    //아이템레이아웃에 데이터 작업
    fun setMemo(memo: Memo){
        binding.textNo.text = "${memo.no}"
        binding.textTitle.text = memo.title

        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedDate = sdf.format(memo.timestamp)
        binding.textDate.text = formattedDate
    }
}