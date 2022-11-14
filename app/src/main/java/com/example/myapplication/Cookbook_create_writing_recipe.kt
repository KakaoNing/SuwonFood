package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCookbookCreateBinding
import com.example.myapplication.databinding.ActivityCookbookCreateWritingRecipeBinding

class Cookbook_create_writing_recipe : AppCompatActivity() {
    lateinit var binding:ActivityCookbookCreateWritingRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCookbookCreateWritingRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cookbookCreateFinishedButton.setOnClickListener {
            var intent = Intent(this,Cookbook_Create_finished_Storage::class.java)
            startActivity(intent)
        }
    }
}