package com.example.myapplication.Cookbook.Write

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityCookbookCreateBinding

class Cookbook_Create_Activity : AppCompatActivity() {
    lateinit var binding:ActivityCookbookCreateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCookbookCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //scroll연결
        supportFragmentManager.beginTransaction().replace(
            R.id.cookbook_Create_cooking_scroll,
            Cookbook_Create_Scroll()

        ).commit()
        initfragment()
    }
    private fun initfragment(){
        supportFragmentManager.beginTransaction().replace(
            R.id.cookbook_Create_cooking_Material_fragment,
            Cookbook_Create_Material()
        ).commit()
    }
}