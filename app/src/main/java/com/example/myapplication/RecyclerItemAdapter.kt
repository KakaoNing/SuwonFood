package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerRecipeCookwareAdapter(private val items_cookware: ArrayList<cookware_recycle_list_data>) : RecyclerView.Adapter<RecyclerRecipeCookwareAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int = items_cookware.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerRecipeCookwareAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_cookware_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: cookware_recycle_list_data = items_cookware.get(curPos)
            }

        }
    }


    override fun onBindViewHolder(holder: RecyclerRecipeCookwareAdapter.CustomViewHolder, position: Int) {
        holder.name.text = items_cookware.get(position).name
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.recycle_recipe_cookware_data)

    }


}
//리사이클러 레시피 재료 어댑터
class RecyclerRecipeSourceAdapter(private val items_source: ArrayList<recipe_recycle_list_data>) : RecyclerView.Adapter<RecyclerRecipeSourceAdapter.CustomViewHolder>() {

        override fun getItemCount(): Int = items_source.size


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerRecipeSourceAdapter.CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_source_list, parent, false)
            return CustomViewHolder(view).apply {
                itemView.setOnClickListener {
                    val curPos: Int = adapterPosition
                    val profile: recipe_recycle_list_data = items_source.get(curPos)
                }

            }
        }


        override fun onBindViewHolder(holder: RecyclerRecipeSourceAdapter.CustomViewHolder, position: Int) {
            holder.name.text = items_source.get(position).name
            holder.value.text = items_source.get(position).value
        }


        inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val name = itemView.findViewById<TextView>(R.id.recycle_recipe_source_data)
            val value = itemView.findViewById<TextView>(R.id.recycle_recipe_source_value)
        }


    }

    //리사이클러 qna게시판 이미지 어댑터
class RecyclerQnaImgAdapter(private val items_qna: ArrayList<qna_recycle_letter_data>) : RecyclerView.Adapter<RecyclerQnaImgAdapter.CustomViewHolder>() {


        override fun getItemCount(): Int = items_qna.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerQnaImgAdapter.CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_qna_recycle_letter, parent, false)
            return CustomViewHolder(view).apply {
                itemView.setOnClickListener {
                    val curPos: Int = adapterPosition
                    val profile: qna_recycle_letter_data = items_qna.get(curPos)

                }

            }
        }


        override fun onBindViewHolder(
            holder: RecyclerQnaImgAdapter.CustomViewHolder, position: Int) {
            holder.profile.setImageResource(items_qna.get(position).profile)
            holder.title.text = items_qna.get(position).title

        }

        inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val profile = itemView.findViewById<ImageView>(R.id.recycle_qna_profile)
            val title = itemView.findViewById<TextView>(R.id.recycle_qna_title)
        }


    }


    //리사이클러 자유게시판 이미지어댑터
class RecyclerFreeImgAdapter(private val items_free: ArrayList<free_recycle_letter_data>) : RecyclerView.Adapter<RecyclerFreeImgAdapter.CustomViewHolder>() {
        override fun getItemCount(): Int = items_free.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerFreeImgAdapter.CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_free_recycle_letter, parent, false)
            return CustomViewHolder(view).apply {
                itemView.setOnClickListener {
                    val curPos: Int = adapterPosition
                    val profile: free_recycle_letter_data = items_free.get(curPos)

                }

            }
        }

        override fun onBindViewHolder(holder: RecyclerFreeImgAdapter.CustomViewHolder, position: Int) {
            holder.profile.setImageResource(items_free.get(position).profile)
            holder.title.text = items_free.get(position).title

        }

        inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val profile = itemView.findViewById<ImageView>(R.id.recycle_free_profile)
            val title = itemView.findViewById<TextView>(R.id.recycle_free_title)
        }

    }

    //리사이클러 쿡게시판 이미지어댑터
class RecyclerCookImgAdapter(private val items_cook: ArrayList<cook_recycle_image_data>) : RecyclerView.Adapter<RecyclerCookImgAdapter.CustomViewHolder>() {

        override fun getItemCount(): Int = items_cook.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerCookImgAdapter.CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_cook_recycle_image, parent, false)
            return CustomViewHolder(view).apply {
                itemView.setOnClickListener {
                    val curPos: Int = adapterPosition
                    val profile: cook_recycle_image_data = items_cook.get(curPos)

                }

            }
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            holder.profile.setImageResource(items_cook.get(position).profile)
            holder.name.text = items_cook.get(position).name
            holder.img.text = items_cook.get(position).img
            holder.title.text = items_cook.get(position).title

        }


        //커스텀 뷰 홀더의 클래스
        //사이클에 있는 뷰 참조하는곳
        inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val profile = itemView.findViewById<ImageView>(R.id.recycle_cook_profile)
            val name = itemView.findViewById<TextView>(R.id.recycle_cook_name)
            val img = itemView.findViewById<Button>(R.id.recycle_cook_img)
            val title = itemView.findViewById<TextView>(R.id.recycle_cook_title)

        }
    }


class RecyclerRecipeDoneImageAdapter(private val items_done_image: ArrayList<done_image_recycle_data>) : RecyclerView.Adapter<RecyclerRecipeDoneImageAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int = items_done_image.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerRecipeDoneImageAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_done_image, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: done_image_recycle_data = items_done_image.get(curPos)
            }

        }
    }


    override fun onBindViewHolder(holder: RecyclerRecipeDoneImageAdapter.CustomViewHolder, position: Int) {
        holder.image.setImageResource(items_done_image.get(position).image)
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.recycle_recipe_done_image)

    }


}


