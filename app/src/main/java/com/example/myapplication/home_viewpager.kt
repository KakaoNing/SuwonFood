package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.base_main_layout.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class home_viewpager : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
        val pagerAdapter=PagerFragmentStateAdapter(requireActivity())

        //메인화면 레이아웃을 어뎁터에 추가
        pagerAdapter.Fragmentadd(home_left_refrigerator())
        pagerAdapter.Fragmentadd(home_middle_recipe())
        pagerAdapter.Fragmentadd(home_right_cookbook())

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