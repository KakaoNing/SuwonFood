package com.example.myapplication.Cookbook.Write

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.Other.cookbook_RecyclerRecipeCookwareAdapter
import com.example.myapplication.Other.cookbook_image_data
import kotlinx.android.synthetic.main.fragment_cookbook__create_cookware.*

class Cookbook_Create_Cookware : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cookbook__create_cookware, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = arrayListOf(
            cookbook_image_data("조리도구")
        )
        opt_recycle_recipe_cookware.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        opt_recycle_recipe_cookware.setHasFixedSize(true)
        opt_recycle_recipe_cookware.adapter = cookbook_RecyclerRecipeCookwareAdapter(items)
    }

}