package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.CookbookCommunityBinding

class Cookbook_Community_Activity : AppCompatActivity() {
    lateinit var binding:CookbookCommunityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= CookbookCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()
    }

    private fun initViewPager(){
        //ViewPager2 Adapter 셋팅
        var viewPager2Adapter= CookBookCommunityManagementAdapter(this)
        viewPager2Adapter.addFragment(Cookbook_Community_viewpager1())
        viewPager2Adapter.addFragment(Cookbook_Community_viewpager2())

        //Adapter 연결

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