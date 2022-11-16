package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_main_layout.*
import kotlinx.android.synthetic.main.fragment_home_middle.*
import kotlinx.android.synthetic.main.base_main_layout.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //툴바 설정
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_format_list_bulleted_24)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        //뷰페이저
        val fragmentList = listOf(home_left(), home_frag_middle(), home_right())
        val adapter = HomePagerAdapter(this)
        adapter.fragments = fragmentList
        home_pager.adapter = adapter
        home_pager.setCurrentItem(1, false)


        //커뮤니티 버튼 클릭 이동
        home_community.setOnClickListener {
            var intent = Intent(this,CommunityActivity::class.java)
            startActivity(intent)
        }
        home_rec.setOnClickListener {
            var intent = Intent(this,RecipeActivity2::class.java)
            startActivity(intent)
        }
        



    }

    //드로어블
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
            home_main.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //툴바
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }






}

