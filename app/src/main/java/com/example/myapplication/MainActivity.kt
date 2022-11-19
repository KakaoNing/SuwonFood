package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myapplication.Home.home_middle
import com.example.myapplication.Other.home_viewpager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_main_layout.*
import kotlinx.android.synthetic.main.fragment_home_middle.*
import kotlinx.android.synthetic.main.base_main_layout.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //네비게이션 설정
        navigationView=findViewById(R.id.navigationView)
        supportFragmentManager.beginTransaction().replace(R.id.main_frame, home_viewpager()).commit()
        navigationView.setNavigationItemSelectedListener(this)

        //툴바 설정
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_format_list_bulleted_24)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        //커뮤니티 버튼 클릭 이동
        home_community.setOnClickListener {
            var intent = Intent(this, CommunityActivity::class.java)
            startActivity(intent)
        }







    }

    //드로어블
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                home_main.openDrawer(GravityCompat.START)

            }
            R.id.tool_search->{
                var intent = Intent(this,SearchActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    //네비게이션 클릭 이벤트
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmentManager=supportFragmentManager.beginTransaction()
        Log.d("Log","목록터치")
        //클릭시 frame을 해당 프래그먼트로 바꿈
        when(item.itemId) {
            //R.id.navi_refrigerator -> fragmentManager.replace(R.id.main_frame, home_left()).commit()
            //R.id.navi_cookBook -> fragmentManager.replace(R.id.main_frame, home_right()).commit()
            R.id.navi_recipe -> fragmentManager.replace(R.id.main_frame, home_middle()).commit()
        }
        home_main.closeDrawers()
        return false
    }
    //툴바
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }
}
