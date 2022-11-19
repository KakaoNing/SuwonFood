package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.item_cookbook_get_favorite.view.*
import kotlinx.android.synthetic.main.item_cookbook_get_recommand.view.*

//메인화면 레시피 어댑터
class Home_Middle_ViewPager2adapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
    var fragments:ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment: Fragment){
        fragments.add(fragment)
        notifyItemInserted(fragments.size-1)

    }

    fun removeFragement(){
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }
}

//네비게이션바 어댑터
class PagerFragmentStateAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    var fragments= ArrayList<Fragment>()
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun Fragmentadd(fragment: Fragment){
        fragments.add(fragment)
        notifyItemInserted(fragments.size-1)
    }

    fun Fragmentremove(){
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }
}

class FragRecipeAdapter(fragment: recipe_recipe) : FragmentStateAdapter(fragment){
    var fragment = listOf<Fragment>()

    override fun getItemCount(): Int = fragment.size

    override fun createFragment(position: Int): Fragment {
        return fragment.get(position)
    }

}
//레시피화면 탭레이아웃 + 뷰페이저 어뎁터
class RecipePagerAdapter(fragment: RecipeActivity) : FragmentStateAdapter(fragment){


    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> recipe_introduce()
            1 -> recipe_cookware()
            2 -> recipe_source()
            3 -> recipe_recipe()
            4 -> recipe_done()


            else -> {recipe_introduce()}
        }
    }

    override fun getItemCount(): Int = 5




}

//요리책화면 레시피 관리중 뷰페이저 어댑터
class CookBookManagementAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
    var fragments:ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment: Fragment){
        fragments.add(fragment)
        notifyItemInserted(fragments.size-1)

    }

    fun removeFragement(){
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }
}

//요리책화면 커뮤니티 레시피 관리 중 뷰페이저 어댑터
class CookBookCommunityManagementAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
    var fragments:ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment: Fragment){
        fragments.add(fragment)
        notifyItemInserted(fragments.size-1)

    }

    fun removeFragement(){
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }
}





