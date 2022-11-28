package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.community_notice_cook.*
import kotlinx.android.synthetic.main.fragment_recipe_source.*

class recipe_source : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val items = arrayListOf(
            recipe_source_recycle_data("날계란","5개"),
            recipe_source_recycle_data("대파","조금"),
            recipe_source_recycle_data("당근","조금"),
            recipe_source_recycle_data("식용유","조금")

        )

        opt_recycle_recipe_source.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        opt_recycle_recipe_source.setHasFixedSize(true)
        opt_recycle_recipe_source.adapter = RecyclerRecipeSourceAdapter(items)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_source, container, false)
    }

}