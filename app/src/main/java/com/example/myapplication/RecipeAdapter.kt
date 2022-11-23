package com.example.myapplication

import android.content.Context
import com.example.myapplication.Recipe
import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.myapplication.R
import android.widget.TextView

class RecipeAdapter(context: Context?, resource: Int, recipeList: List<Recipe?>?) :
    ArrayAdapter<Recipe?>(
        context!!, resource, recipeList!!
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val recipe = getItem(position)
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.recipe_item, parent, false)
        }
        val tv = convertView!!.findViewById<TextView>(R.id.recipe_name)
        val iv = convertView.findViewById<ImageView>(R.id.recipe_image)
        tv.text = recipe!!.name
        iv.setImageResource(recipe.image)
        return convertView
    }
}