package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.CookBookManagementAdapter

import com.example.myapplication.databinding.CookbookManagementBinding

class Cookbook_Management_Activity : AppCompatActivity() {
    lateinit var binding: CookbookManagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=CookbookManagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()
    }
    private fun initViewPager(){
        //ViewPager2 Adapter 셋팅
        var viewPager2Adapter= CookBookManagementAdapter(this)
        viewPager2Adapter.addFragment(Cookbook_Management_viewpager1())
        viewPager2Adapter.addFragment(Cookbook_Management_viewpager2())

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