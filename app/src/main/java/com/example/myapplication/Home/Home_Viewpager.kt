package com.example.myapplication.Other

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Home.Home_Left
import com.example.myapplication.Home.Home_Right
import com.example.myapplication.Home.home_middle_recipe
import com.example.myapplication.R
import kotlinx.android.synthetic.main.base_main_layout.*


class home_viewpager : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_viewpager, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //어뎁터 선언
        val pagerAdapter= PagerFragmentStateAdapter(requireActivity())

        //메인화면 레이아웃을 어뎁터에 추가
        pagerAdapter.Fragmentadd(Home_Left())
        pagerAdapter.Fragmentadd(home_middle_recipe())
        pagerAdapter.Fragmentadd(Home_Right())

        //어뎁터를 홈페이저의 어뎁터에 복사
        home_pager.adapter=pagerAdapter
        home_pager.setCurrentItem(1, false)
        home_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("Log","페이저 성공")
                Log.e("ViewPagerFragment","Page ${position+1}")
            }

        })
    }
}