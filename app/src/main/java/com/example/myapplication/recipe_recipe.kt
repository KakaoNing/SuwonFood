package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_recipe_recipe.*
class recipe_recipe : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentList = listOf(recipe_recipe_viewpager1(),recipe_recipe_viewpager2())
        val adapter = FragRecipeAdapter(this)
        val current = frag_recipe_recipe_pager.currentItem
        adapter.fragment = fragmentList
        frag_recipe_recipe_pager.adapter =adapter
        frag_recipe_recipe_pager.setCurrentItem(0,false)

        frag_recipe_recipe_pager.run {
            isUserInputEnabled = false
        }

        opt_recipe_button_left.setOnClickListener {
            frag_recipe_recipe_pager.setCurrentItem(current-1,true)
        }
        opt_recipe_button_right.setOnClickListener {
            frag_recipe_recipe_pager.setCurrentItem(current+1,true)
        }


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_recipe, container, false)
    }
}