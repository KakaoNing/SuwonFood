package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCookbookManagementViewpager1Binding
//레시피 관리에서 뷰페이저 화면 1에 대한 Fragment이다.
class Cookbook_Management_viewpager1 : Fragment() {
    //binding 변수 선언
    private var _binding: FragmentCookbookManagementViewpager1Binding?=null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding에 fragment_cookbook_management_viewpager1을 연결시키고 리턴
        _binding= FragmentCookbookManagementViewpager1Binding.inflate(inflater,container,false)
        return _binding!!.root
    }
}