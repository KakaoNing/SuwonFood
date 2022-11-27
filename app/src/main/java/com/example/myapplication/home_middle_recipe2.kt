package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class home_middle_recipe2 : Fragment() {
    private lateinit var homerecipe: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        //레시피 추천화면을 frag_home_middle_recipe 로 설정
        return inflater.inflate(R.layout.fragment_home_middle_recipe2, container, false)




    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        //아이디부여
        homerecipe = view.findViewById(R.id.home_middle_button)

        //클릭시 레시피 화면으로  이동
        homerecipe.setOnClickListener {
            //RecipeActivity::class.java로 화면전환(intent 사용)
            var intent = Intent(context, RecipeActivity::class.java)
            startActivity(intent)

        }

    }
}