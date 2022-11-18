package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCookbookCommunityViewpager2Binding


class Cookbook_Community_viewpager2 : Fragment() {
    private var _binding: FragmentCookbookCommunityViewpager2Binding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCookbookCommunityViewpager2Binding.inflate(inflater,container,false)
        return _binding!!.root
    }
}