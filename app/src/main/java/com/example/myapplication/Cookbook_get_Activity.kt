package com.example.myapplication.Cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.*
//import com.example.myapplication.Other.RecipeGetGoodAdapter
//import kotlinx.android.synthetic.main.activity_cookbook_import.*
import kotlinx.android.synthetic.main.cookbook_get.*
//import kotlinx.android.synthetic.main.ic_create_goodimport_item.*

//레시피 가져오기 Activity

class Cookbook_get_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cookbook_get)

        //20~33줄은 좋아하는 레시피를 가져오는 리사이클러뷰에 대한 설정이다.
        //리사이클러뷰 리스트에 정보를 good_recycler_list에 저장
        var good_recycler_list = arrayListOf("Test 1", "Test 2", "Test 3", "Test 4")

        //리사이클러뷰 형태를 good_recycler_manager에 저장 여기서 HORIZONTAL는 가로방향 설정이다.
        var good_recycler_manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //리사이클러뷰의 어뎁터에 good_recycler_list를 연결
        var good_recycler_adapter = CookBookGetFavoriteAdapter(good_recycler_list)

        //어뎁터와 good_recycler_manager를 작동시킨다. cookbook_import_recent_recyclerview이 리사이클러뷰이다.
        var good_recycler_RecyclerView = cookbook_import_recent_recyclerview.apply {
            adapter = good_recycler_adapter
            layoutManager = good_recycler_manager
        }

        //추천 레시피를 가져오는 리사이클러뷰에 대한 설정이다.
        //리사이클러뷰 리스트에 정보를 recommend_recycler_list에 저장
        var recommend_recycler_list = arrayListOf("Test 1", "Test 2", "Test 3", "Test 4")

        //리사이클러뷰 형태를 recommend_recycler_manager에 저장 여기서 HORIZONTAL는 가로방향 설정이다.
        var recommend_recycler_manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //리사이클러뷰의 어뎁터에 recommend_recycler_list를 연결
        var recommend_recycler_adapter = CookBookGetRecommandAdapter(recommend_recycler_list)

        //어뎁터와 recommend_recycler_manager를 작동시킨다. cookbook_import_recommendation_recyclerview이 리사이클러뷰이다.
        var recommend_recycler_RecyclerView = cookbook_import_recommendation_recyclerview.apply {
            adapter = recommend_recycler_adapter
            layoutManager = recommend_recycler_manager
        }

    }
}