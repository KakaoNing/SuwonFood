package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class home_right_cookbook : Fragment() {
    private lateinit var cookbook_create: Button
    private lateinit var cookbook_import: Button
    private lateinit var cookbook_management: Button
    private lateinit var cookbook_cookingtimemanagement: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_right_cookbook, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //레시피 작성 버튼
        cookbook_create = view.findViewById(R.id.cookbook_button_Create)

        cookbook_create.setOnClickListener {
            var intent = Intent(context,Cookbook_Create_Activity::class.java)
            startActivity(intent)
        }

        //레시피 가져오기 버튼
        cookbook_import = view.findViewById(R.id.cookbook_button_Import)

        cookbook_import.setOnClickListener {
            var intent = Intent(context,Cookbook_Import_Activity::class.java)
            startActivity(intent)
        }

        //레시피관리 버튼
        cookbook_management = view.findViewById(R.id.cookbook_button_Management)

        cookbook_management.setOnClickListener {
            var intent = Intent(context,Cookbook_Management_Activity::class.java)
            startActivity(intent)
        }

        //요리타임관리 버튼
        cookbook_cookingtimemanagement = view.findViewById(R.id.cookbook_button_CookingtimeManagement)

        cookbook_cookingtimemanagement.setOnClickListener {
            var intent = Intent(context,Cookbook_CookingtimeManagement_Activity::class.java)
            startActivity(intent)
        }

    }
}