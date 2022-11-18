package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.base_search_layout.*
import kotlinx.android.synthetic.main.community_notice_free.*

class SearchActivity : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)




        opt_search_recipe.setOnQueryTextListener(searchViewTextListener)



        val items  = arrayListOf(
            search_recycle_data(R.drawable.comunity_free_notice,"제목","정보"),
            search_recycle_data(R.drawable.comunity_free_notice,"제목1","정보"),
            search_recycle_data(R.drawable.comunity_free_notice,"제목2","정보"),
            search_recycle_data(R.drawable.comunity_free_notice,"제목3","정보"),
            search_recycle_data(R.drawable.comunity_free_notice,"제목4","정보"),
            search_recycle_data(R.drawable.comunity_free_notice,"제목5","정보"),
        )

        opt_recycle_search.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        opt_recycle_search.setHasFixedSize(true)
        opt_recycle_search.adapter = RecyclerSearchAdapter(items)

    }


    var searchViewTextListener: SearchView.OnQueryTextListener =
        object : SearchView.OnQueryTextListener {
            //검색버튼 입력시 호출, 검색버튼이 없으므로 사용하지 않음
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        }



}