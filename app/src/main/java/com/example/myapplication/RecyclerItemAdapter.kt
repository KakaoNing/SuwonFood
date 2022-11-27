package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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

        holder.itemView.setOnClickListener{
            //Dialog_Refrigerator을 연결
            val dialog = holder.title?.let { Dialog_Refrigerator(it.context) }

            //다이얼로그 작동
            dialog?.showDialog()
        }
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.item_regierator_material_name)
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



// 요리 게시판 리사이클러
//https://greensky0026.tistory.com/226 이쪽 참고함 recycler 를 searchview하기
class RecyclerCookAdapter(var items_cook: ArrayList<community_cook_recycle_data>) : RecyclerView.Adapter<RecyclerCookAdapter.ViewHolder>(), Filterable {


    //선언
    var filteredCookCycle = ArrayList<community_cook_recycle_data>()
    var itemFilter = ItemFilter()


    //이너클래스 안에 선언
    inner class ViewHolder(itemView: View, con:Context) : RecyclerView.ViewHolder(itemView) {

        var recycle_cook_profile : ImageView
        var recycle_cook_name : TextView
        var recycle_cook_img : ImageView
        var recycle_cook_title : TextView


        init {
            recycle_cook_profile = itemView.findViewById(R.id.recycle_cook_profile)
            recycle_cook_name = itemView.findViewById(R.id.recycle_cook_name)
            recycle_cook_img = itemView.findViewById(R.id.recycle_cook_img)
            recycle_cook_title = itemView.findViewById(R.id.recycle_cook_title)

        }

    }

    //배열관리를 위한 filter구현
    init {
        filteredCookCycle.addAll(items_cook)
    }

    //리사이클러 구현
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val con = parent.context
        val inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_community_cook_notice_recycle, parent, false)

        return ViewHolder(view, con)
    }

    //리사이클러 각 item값 지정
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cook_notice: community_cook_recycle_data = filteredCookCycle[position]
        items_cook.get(position).profile?.let { holder.recycle_cook_profile.setImageResource(it) }
        holder.recycle_cook_name.text = cook_notice.name
        items_cook.get(position).img?.let { holder.recycle_cook_img.setImageResource(it) }
        holder.recycle_cook_title.text=cook_notice.title
    }

    //필터를 통한 아이템의 카운트를 셈
    override fun getItemCount(): Int {
        return filteredCookCycle.size
    }

    //필터 구현을 위한 get
    override fun getFilter(): Filter {
        return itemFilter
    }
    //배열 초기화시 필요함 검색마다 초기화해야하기때문
    fun initFilteredPersons() {
        filteredCookCycle.clear()
        filteredCookCycle.addAll(items_cook)
    }


    //필터의 이너클래스
    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()

            //검색이 필요없을 경우를 위해 원본 배열을 복제
            val filteredList: ArrayList<community_cook_recycle_data> = ArrayList<community_cook_recycle_data>()
            //공백제외 아무런 값이 없을 경우 -> 원본 배열
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = items_cook
                results.count = items_cook.size

                return results
                //공백제외 2글자 이인 경우
            } else if (filterString.trim { it <= ' ' }.length <= 2) {
                for (cook_notice in items_cook) {
                    if (cook_notice.title?.contains(filterString) == true) {
                        filteredList.add(cook_notice)
                    }
                }
                //그 외의 경우(공백제외 2글자 초과)
            } else {
                for (cook_notice in items_cook) {
                    if (cook_notice.title?.contains(filterString) == true){
                        filteredList.add(cook_notice)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }

        //결과 출력을 위한 배열에 추가
        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            filteredCookCycle.clear()
            filteredCookCycle.addAll(filterResults.values as ArrayList<community_cook_recycle_data>)
            notifyDataSetChanged()
        }
    }

}

// 자유게시판 리사이클러
//https://greensky0026.tistory.com/226 이쪽 참고함 recycler 를 searchview하기
class RecyclerFreeAdapter(private val items_free: ArrayList<community_free_recycle_data>) : RecyclerView.Adapter<RecyclerFreeAdapter.ViewHolder>(),Filterable {
    //선언
    var filteredFreeCycle = ArrayList<community_free_recycle_data>()
    var itemFilter = ItemFilter()


    //이너클래스 안에 선언
    inner class ViewHolder(itemView: View, con: Context) : RecyclerView.ViewHolder(itemView) {

        var recycle_free_profile: ImageView
        var recycle_free_title: TextView
        var recycle_free_script: TextView


        init {
            recycle_free_profile = itemView.findViewById(R.id.recycle_free_profile)
            recycle_free_title = itemView.findViewById(R.id.recycle_free_title)
            recycle_free_script=itemView.findViewById(R.id.recycle_free_script)

        }

    }

    //배열관리를 위한 filter구현
    init {
        filteredFreeCycle.addAll(items_free)
    }

    //리사이클러 구현
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val con = parent.context
        val inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_community_free_notice_recycle, parent, false)

        return ViewHolder(view, con)
    }

    //리사이클러 각 item값 지정
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val free_notice: community_free_recycle_data = filteredFreeCycle[position]
        items_free.get(position).profile?.let { holder.recycle_free_profile.setImageResource(position) }
        holder.recycle_free_title.text = free_notice.title
        holder.recycle_free_script.text = free_notice.script
    }

    //필터를 통한 아이템의 카운트를 셈
    override fun getItemCount(): Int {
        return filteredFreeCycle.size
    }

    //필터 구현을 위한 get
    override fun getFilter(): Filter {
        return itemFilter
    }

    //배열 초기화시 필요함 검색마다 초기화해야하기때문
    fun initFilteredPersons() {
        filteredFreeCycle.clear()
        filteredFreeCycle.addAll(items_free)
    }


    //필터의 이너클래스
    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()

            //검색이 필요없을 경우를 위해 원본 배열을 복제
            val filteredList: ArrayList<community_free_recycle_data> =
                ArrayList<community_free_recycle_data>()
            //공백제외 아무런 값이 없을 경우 -> 원본 배열
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = items_free
                results.count = items_free.size

                return results
                //공백제외 2글자 이인 경우
            } else if (filterString.trim { it <= ' ' }.length <= 2) {
                for (free_notice in items_free) {
                    if (free_notice.title?.contains(filterString) == true) {
                        filteredList.add(free_notice)
                    }
                }
                //그 외의 경우(공백제외 2글자 초과)
            } else {
                for (free_notice in items_free) {
                    if (free_notice.title?.contains(filterString) == true) {
                        filteredList.add(free_notice)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }

        //결과 출력을 위한 배열에 추가
        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            filteredFreeCycle.clear()
            filteredFreeCycle.addAll(filterResults.values as ArrayList<community_free_recycle_data>)
            notifyDataSetChanged()
        }
    }
}



// Qna게시판 리사이클러
class RecyclerQnaAdapter(private val items_qna: ArrayList<community_qna_recycle_data>) : RecyclerView.Adapter<RecyclerQnaAdapter.ViewHolder>(),Filterable {
    //선언
    var filteredQnaCycle = ArrayList<community_qna_recycle_data>()
    var itemFilter = ItemFilter()


    //이너클래스 안에 선언
    inner class ViewHolder(itemView: View, con: Context) : RecyclerView.ViewHolder(itemView) {

        var recycle_qna_profile: ImageView
        var recycle_qna_title: TextView
        var recycle_qna_script: TextView

        fun bind(item: community_qna_recycle_data){
            recycle_qna_title.text=item.title
            recycle_qna_script.text=item.script
        }

        init {
            recycle_qna_profile = itemView.findViewById(R.id.recycle_qna_profile)
            recycle_qna_title = itemView.findViewById(R.id.recycle_qna_title)
            recycle_qna_script = itemView.findViewById(R.id.recycle_qna_script)

            itemView.setOnClickListener(View.OnClickListener {
                Log.d("Click",recycle_qna_script.text.toString()+"클릭되었다")
                val intent = Intent(con, Write_Community_Notice_Qna_Info_Activity::class.java)
                intent.putExtra("title",recycle_qna_title.text.toString())
                intent.putExtra("script",recycle_qna_script.text.toString())
//                intent.putExtra("title",recycle_qna_profile.text.toString())
                con.startActivity(intent)
            })

        }
    }

    //배열관리를 위한 filter구현
    init {
        filteredQnaCycle.addAll(items_qna)
    }

    //리사이클러 구현
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val con = parent.context
        val inflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_community_qna_notice_recycle, parent, false)

        return ViewHolder(view, con)
    }

    //리사이클러 각 item값 지정
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val free_notice: community_qna_recycle_data = filteredQnaCycle[position]
        items_qna.get(position).profile?.let { holder.recycle_qna_profile.setImageResource(it) }
        holder.recycle_qna_title.text = free_notice.title
        holder.recycle_qna_script.text = free_notice.script
    }

    //필터를 통한 아이템의 카운트를 셈
    override fun getItemCount(): Int {
        return filteredQnaCycle.size
    }

    //필터 구현을 위한 get
    override fun getFilter(): Filter {
        return itemFilter
    }

    //배열 초기화시 필요함 검색마다 초기화해야하기때문
    fun initFilteredPersons() {
        filteredQnaCycle.clear()
        filteredQnaCycle.addAll(items_qna)
    }


    //필터의 이너클래스
    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()

            //검색이 필요없을 경우를 위해 원본 배열을 복제
            val filteredList: ArrayList<community_qna_recycle_data> = ArrayList<community_qna_recycle_data>()
            //공백제외 아무런 값이 없을 경우 -> 원본 배열
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = items_qna
                results.count = items_qna.size

                return results
                //공백제외 2글자 이인 경우
            } else if (filterString.trim { it <= ' ' }.length <= 2) {
                for (qna_notice in items_qna) {
                    if (qna_notice.title?.contains(filterString) == true) {
                        filteredList.add(qna_notice)
                    }
                }
                //그 외의 경우(공백제외 2글자 초과)
            } else {
                for (qna_notice in items_qna) {
                    if (qna_notice.title?.contains(filterString) == true) {
                        filteredList.add(qna_notice)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }

        //결과 출력을 위한 배열에 추가
        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            filteredQnaCycle.clear()
            filteredQnaCycle.addAll(filterResults.values as ArrayList<community_qna_recycle_data>)
            notifyDataSetChanged()
        }
    }
}




//  레시피 완성 리사이클러
class RecyclerRecipeDoneImageAdapter(private val items_done_image: ArrayList<recipe_done_image_recycle_data>) : RecyclerView.Adapter<RecyclerRecipeDoneImageAdapter.CustomViewHolder>() {


    override fun getItemCount(): Int = items_done_image.size


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerRecipeDoneImageAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe_done_recycle, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: recipe_done_image_recycle_data = items_done_image.get(curPos)
            }

        }
    }


    override fun onBindViewHolder(
        holder: RecyclerRecipeDoneImageAdapter.CustomViewHolder,
        position: Int
    ) {
        holder.image.setImageResource(items_done_image.get(position).image)
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.recycle_recipe_done_image)

    }
}


// 커뮤니티 오늘의 레시피 리사이클러
class RecyclerCommunityTodayRecipeAdapter(private val items_today_recipe: ArrayList<community_today_recipe>) : RecyclerView.Adapter<RecyclerCommunityTodayRecipeAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int = items_today_recipe.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerCommunityTodayRecipeAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_today_recipe, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: community_today_recipe = items_today_recipe.get(curPos)
            }

        }
    }


    override fun onBindViewHolder(holder: RecyclerCommunityTodayRecipeAdapter.CustomViewHolder, position: Int) {
        holder.name.text = items_today_recipe.get(position).name
        holder.title.text = items_today_recipe.get(position).title
        holder.profile.setImageResource(items_today_recipe.get(position).profile)
        holder.img.setImageResource(items_today_recipe.get(position).img)
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile = itemView.findViewById<ImageView>(R.id.recycle_today_recipe_profile)
        val name = itemView.findViewById<TextView>(R.id.recycle_today_recipe_name)
        val img = itemView.findViewById<ImageView>(R.id.recycle_today_recipe_img)
        val title = itemView.findViewById<TextView>(R.id.recycle_today_recipe_title)

    }


}



// 커뮤니티 오늘의 게시글 리사이클러
class RecyclerCommunityTodayNoticeAdapter(private val items_today_notice: ArrayList<community_today_notice>) : RecyclerView.Adapter<RecyclerCommunityTodayNoticeAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int = items_today_notice.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerCommunityTodayNoticeAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_today_notice, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val profile: community_today_notice = items_today_notice.get(curPos)
            }

        }
    }


    override fun onBindViewHolder(holder: RecyclerCommunityTodayNoticeAdapter.CustomViewHolder, position: Int) {
        holder.title.text = items_today_notice.get(position).title
        holder.profile.setImageResource(items_today_notice.get(position).profile)
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile = itemView.findViewById<ImageView>(R.id.recycle_today_notice_profile)
        val title = itemView.findViewById<TextView>(R.id.recycle_today_notice_title)

    }


}


