package com.example.myapplication.Home

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.Other.RecyclerRecipeSourceAdapter
import com.example.myapplication.databinding.DialogRefrigeratorAddMaterialBinding
import com.example.myapplication.Other.refrigerator_recycle_data
import kotlinx.android.synthetic.main.fragment_home_left_refrigerator.*

class Home_Left : DialogFragment() {


    val refrigerator_Data_Array:ArrayList<refrigerator_recycle_data> = java.util.ArrayList()
    lateinit var refrigerator_recyclerViewGroup1:RecyclerView
    lateinit var refrigerator_recyclerViewGroup2:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView=inflater.inflate(R.layout.fragment_home_left_refrigerator,container,false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items  = arrayListOf(
            refrigerator_recycle_data("제목이들어감","내용이들어감"),
            refrigerator_recycle_data("제목이들어감","내용이들어감"),
            refrigerator_recycle_data("제목이들어감","내용이들어감"),
            refrigerator_recycle_data("제목이들어감","내용이들어감"),
            refrigerator_recycle_data("제목이들어감","내용이들어감"),
            refrigerator_recycle_data("제목이들어감","내용이들어감"),
            refrigerator_recycle_data("제목이들어감","내용이들어감"),
            refrigerator_recycle_data("제목이들어감","내용이들어감"),
            refrigerator_recycle_data("제목이들어감","내용이들어감"),
            refrigerator_recycle_data("제목이들어감","내용이들어감"),
            refrigerator_recycle_data("제목이들어감","내용이들어감")
        )
        refigerator_vlist1.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        refigerator_vlist1.setHasFixedSize(true)
        refigerator_vlist1.adapter = RecyclerRecipeSourceAdapter(items)

        refigerator_vlist2.layoutManager=
            LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        refigerator_vlist2.setHasFixedSize(true)
        refigerator_vlist2.adapter= RecyclerRecipeSourceAdapter(items)

        val dialogBinding=DialogRefrigeratorAddMaterialBinding.inflate(layoutInflater)
        item_regierator_addbutton.setOnClickListener {
            Log.d("Log","다이얼로그성공")
            val builder=AlertDialog.Builder(context)
            builder.setTitle("재료 추가")
            builder.setView(dialogBinding.root)
        }
    }
}