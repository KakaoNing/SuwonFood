package com.example.myapplication.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Cookbook.Write.Cookbook_Create_Cooking_Utensils
import com.example.myapplication.Cookbook.Write.Cookbook_Create_Material
import com.example.myapplication.Other.Home_Middle_ViewPager2adapter
import com.example.myapplication.R
import com.example.myapplication.Recipe.RecipeActivity
import kotlinx.android.synthetic.main.base_main_layout.*
import kotlinx.android.synthetic.main.fragment_home_middle_recipe.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class home_middle_recipe : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    init{
        instance = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    companion object {
        private var instance: home_middle_recipe? = null
        fun getInstance(): home_middle_recipe?{
            return instance
        }

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            home_middle_recipe().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_middle_recipe,container,false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //어뎁터 선언
        val pagerAdapter= Home_Middle_ViewPager2adapter(requireActivity())

        //버튼 레이아웃을 어뎁터에 추가
        pagerAdapter.addFragment(Home_Middle_Button())
        pagerAdapter.addFragment(Home_Middle_Button())
        pagerAdapter.addFragment(Home_Middle_Button())

        //어뎁터를 홈페이저의 어뎁터에 복사
        home_recipe_viewpager2.adapter=pagerAdapter
        home_recipe_viewpager2.setCurrentItem(1, false)
        home_recipe_viewpager2.orientation=ViewPager2.ORIENTATION_VERTICAL
        home_recipe_viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("Log","페이저 성공")
                Log.e("ViewPagerFragment","Page ${position+1}")
            }

        })
    }
}