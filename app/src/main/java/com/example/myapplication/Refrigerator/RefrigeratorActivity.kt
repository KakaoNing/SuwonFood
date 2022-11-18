package com.example.myapplication.Refrigerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.Other.RecyclerRecipeSourceAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.Other.refrigerator_recycle_data
import kotlinx.android.synthetic.main.fragment_home_left_refrigerator.*

class RefrigeratorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_refrigerator)

        val items  = arrayListOf(
            refrigerator_recycle_data("제목이들어감","내용이들어감")
        )

        refigerator_vlist1.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        refigerator_vlist1.setHasFixedSize(true)
        refigerator_vlist1.adapter = RecyclerRecipeSourceAdapter(items)

        refigerator_vlist2.layoutManager=
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        refigerator_vlist2.setHasFixedSize(true)
        refigerator_vlist2.adapter= RecyclerRecipeSourceAdapter(items)

    }
}