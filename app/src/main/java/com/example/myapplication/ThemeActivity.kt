package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_recipe.*
import kotlinx.android.synthetic.main.activity_theme.*
import kotlinx.android.synthetic.main.cookbook_management.*
import kotlinx.android.synthetic.main.cookbook_management.view.*

class ThemeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)


        theme_button_recipe.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        theme_button_community.setOnClickListener {
            var intent = Intent(this, CommunityActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        theme_button_theme.setOnClickListener {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }



        //툴바 설정 38~45
        //toolbar초기화
        setSupportActionBar(findViewById(R.id.toolbar))

        //뒤로가기 버튼
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_toolbar_list_50dp)

        supportActionBar!!.setDisplayShowTitleEnabled(false)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                recipe_main.openDrawer(GravityCompat.START)
            }
            R.id.tool_search->{
                var intent = Intent(this,SearchActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}