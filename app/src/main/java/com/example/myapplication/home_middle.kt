package com.example.myapplication.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.viewpager2.widget.ViewPager2
//import com.example.myapplication.Cookbook.Write.Cookbook_Create_Cooking_Utensils
//import com.example.myapplication.Cookbook.Write.Cookbook_Create_Material
import com.example.myapplication.Home_Middle_ViewPager2adapter
//import com.example.myapplication.Other.Home_Middle_ViewPager2adapter
import com.example.myapplication.R
import com.example.myapplication.home_middle_recipe2
import com.example.myapplication.home_middle_recipe3
//import com.example.myapplication.Recipe.RecipeActivity
import kotlinx.android.synthetic.main.base_main_layout.*
import kotlinx.android.synthetic.main.fragment_home_middle.*
import kotlinx.android.synthetic.main.fragment_home_middle_recipe.*
// 홈 화면중 가운데에 해당하는 추천화면에 대한 Fragment이다.
class home_middle : Fragment() {


    /*
    //인스턴스 초기화
    init{
        instance = this
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    /*companion object {
        private var instance: home_middle? = null
        fun getInstance(): home_middle?{
            //인스턴스 리턴
            return instance
        }
    }*/


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home_middle,container,false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        //pagerAdapter어뎁터 선언(Home_Middle_ViewPager2adapter)
        val pagerAdapter= Home_Middle_ViewPager2adapter(requireActivity())

        //pagerAdapter어뎁터에 레시피 프래그먼트를 추가
        pagerAdapter.addFragment(Home_Middle_Recipe())
        pagerAdapter.addFragment(home_middle_recipe2())
        pagerAdapter.addFragment(home_middle_recipe3())


        //어뎁터를 홈페이저의 어뎁터에 복사
        home_recipe_viewpager2.adapter=pagerAdapter

        //처음 뷰페이저2 화면 설정(0= 맨위)
        home_recipe_viewpager2.setCurrentItem(0, false)

        //뷰페이저2 방향 설정 ORIENTATION_VERTICAL=세로방향
        home_recipe_viewpager2.orientation=ViewPager2.ORIENTATION_VERTICAL

    }
}