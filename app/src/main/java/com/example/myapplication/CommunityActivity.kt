package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_communuity.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_community_layout.*

class CommunityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communuity)
        //툴바 설정
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_format_list_bulleted_24)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        //버튼 클릭 이벤트
        community_button_cook.setOnClickListener {
            var intent = Intent(this,Community_notice_cook_Activity::class.java)
            startActivity(intent)
        }

        community_button_qna.setOnClickListener {
            var intent = Intent(this,Community_notice_qna_Activity::class.java)
            startActivity(intent)
        }

        community_button_free.setOnClickListener {
            var intent = Intent(this,Community_notice_free_Activity::class.java)
            startActivity(intent)
        }

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                community_main.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }
}