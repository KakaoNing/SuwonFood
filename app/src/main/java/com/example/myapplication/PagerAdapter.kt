package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class HomePagerAdapter(fragment: MainActivity) : FragmentStateAdapter(fragment) {
    var fragments = listOf<Fragment>()

    override fun getItemCount(): Int = fragments.size



    override fun createFragment(position: Int): Fragment {
        return fragments.get(position)
    }




}
class RecipePagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment){
    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> recipe_introduce()
            1 -> recipe_cookware()
            2 -> recipe_source()
            3 -> recipe_recipe()
            else -> recipe_done()

        }
    }

    override fun getItemCount(): Int = 5




}






