package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCookbookCreateBinding
import kotlinx.android.synthetic.main.activity_main.*

class Cookbook_Create_Activity : AppCompatActivity() {
    lateinit var binding:ActivityCookbookCreateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCookbookCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initfragment()
        binding.cookbookCreateNextbutton.setOnClickListener {
            var intent = Intent(this,Cookbook_create_writing_recipe::class.java)
            startActivity(intent)
        }
    }
    private fun initfragment(){
        supportFragmentManager.beginTransaction().replace(R.id.cookbook_Create_cooking_utensils_fragment,cookbook_create_cooking_utensils()).commit()
        supportFragmentManager.beginTransaction().replace(R.id.cookbook_Create_cooking_Material_fragment,cookbook_create_Material()).commit()
    }
}