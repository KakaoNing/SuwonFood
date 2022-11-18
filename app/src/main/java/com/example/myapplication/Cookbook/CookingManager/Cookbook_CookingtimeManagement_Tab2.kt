package com.example.myapplication.Cookbook.CookingManager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCookbookCookingtimeManagementTab1Binding
import com.example.myapplication.databinding.FragmentCookbookCookingtimeManagementTab2Binding

class Cookbook_CookingtimeManagement_Tab2 : Fragment() {
    private var _binding: FragmentCookbookCookingtimeManagementTab2Binding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCookbookCookingtimeManagementTab2Binding.inflate(inflater,container,false)
        return _binding!!.root
    }
}