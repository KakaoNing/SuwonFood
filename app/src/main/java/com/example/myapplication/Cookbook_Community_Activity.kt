package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.CookbookCommunityBinding
//쿠킹타임 레시피 관리 Activity
class Cookbook_Community_Activity : AppCompatActivity() {

    //binding 변수 선언
    lateinit var binding:CookbookCommunityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding 초기화
        binding= CookbookCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //뷰페이저 초기화 함수
        initViewPager()
    }

    private fun initViewPager(){
        //ViewPager2 Adapter 셋팅
        //어뎁터변수 선언 및 초기화(CookBookCommunityManagementAdapter)
        var viewPager2Adapter= CookBookCommunityManagementAdapter(this)

        //어뎁터에 프래그먼트 추가
        viewPager2Adapter.addFragment(Cookbook_Community_viewpager1())
        viewPager2Adapter.addFragment(Cookbook_Community_viewpager2())

        //Adapter 연결
        //cookbookCookingtimeRecipeManagementViewpagerMain버튼 클릭시 동작코드
        binding.cookbookCookingtimeRecipeManagementViewpagerMain.apply{
            adapter=viewPager2Adapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }
}