package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_recipe_cookware.*
import kotlinx.android.synthetic.main.fragment_recipe_done.*

class recipe_done : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_done, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //이미지 추가 하는곳
        val items = arrayListOf(
            recipe_done_image_recycle_data(R.drawable.cook_ex1_base_img),
            recipe_done_image_recycle_data(R.drawable.cook_ex1_base_img),
            recipe_done_image_recycle_data(R.drawable.cook_ex1_base_img),
            recipe_done_image_recycle_data(R.drawable.cook_ex1_base_img)
        )

        opt_recycle_recipe_done_image.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        opt_recycle_recipe_done_image.setHasFixedSize(true)
        opt_recycle_recipe_done_image.adapter = RecyclerRecipeDoneImageAdapter(items)
    }
}