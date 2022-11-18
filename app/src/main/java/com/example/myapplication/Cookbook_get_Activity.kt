package com.example.myapplication.Cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.*
//import com.example.myapplication.Other.RecipeGetGoodAdapter
//import kotlinx.android.synthetic.main.activity_cookbook_import.*
import kotlinx.android.synthetic.main.cookbook_get.*
//import kotlinx.android.synthetic.main.ic_create_goodimport_item.*

class Cookbook_get_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cookbook_get)

        var good_recycler_list = arrayListOf("Test 1", "Test 2", "Test 3", "Test 4")
        var good_recycler_manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var good_recycler_adapter = CookBookGetFavoriteAdapter(good_recycler_list)

        var good_recycler_RecyclerView = cookbook_import_recent_recyclerview.apply {
            adapter = good_recycler_adapter
            layoutManager = good_recycler_manager
        }

        var recommend_recycler_list = arrayListOf("Test 1", "Test 2", "Test 3", "Test 4")
        var recommend_recycler_manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var recommend_recycler_adapter = CookBookGetRecommandAdapter(recommend_recycler_list)

        var recommend_recycler_RecyclerView = cookbook_import_recommendation_recyclerview.apply {
            adapter = recommend_recycler_adapter
            layoutManager = recommend_recycler_manager
        }

        //리사이클러뷰 어댑터로 수정할예정
    }
}