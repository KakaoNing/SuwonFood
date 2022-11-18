package com.example.myapplication.Cookbook.Manager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCookbookManagementTab3Binding


class Cookbook_Management_Tab3Fragment : Fragment() {

    private var _binding: FragmentCookbookManagementTab3Binding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCookbookManagementTab3Binding.inflate(inflater,container,false)
        return binding.root
    }
}