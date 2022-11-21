package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.community_notice_cook.*

class Community_notice_cook_Activity : AppCompatActivity() {


    lateinit var opt_community_notice_cook_recycle: RecyclerView
    var recyclerCookAdapter: RecyclerCookAdapter? = null
    lateinit var items_cook: ArrayList<community_cook_recycle_data>
    lateinit var opt_search_cook: SearchView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_notice_cook)



        opt_community_notice_cook_recycle = findViewById(R.id.opt_community_notice_cook_recycle)
        opt_search_cook = findViewById(R.id.opt_search_cook)
        opt_search_cook.setOnQueryTextListener(searchViewTextListener)
        items_cook = AddCookData()


        //글쓰기버튼
        community_notice_cook_button_write.setOnClickListener {
            var intent = Intent(this,Write_Community_Notice_Cook_Activity::class.java)
            startActivity(intent)
        }
    }


    //모르겠음
    override fun onResume() {
        super.onResume()
        if (recyclerCookAdapter == null) {
//            phoneBookListAdapter.initFilteredPersons()
//            Persons.getPersons().sort()
            setAdapter()
        } else {
            recyclerCookAdapter!!.initFilteredPersons()
//            Persons.getPersons().sort()
            recyclerCookAdapter!!.notifyDataSetChanged()
            recyclerCookAdapter!!.filter.filter(opt_search_cook.query)
        }
    }

    //SearchView 텍스트 입력시 이벤트
    var searchViewTextListener: SearchView.OnQueryTextListener =
        object : SearchView.OnQueryTextListener {
            //검색버튼 입력시 호출, 검색버튼이 없으므로 사용하지 않음
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            //텍스트 입력/수정시에 호출
            override fun onQueryTextChange(s: String): Boolean {
                recyclerCookAdapter?.filter?.filter(s)
                return false
            }
        }


    //리사이클러뷰에 리사이클러뷰 어댑터 부착
    fun setAdapter() {
        opt_community_notice_cook_recycle.layoutManager = LinearLayoutManager(this)
        recyclerCookAdapter = RecyclerCookAdapter(items_cook)
        opt_community_notice_cook_recycle.adapter = recyclerCookAdapter

    }


    //recycler에 값을 추가한다
    fun AddCookData(): ArrayList<community_cook_recycle_data> {
        var CookData = ArrayList<community_cook_recycle_data>()
        CookData.add(community_cook_recycle_data(R.drawable.base_user_img,"name",R.drawable.book_img,"egg"))
        CookData.add(community_cook_recycle_data(R.drawable.base_user_img,"name",R.drawable.book_img,"kimchi"))
        CookData.add(community_cook_recycle_data(R.drawable.base_user_img,"name",R.drawable.book_img,"fri"))
        CookData.add(community_cook_recycle_data(R.drawable.base_user_img,"name",R.drawable.book_img,"oil"))
        CookData.add(community_cook_recycle_data(R.drawable.base_user_img,"name",R.drawable.book_img,"pasta"))

        return CookData
    }

}