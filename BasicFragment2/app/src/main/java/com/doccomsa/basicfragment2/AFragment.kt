package com.doccomsa.basicfragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.doccomsa.basicfragment2.databinding.FragmentABinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AFragment : Fragment() {

    //onCreateView() 메소드만 남기고, 나머지는 삭제!

    //var binding : FragmentABinding? = null
    // 메모리가 이미 생성이 되어 binding.textView.text = arguments?.getString("key")의 binding오류남

    lateinit var binding : FragmentABinding

    override fun onCreateView(
                                inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?
                            ): View? {

        binding = FragmentABinding.inflate(inflater, container, false)
        binding.textView.text = arguments?.getString("key")
        //arguments.getString("key")  : MainActivit.kt에 bundle로 구성한 "key"

        return binding.root
    }
}