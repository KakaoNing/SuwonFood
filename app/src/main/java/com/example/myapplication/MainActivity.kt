package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myapplication.Home.home_left
import com.example.myapplication.Home.home_middle
import com.example.myapplication.Home.home_right
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_main_layout.*
import kotlinx.android.synthetic.main.fragment_home_middle.*
import kotlinx.android.synthetic.main.base_main_layout.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    //네비게이션뷰 변수 설정
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //네비게이션 설정(28~35)
        //activity_main에 navigationView설정
        navigationView=findViewById(R.id.navigationView)

        //main_frame의 화면을 home_viewpager로 설정(home_viewpager는 프래그먼트)
        //supportFragmentManager.beginTransaction().replace(R.id.main_frame, home_viewpager()).commit()

        //네비게이션뷰 클릭시 자동 닫히는 함수
        navigationView.setNavigationItemSelectedListener(this)

        //툴바 설정 38~45
        //toolbar초기화
        setSupportActionBar(findViewById(R.id.toolbar))

        //뒤로가기 버튼
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //네비게이션 띄우는 인디케이터 튤바에 생성
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_toolbar_list_50dp)

        supportActionBar!!.setDisplayShowTitleEnabled(false)


        //커뮤니티 버튼 클릭 이동
        home_community.setOnClickListener {
            var intent = Intent(this, CommunityActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        home_recipe.setOnClickListener {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        home_theme.setOnClickListener {
            var intent = Intent(this, ThemeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        initpager()

    fun initpager(){
        //pagerAdapter의 초기화 설정(PagerFragmentStateAdapter사용)
        val pagerAdapter= PagerFragmentStateAdapter(this)


    }

        initpager()

    }


    fun initpager(){
        //pagerAdapter의 초기화 설정(PagerFragmentStateAdapter사용)
        val pagerAdapter= PagerFragmentStateAdapter(this)

        //pagerAdapter어뎁터에 홈화면 프래그먼트 3개를 추가
        pagerAdapter.Fragmentadd(home_left())
        pagerAdapter.Fragmentadd(home_middle())
        pagerAdapter.Fragmentadd(home_right())

        //어뎁터를 홈페이저의 어뎁터에 복사
        home_pager.adapter=pagerAdapter

        //페이저 어뎁터 맨 처음 화면을 중간에 있는 home_middle()로 설정
        home_pager.setCurrentItem(1, false)
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
            //R.id.navi_recipe -> fragmentManager.replace(R.id.main_frame, home_middle()).commit()
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

