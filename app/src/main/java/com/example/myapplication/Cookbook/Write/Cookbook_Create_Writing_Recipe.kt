package com.example.myapplication.Cookbook.Write

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCookbookCreateWritingRecipeBinding

class Cookbook_Create_Writing_Recipe : AppCompatActivity() {
    lateinit var binding:ActivityCookbookCreateWritingRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCookbookCreateWritingRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cookbookCreateFinishedButton.setOnClickListener {
            var intent = Intent(this, Cookbook_Create_Finished_Storage::class.java)
            startActivity(intent)
        }
    }
}