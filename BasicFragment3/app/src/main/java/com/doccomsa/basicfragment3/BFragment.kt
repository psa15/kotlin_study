package com.doccomsa.basicfragment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.doccomsa.basicfragment3.databinding.FragmentABinding
import com.doccomsa.basicfragment3.databinding.FragmentBBinding


class BFragment : Fragment() {

    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun setText(str: String){
        binding.textView.text
    }

}