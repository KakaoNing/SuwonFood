package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.ActivityRecipeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recipe.*
import kotlinx.android.synthetic.main.base_recipe_layout.*
import kotlinx.android.synthetic.main.base_main_layout.*
import kotlinx.android.synthetic.main.base_recipe_layout.*

class RecipeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recipe_button_theme.setOnClickListener{
            var intent = Intent(this, ThemeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }



        recipe_button_recipe.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        recipe_button_community.setOnClickListener{
            var intent = Intent(this, CommunityActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }


        //툴바
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_toolbar_list_50dp)
        supportActionBar!!.setDisplayShowTitleEnabled(false)


        //탭 설정
        recipe_tab.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) { // 이미 선택된 탭 다시 되었을때

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {  // 탭 선택되었을때
                tab?.position?.let{recipe_pager.setCurrentItem(it,false)}

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { // 탭 선택 안된상태로 변경 되었을때

            }
        })





        recipe_pager.adapter = RecipePagerAdapter(this)

        recipe_pager.run{
            isUserInputEnabled= false
        }

        TabLayoutMediator(recipe_tab,recipe_pager) {tab,position ->
            when(position){
                0 -> tab.text = "소개"
                1 -> tab.text = "조리도구"
                2 -> tab.text = "재료"
                3 -> tab.text = "레시피"
                4 -> tab.text = "완성"
            }
        }.attach()

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                recipe_main.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }
}