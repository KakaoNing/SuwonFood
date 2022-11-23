package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.CookBookManagementAdapter

import com.example.myapplication.databinding.CookbookManagementBinding

//레시피 관리에 대한 Activity이다.

class Cookbook_Management_Activity : AppCompatActivity() {
    lateinit var binding: CookbookManagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //cookbook_management의 Binding을 연결
        binding=CookbookManagementBinding.inflate(layoutInflater)


        setContentView(binding.root)

        //뷰페이저2를 연결시키는 함수를 실행
        initViewPager()
    }

    //뷰페이저2를 연결시키는 함수이다.
    private fun initViewPager(){
        //ViewPager2 Adapter 셋팅 32줄~37줄
        //viewPager2Adapter의 초기화 설정
        var viewPager2Adapter= CookBookManagementAdapter(this)

        //viewPager2Adapter에 프래그먼트를 추가시킨다.
        viewPager2Adapter.addFragment(Cookbook_Management_viewpager1())
        viewPager2Adapter.addFragment(Cookbook_Management_viewpager2())

        //Adapter 연결
        //cookbookManagementViewpagerMain이라는 뷰페이저2에 어뎁터를 연결 후 실행이다.
        binding.cookbookManagementViewpagerMain.apply{
            //어뎁터에 viewPager2Adapter를 연결
            adapter=viewPager2Adapter

            //실행시키는 함수이다.
            registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }

}