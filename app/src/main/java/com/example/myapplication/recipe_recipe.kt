package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_recipe_recipe.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [recipe_recipe.newInstance] factory method to
 * create an instance of this fragment.
 */
class recipe_recipe : Fragment() {
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




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_recipe, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            recipe_recipe().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}