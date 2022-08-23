package com.doccomsa.basicfragment3

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.doccomsa.basicfragment3.databinding.ActivityMainBinding
import com.doccomsa.basicfragment3.databinding.FragmentABinding

class AFragment : Fragment() {

    //val binding by lazy { FragmentABinding.inflate(layoutInflater) }
    private lateinit var binding: FragmentABinding

    var mainActivity: MainActivity? =null

    //AFragment 객체가 생성시 제일 먼저 호출되는 메소드
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentABinding.inflate(inflater, container, false)

        //fragment안의 버튼 이벤트 등록작업
        binding.btnShowFragmentB.setOnClickListener {
            mainActivity!!.openFragmentOnFrameLayoutB(1)
        }

        binding.btnShowFragmentC.setOnClickListener {
            mainActivity!!.openFragmentOnFrameLayoutB(2)
        }

        //이벤트(터치, 클릭 등), 이벤트 리스너(연결), 이벤트 핸들러(함수)
        binding.btnChangeFragmentB.setOnClickListener {
            //val items = arrayOf("오늘 기분이 좋아?", "응")
           // var selectedItem: String? = null
            val builder = AlertDialog.Builder(mainActivity!!)
                .setTitle("제목")
                .setMessage("내용")
                .setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, id ->
                    mainActivity!!.changeText("확인 선택")
                })
                .setNegativeButton("취소", DialogInterface.OnClickListener { dialogInterface, id ->
                    mainActivity!!.changeText("취소 선택")
                })
            builder.show()
        }
        return binding.root
    }


}