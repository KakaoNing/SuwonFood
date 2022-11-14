package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCookbookCookingtimeManagementTab1Binding
import com.example.myapplication.databinding.FragmentCookbookCookingtimeManagementTab2Binding
import com.example.myapplication.databinding.FragmentCookbookManagementTab2Binding
import com.example.myapplication.databinding.FragmentCookbookManagementTab3Binding

class Cookbook_Management_Tab2Fragment : Fragment() {

    private var _binding: FragmentCookbookManagementTab2Binding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCookbookManagementTab2Binding.inflate(inflater,container,false)
        return binding.root
    }
}