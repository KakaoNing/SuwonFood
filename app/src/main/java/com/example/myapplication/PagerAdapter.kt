package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

//메인화면 어뎁터
class HomePagerAdapter(fragment: MainActivity) : FragmentStateAdapter(fragment) {
    var fragments = listOf<Fragment>()

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment {
        return fragments.get(position)
    }
}
//네비게이션바 어뎁터
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
//레시피 어뎁터
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

//냉장고 재료 어뎁터
class RecyclerRecipeSourceAdapter(private val items_source: ArrayList<refrigerator_recycle_data>) : RecyclerView.Adapter<RecyclerRecipeSourceAdapter.CustomViewHolder>() {

        override fun getItemCount(): Int = items_source.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerRecipeSourceAdapter.CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.ic_regrigerator_item, parent, false)
            return CustomViewHolder(view).apply {
                itemView.setOnClickListener {
                    val curPos: Int = adapterPosition
                    val profile: refrigerator_recycle_data = items_source.get(curPos)
                }
            }
        }


        override fun onBindViewHolder(
            holder: RecyclerRecipeSourceAdapter.CustomViewHolder, position: Int) {
            holder.title.text = items_source.get(position).name
            holder.context.text=items_source.get(position).context
        }

        inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val title = itemView.findViewById<TextView>(R.id.item_regierator_material_content)
            val context=itemView.findViewById<TextView>(R.id.item_regierator_material_content)
        }
    }
class cookbook_RecyclerRecipeCookwareAdapter(private val items_cookware: ArrayList<cookbook_image_data>) : RecyclerView.Adapter<cookbook_RecyclerRecipeCookwareAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int = items_cookware.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cookbook_RecyclerRecipeCookwareAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cookbook_create_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: cookbook_image_data = items_cookware.get(curPos)
            }
        }
    }
    override fun onBindViewHolder(holder: cookbook_RecyclerRecipeCookwareAdapter.CustomViewHolder, position: Int) {
        holder.name.text = items_cookware.get(position).image
    }
    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.recycle_recipe_cookware_data)
    }
}