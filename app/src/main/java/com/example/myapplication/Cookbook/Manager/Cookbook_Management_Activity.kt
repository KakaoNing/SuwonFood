package com.example.myapplication.Cookbook.Manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Other.cookbook_management_ViewPager2adapter
import com.example.myapplication.databinding.ActivityCookbookManagementBinding

class Cookbook_Management_Activity : AppCompatActivity() {
    lateinit var binding:ActivityCookbookManagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCookbookManagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()
    }
    private fun initViewPager(){
        //ViewPager2 Adapter 셋팅
        var viewPager2Adapter= cookbook_management_ViewPager2adapter(this)
        viewPager2Adapter.addFragment(Cookbook_Management_Tab1Fragment())
        viewPager2Adapter.addFragment(Cookbook_Management_Tab2Fragment())
        viewPager2Adapter.addFragment(Cookbook_Management_Tab3Fragment())

        //Adapter 연결

        binding.cookbookManagementViewpagerMain.apply{
            adapter=viewPager2Adapter
            registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }

}