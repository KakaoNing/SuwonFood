package com.example.myapplication.Other

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Home.home_left
//import com.example.myapplication.Home.Home_Left
//import com.example.myapplication.Home.Home_Right
import com.example.myapplication.Home.home_middle
import com.example.myapplication.Home.home_right
//import com.example.myapplication.Home.home_middle_recipe
import com.example.myapplication.PagerFragmentStateAdapter
import com.example.myapplication.R

import kotlinx.android.synthetic.main.base_main_layout.*


//홈 뷰페이저 Fragment이다.
class home_viewpager : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_navi_check_viewpager, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //pagerAdapter의 초기화 설정(PagerFragmentStateAdapter사용)
        val pagerAdapter= PagerFragmentStateAdapter(requireActivity())

        //pagerAdapter어뎁터에 홈화면 프래그먼트 3개를 추가
        pagerAdapter.Fragmentadd(home_left())
        pagerAdapter.Fragmentadd(home_middle())
        pagerAdapter.Fragmentadd(home_right())

        //어뎁터를 홈페이저의 어뎁터에 복사
        home_pager.adapter=pagerAdapter

        //페이저 어뎁터 맨 처음 화면을 중간에 있는 home_middle()로 설정
        home_pager.setCurrentItem(1, false)

    }
}