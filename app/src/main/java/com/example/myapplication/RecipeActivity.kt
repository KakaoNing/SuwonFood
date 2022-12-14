package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myapplication.databinding.ActivityRecipeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_recipe.*
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


        //??????
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_toolbar_list_50dp)
        supportActionBar!!.setDisplayShowTitleEnabled(false)


        //??? ??????
        recipe_tab.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) { // ?????? ????????? ??? ?????? ????????????

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {  // ??? ??????????????????
                tab?.position?.let{recipe_pager.setCurrentItem(it,false)}

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { // ??? ?????? ??????????????? ?????? ????????????

            }
        })





        recipe_pager.adapter = RecipePagerAdapter(this)

        recipe_pager.run{
            isUserInputEnabled= false
        }

        TabLayoutMediator(recipe_tab,recipe_pager) {tab,position ->
            when(position){
                0 -> tab.text = "??????"
                1 -> tab.text = "????????????"
                2 -> tab.text = "??????"
                3 -> tab.text = "?????????"
                4 -> tab.text = "??????"
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