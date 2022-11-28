package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.viewpager2.widget.ViewPager2

import com.example.myapplication.databinding.CookbookManagementBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cookbook_management.*

//레시피 관리에 대한 Activity이다.

class Cookbook_Management_Activity : AppCompatActivity() {
    lateinit var binding: CookbookManagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //cookbook_management의 Binding을 연결
        binding=CookbookManagementBinding.inflate(layoutInflater)


        setContentView(binding.root)

        //뷰페이저2를 연결시키는 함수를 실행
        initViewPager()


        cookbook_management_button_recipe.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        cookbook_management_button_community.setOnClickListener {
            var intent = Intent(this, CommunityActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        cookbook_management_button_theme.setOnClickListener {
            var intent = Intent(this, ThemeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }


    }

    //뷰페이저2를 연결시키는 함수이다.
    private fun initViewPager(){
        //ViewPager2 Adapter 셋팅 32줄~37줄
        //viewPager2Adapter의 초기화 설정
        var viewPagerWriteAdapter= CookBookManagementWriteAdapter(this)
        var viewPagerBringAdapter= CookBookManagementBringAdapter(this)

        //viewPager2Adapter에 프래그먼트를 추가시킨다.
        viewPagerWriteAdapter.addFragment(Cookbook_Management_write1())
        viewPagerWriteAdapter.addFragment(Cookbook_Management_write2())
        viewPagerBringAdapter.addFragment(Cookbook_Management_bring1())
        viewPagerBringAdapter.addFragment(Cookbook_Management_bring2())

        //Adapter 연결
        //cookbookManagementViewpagerMain이라는 뷰페이저2에 어뎁터를 연결 후 실행이다.
        binding.cookbookManagementViewpagerWrite.apply{
            //어뎁터에 viewPager2Adapter를 연결
            adapter=viewPagerWriteAdapter

            //실행시키는 함수이다.
            registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        binding.cookbookManagementViewpagerBring.apply{
            //어뎁터에 viewPager2Adapter를 연결
            adapter=viewPagerBringAdapter

            //실행시키는 함수이다.
            registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }
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

}