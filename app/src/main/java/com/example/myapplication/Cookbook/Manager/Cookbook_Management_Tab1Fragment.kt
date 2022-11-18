package com.example.myapplication.Cookbook.Manager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCookbookCookingtimeManagementTab1Binding
import com.example.myapplication.databinding.FragmentCookbookManagementTab1Binding
import com.example.myapplication.databinding.FragmentCookbookManagementTab2Binding

class Cookbook_Management_Tab1Fragment : Fragment() {
    private var _binding: FragmentCookbookManagementTab1Binding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCookbookManagementTab1Binding.inflate(inflater,container,false)
        return _binding!!.root
            }
}