package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_cookbook_get_favorite.view.*
import kotlinx.android.synthetic.main.item_cookbook_get_recommand.view.*


//냉장고 재료 리사이클러
class RecyclerRefrigeratorSourceAdapter(private val items_source: ArrayList<refrigerator_source_recycle_data>) : RecyclerView.Adapter<RecyclerRefrigeratorSourceAdapter.CustomViewHolder>() {

    private val mData: ArrayList<String>? = null
    override fun getItemCount(): Int = items_source.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_refrigerator_source_recycle, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: refrigerator_source_recycle_data = items_source.get(curPos)
            }
        }
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.title.text = items_source.get(position).name
        holder.context.text=items_source.get(position).context

        holder.itemView.setOnClickListener{
            //Dialog_Refrigerator을 연결
            val dialog = holder.context?.let { Dialog_Refrigerator(it.context) }

            //다이얼로그 작동
            dialog?.showDialog()
        }
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.item_regierator_material_name)
        val context=itemView.findViewById<TextView>(R.id.item_regierator_material_content)
    }

    /*
    interface OnItemClickListener{
        fun onItemClick(v:View, data: refrigerator_source_recycle_data, pos : Int)
    }
    private var listener : RecyclerRefrigeratorSourceAdapter.OnItemClickListener? = null
    fun setOnItemClickListener(listener : RecyclerRefrigeratorSourceAdapter.OnItemClickListener) {
        this.listener = listener
    }*/
    /*inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtName: TextView = itemView.findViewById(R.id.item_refigerator_name)
        private val txtcontent: TextView = itemView.findViewById(R.id.item_regierator_material_content)

        fun bind(item: refrigerator_source_recycle_data) {
            txtName.text = item.name
            val pos = adapterPosition
            if(pos!= RecyclerView.NO_POSITION)
            {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView,item,pos)
                }
            }
        }
    }*/
}


//레시피 조리도구 리사이클러
class RecyclerRecipeCookwareAdapter(private val items_cookware: ArrayList<recipe_cookware_recycle_data>) : RecyclerView.Adapter<RecyclerRecipeCookwareAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int = items_cookware.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerRecipeCookwareAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_cookware_recycle, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: recipe_cookware_recycle_data = items_cookware.get(curPos)
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


//레시피 재료 리사이클러
class RecyclerRecipeSourceAdapter(private val items_source: ArrayList<recipe_source_recycle_data>) : RecyclerView.Adapter<RecyclerRecipeSourceAdapter.CustomViewHolder>() {

        override fun getItemCount(): Int = items_source.size


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerRecipeSourceAdapter.CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_source_recycle, parent, false)
            return CustomViewHolder(view).apply {
                itemView.setOnClickListener {
                    val curPos: Int = adapterPosition
                    val profile: recipe_source_recycle_data = items_source.get(curPos)
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


// Qna게시판 리사이클러
class RecyclerQnaImgAdapter(private val items_qna: ArrayList<community_qna_recycle_data>) : RecyclerView.Adapter<RecyclerQnaImgAdapter.CustomViewHolder>() {


        override fun getItemCount(): Int = items_qna.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerQnaImgAdapter.CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_qna_notice_recycle, parent, false)
            return CustomViewHolder(view).apply {
                itemView.setOnClickListener {
                    val curPos: Int = adapterPosition
                    val profile: community_qna_recycle_data = items_qna.get(curPos)

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

//요리책화면 레시피 가져오기 중 좋아요누른 레시피 어댑터 : RecyclerView
class CookBookGetFavoriteAdapter(var list: ArrayList<String>):  RecyclerView.Adapter<CookBookGetFavoriteAdapter.ListAdapter>(){

    class ListAdapter(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter {
        return ListAdapter(LayoutInflater.from(parent.context).inflate(R.layout.item_cookbook_get_favorite, parent, false))
    }

    override fun onBindViewHolder(holder: ListAdapter, position: Int) {
        holder.layout.goodimport_textImg.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}


//요리책화면 레시피 가져오기 중 추천 레시피 어댑터 : RecyclerView
class CookBookGetRecommandAdapter(var list: ArrayList<String>):  RecyclerView.Adapter<CookBookGetRecommandAdapter.ListAdapter>(){

    class ListAdapter(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter {
        return ListAdapter(LayoutInflater.from(parent.context).inflate(R.layout.item_cookbook_get_recommand, parent, false))
    }

    override fun onBindViewHolder(holder: ListAdapter, position: Int) {
        holder.layout.recommendimport_textImg.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}


// 자유게시판 리사이클러
class RecyclerFreeImgAdapter(private val items_free: ArrayList<community_free_recycle_data>) : RecyclerView.Adapter<RecyclerFreeImgAdapter.CustomViewHolder>() {
        override fun getItemCount(): Int = items_free.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerFreeImgAdapter.CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_free_notice_recycle, parent, false)
            return CustomViewHolder(view).apply {
                itemView.setOnClickListener {
                    val curPos: Int = adapterPosition
                    val profile: community_free_recycle_data = items_free.get(curPos)

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


// 요리 게시판 리사이클러
class RecyclerCookImgAdapter(private val items_cook: ArrayList<community_cook_recycle_data>) : RecyclerView.Adapter<RecyclerCookImgAdapter.CustomViewHolder>() {

        override fun getItemCount(): Int = items_cook.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerCookImgAdapter.CustomViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_cook_notice_recycle, parent, false)
            return CustomViewHolder(view).apply {
                itemView.setOnClickListener {
                    val curPos: Int = adapterPosition
                    val profile: community_cook_recycle_data = items_cook.get(curPos)

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


//  레시피 완성 리사이클러
class RecyclerRecipeDoneImageAdapter(private val items_done_image: ArrayList<recipe_done_image_recycle_data>) : RecyclerView.Adapter<RecyclerRecipeDoneImageAdapter.CustomViewHolder>() {



    override fun getItemCount(): Int = items_done_image.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerRecipeDoneImageAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_done_recycle, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: recipe_done_image_recycle_data = items_done_image.get(curPos)
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


// 검색 리사이클러 구현안됌
class RecyclerSearchAdapter(private val items_search: ArrayList<search_recycle_data>) : RecyclerView.Adapter<RecyclerSearchAdapter.CustomViewHolder>(),Filterable {


    var TAG = "PhoneBookListAdapter"

    var filteredPersons = ArrayList<search_recycle_data>()
    var itemFilter = ItemFilter()

    init {
        filteredPersons.addAll(items_search)
    }

    override fun getFilter(): Filter {
        return itemFilter
    }



    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()
            Log.d(TAG, "charSequence : $charSequence")

            //검색이 필요없을 경우를 위해 원본 배열을 복제
            val filteredList: ArrayList<search_recycle_data> = ArrayList<search_recycle_data>()
            //공백제외 아무런 값이 없을 경우 -> 원본 배열
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = items_search
                results.count = items_search.size

                return results
                //공백제외 2글자 이하인 경우 -> 이름으로만 검색
            } else if (filterString.trim { it <= ' ' }.length <= 2) {
                for (person in items_search) {
                    if (person.name.contains(filterString)) {
                        filteredList.add(person)
                    }
                }
                //그 외의 경우(공백제외 2글자 초과) -> 이름/전화번호로 검색
            } else {
                for (person in items_search) {
                    if (person.name.contains(filterString) || person.inform.contains(filterString)) {
                        filteredList.add(person)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }

        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            filteredPersons.clear()
            filteredPersons.addAll(filterResults.values as ArrayList<search_recycle_data>)
            notifyDataSetChanged()
        }
    }



    override fun getItemCount(): Int = items_search.size


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerSearchAdapter.CustomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_recycle, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: search_recycle_data = items_search.get(curPos)
            }

        }
    }


    override fun onBindViewHolder(holder: RecyclerSearchAdapter.CustomViewHolder, position: Int) {
        holder.profile.setImageResource(items_search.get(position).profile)
        holder.name.text = items_search.get(position).name
        holder.inform.text = items_search.get(position).name
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile = itemView.findViewById<ImageView>(R.id.recycle_search_profile)
        val name = itemView.findViewById<Button>(R.id.recycle_search_name)
        val inform = itemView.findViewById<TextView>(R.id.recycle_search_inform)

    }

}


//요리도구 리사이클러
class RecyclerWriteCookwareAdapter(private val items_qna: ArrayList<recipe_write_Cookwarerecycle_data>) : RecyclerView.Adapter<RecyclerWriteCookwareAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int = items_qna.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerWriteCookwareAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cookbook_write_material, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: recipe_write_Cookwarerecycle_data = items_qna.get(curPos)
            }
        }
    }


    override fun onBindViewHolder(
        holder: RecyclerWriteCookwareAdapter.CustomViewHolder, position: Int) {
        holder.profile.setImageResource(items_qna.get(position).image)
        holder.title.text = items_qna.get(position).title
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile = itemView.findViewById<ImageView>(R.id.cookbook_write_cookware_image)
        val title = itemView.findViewById<TextView>(R.id.cookbook_write_cookware_title)
    }
}

//재료 리사이클러
class RecyclerWriteMatarialAdapter(private val items_qna: ArrayList<recipe_write_Matarialrecycle_data>) : RecyclerView.Adapter<RecyclerWriteMatarialAdapter.CustomViewHolder>() {


    override fun getItemCount(): Int = items_qna.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerWriteMatarialAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cookbook_write_material, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: recipe_write_Matarialrecycle_data = items_qna.get(curPos)

            }

        }
    }


    override fun onBindViewHolder(
        holder: RecyclerWriteMatarialAdapter.CustomViewHolder, position: Int) {
        holder.profile.setImageResource(items_qna.get(position).image)
        holder.title.text = items_qna.get(position).title
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile = itemView.findViewById<ImageView>(R.id.cookbook_write_material_image)
        val title = itemView.findViewById<TextView>(R.id.cookbook_write_material_title)
    }
}

