package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_recipe_cookware.*
import kotlinx.android.synthetic.main.fragment_recipe_source.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [recipe_cookware.newInstance] factory method to
 * create an instance of this fragment.
 */
class recipe_cookware : Fragment() {
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
        return inflater.inflate(R.layout.fragment_recipe_cookware, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = arrayListOf(
            cookware_recycle_list_data("조리도구")
        )

        opt_recycle_recipe_cookware.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        opt_recycle_recipe_cookware.setHasFixedSize(true)
        opt_recycle_recipe_cookware.adapter = RecyclerRecipeCookwareAdapter(items)
    }






    companion object {
        fun newInstance(param1: String, param2: String) =
            recipe_cookware().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}