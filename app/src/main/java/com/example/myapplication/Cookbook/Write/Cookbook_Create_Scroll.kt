package com.example.myapplication.Cookbook.Write

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
class Cookbook_Create_Scroll : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cookbook__create_scroll, container, false)
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        supportFragmentManager.beginTransaction().replace(
            R.id.cookbook_Create_cooking_Material_fragment,
            Cookbook_Create_Material()
        ).commit()
    }*/
}