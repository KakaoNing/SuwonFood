package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_recipe_cookware.*
import kotlinx.android.synthetic.main.fragment_recipe_source.*
//
class recipe_cookware : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_cookware, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val items = arrayListOf(
            recipe_cookware_recycle_data("후라이팬"),
            recipe_cookware_recycle_data("뒤집개"),
            recipe_cookware_recycle_data("믹싱볼")



        )

        opt_recycle_recipe_cookware.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        opt_recycle_recipe_cookware.setHasFixedSize(true)
        opt_recycle_recipe_cookware.adapter = RecyclerRecipeCookwareAdapter(items)
    }


}