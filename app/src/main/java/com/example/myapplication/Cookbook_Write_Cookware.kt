package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.cookbook_get.*

class Cookbook_Write_Cookware : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cookbook__write__cookware, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*var cookware_recycler_list= arrayListOf("Test 1","Test 2","Test 3","Test 4")

        var cookware_recycler_manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        var cookware_recycler_adapter = RecyclerWriteCookwareAdapter(cookware_recycler_list)

        var cookware_recycler_RecyclerView = cookbook_import_recent_recyclerview.apply {
            adapter = cookware_recycler_adapter
            layoutManager = cookware_recycler_manager
        }*/}
}