package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_communuity.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_community_layout.*
import kotlinx.android.synthetic.main.fragment_recipe_cookware.*
import kotlinx.android.synthetic.main.fragment_recipe_done.*


class CommunityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communuity)



        //툴바 설정
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_toolbar_list_50dp)
        supportActionBar!!.setDisplayShowTitleEnabled(false)


        community_button_recipe.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        community_button_community.setOnClickListener {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

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


        //오늘의 레시피

        val items_recipe = arrayListOf(
            community_today_recipe(R.drawable.icon_community_user_ex_50dp,"name",R.drawable.cook_ex1_base_img,"요리이름")
        )

        opt_community_today_recipe_recycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        opt_community_today_recipe_recycle.setHasFixedSize(true)
        opt_community_today_recipe_recycle.adapter = RecyclerCommunityTodayRecipeAdapter(items_recipe)

        //오늘의 게시글

        val items_notice = arrayListOf(
            community_today_notice(R.drawable.icon_community_user_ex_50dp,"제목")
        )

        opt_community_today_notice_recycle.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        opt_community_today_notice_recycle.setHasTransientState(true)
        opt_community_today_notice_recycle.adapter = RecyclerCommunityTodayNoticeAdapter(items_notice)


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