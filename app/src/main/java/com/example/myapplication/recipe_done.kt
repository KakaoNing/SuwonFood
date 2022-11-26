package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_recipe_cookware.*
import kotlinx.android.synthetic.main.fragment_recipe_done.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [recipe_done.newInstance] factory method to
 * create an instance of this fragment.
 */
class recipe_done : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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










    companion object {
        fun newInstance(param1: String, param2: String) =
            recipe_done().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}