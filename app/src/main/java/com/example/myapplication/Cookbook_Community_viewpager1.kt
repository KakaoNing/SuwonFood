package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCookbookCommunityViewpager1Binding

class Cookbook_Community_viewpager1 : Fragment() {
    private var _binding: FragmentCookbookCommunityViewpager1Binding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCookbookCommunityViewpager1Binding.inflate(inflater,container,false)
        return _binding!!.root
    }
}