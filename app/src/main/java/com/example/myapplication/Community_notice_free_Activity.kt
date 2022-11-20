package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.community_notice_cook.*
import kotlinx.android.synthetic.main.community_notice_free.*
import kotlinx.android.synthetic.main.community_notice_qna.*

class Community_notice_free_Activity : AppCompatActivity() {

    lateinit var opt_community_notice_free_recycle: RecyclerView
    var recyclerFreeAdapter: RecyclerFreeAdapter? = null
    lateinit var items_free: ArrayList<community_free_recycle_data>
    lateinit var opt_search_free: SearchView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_notice_free)


        opt_community_notice_free_recycle = findViewById(R.id.opt_community_notice_free_recycle)
        opt_search_free = findViewById(R.id.opt_search_free)
        opt_search_free.setOnQueryTextListener(searchViewTextListener)
        items_free = AddFreeData()


        //글쓰기 버튼
        community_notice_free_button_write.setOnClickListener {
            var intent = Intent(this,Write_Community_Notice_Free_Activity::class.java)
            startActivity(intent)
        }
    }


    //모르겠음
    override fun onResume() {
        super.onResume()
        if (recyclerFreeAdapter == null) {
//            phoneBookListAdapter.initFilteredPersons()
//            Persons.getPersons().sort()
            setAdapter()
        } else {
            recyclerFreeAdapter!!.initFilteredPersons()
//            Persons.getPersons().sort()
            recyclerFreeAdapter!!.notifyDataSetChanged()
            recyclerFreeAdapter!!.filter.filter(opt_search_free.query)
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
                recyclerFreeAdapter?.filter?.filter(s)
                return false
            }
        }


    //리사이클러뷰에 리사이클러뷰 어댑터 부착
    fun setAdapter() {
        opt_community_notice_free_recycle.layoutManager = LinearLayoutManager(this)
        recyclerFreeAdapter = RecyclerFreeAdapter(items_free)
        opt_community_notice_free_recycle.adapter = recyclerFreeAdapter

    }


    //recycler에 값을 추가한다
    fun AddFreeData(): ArrayList<community_free_recycle_data> {
        var FreeData = ArrayList<community_free_recycle_data>()
        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"안녕하세요1"))
        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"오늘 학교왔는데11"))
        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"가 가기싫다111..."))
        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"살려주세요"))
        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"개발 재미없어요"))
        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"today"))
        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"tomorrow"))

        return FreeData
    }




}