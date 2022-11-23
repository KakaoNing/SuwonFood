package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import android.widget.TextView

import android.widget.ImageView


class DetailActivity : AppCompatActivity() {
    var selectedRecipe: Recipe? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getSelectedRecipe() // 선택한 레시피 가져오기
        setValues() // 가져온 정보 화면에 보여주기
    }

    private fun setValues() {
        val tv = findViewById<TextView>(R.id.recipe_detail_name)
        val iv = findViewById<ImageView>(R.id.recipe_detail_image)
        tv.text = selectedRecipe!!.name
        iv.setImageResource(selectedRecipe!!.image)
    }

    private fun getSelectedRecipe() {
        val intent = intent
        val id = intent.getStringExtra("id")
        selectedRecipe = RecipeActivity2.recipeList[Integer.valueOf(id)]
    }
}