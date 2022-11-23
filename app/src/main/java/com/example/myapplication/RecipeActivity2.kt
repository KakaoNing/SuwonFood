package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.AdapterView.OnItemClickListener

import android.content.Intent
import android.widget.ListView
import android.widget.SearchView

import java.util.*

class RecipeActivity2 : AppCompatActivity() {
    var listView: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe2)
        //searchRecipe()
        setUpData() //CE
        setUpList() //
        setUpOnClickListener() //상세페이지 이벤트
    }

    private fun searchRecipe() {
        val searchView = findViewById<SearchView>(R.id.recipe_search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                val filterRecipe = ArrayList<Recipe?>()
                for (i in recipeList.indices) {
                    val recipe = recipeList[i]
                    //데이터와 비교해서 내가 쓴 레시피 이름이 있다면
                    if (recipe != null) {
                        if (recipe.name.lowercase(Locale.getDefault())
                                .contains(newText.lowercase(Locale.getDefault()))
                        ) {
                            filterRecipe.add(recipe)
                        }
                    }
                }
                val adapter = RecipeAdapter(applicationContext, 0, filterRecipe)
                listView!!.adapter = adapter
                return false
            }
        })
    }

    /**
     * 데이터 셋팅
     */
    private fun setUpData() {
        val a = Recipe("0", "갈비찜", R.drawable.a)
        recipeList.add(a)
        val b = Recipe("1", "김치찌개", R.drawable.b)
        recipeList.add(b)
        val c = Recipe("2", "단호박소고기롤", R.drawable.c)
        recipeList.add(c)
        val d = Recipe("3", "닭강정", R.drawable.d)
        recipeList.add(d)
        val e = Recipe("4", "두부김치", R.drawable.e)
        recipeList.add(e)
        val f = Recipe("5", "삼계탕", R.drawable.f)
        recipeList.add(f)
        val g = Recipe("6", "잔치국수", R.drawable.g)
        recipeList.add(g)
        val h = Recipe("7", "짜장면", R.drawable.h)
        recipeList.add(h)
        val i = Recipe("8", "오뎅탕", R.drawable.i)
        recipeList.add(i)
        val j = Recipe("9", "쭈꾸미볶음", R.drawable.j)
        recipeList.add(j)
    }

    private fun setUpList() {
        listView = findViewById(R.id.recipe_listView)
        val adapter = RecipeAdapter(applicationContext, 0, recipeList)
        listView?.setAdapter(adapter)
    }

    private fun setUpOnClickListener() {
        listView!!.onItemClickListener = OnItemClickListener { adapterView, view, position, I ->
            val selectRecipe = listView!!.getItemAtPosition(position) as Recipe
            val showDetail = Intent(applicationContext, DetailActivity::class.java)
            showDetail.putExtra("name", selectRecipe.name)
            startActivity(showDetail)
        }
    }

    companion object {
        var recipeList = ArrayList<Recipe?>()
    }
}