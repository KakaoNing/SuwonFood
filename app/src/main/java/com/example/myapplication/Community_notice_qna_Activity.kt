package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.community_notice_cook.*
import kotlinx.android.synthetic.main.community_notice_qna.*

class Community_notice_qna_Activity : AppCompatActivity() {

    lateinit var opt_community_notice_qna_recycle: RecyclerView
    var recyclerQnaAdapter: RecyclerQnaAdapter? = null
    lateinit var items_qna: ArrayList<community_qna_recycle_data>
    lateinit var opt_search_qna: SearchView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_notice_qna)


        opt_community_notice_qna_recycle = findViewById(R.id.opt_community_notice_qna_recycle)
        opt_search_qna = findViewById(R.id.opt_search_qna)
        opt_search_qna.setOnQueryTextListener(searchViewTextListener)
        items_qna = AddQnaData()



        //글쓰기 버튼
        community_notice_qna_button_write.setOnClickListener {
            var intent = Intent(this,Write_Community_Notice_Qna_Activity::class.java)
            startActivity(intent)
        }
    }


    //모르겠음
    override fun onResume() {
        super.onResume()
        if (recyclerQnaAdapter == null) {
//            phoneBookListAdapter.initFilteredPersons()
//            Persons.getPersons().sort()
            setAdapter()
        } else {
            recyclerQnaAdapter!!.initFilteredPersons()
//            Persons.getPersons().sort()
            recyclerQnaAdapter!!.notifyDataSetChanged()
            recyclerQnaAdapter!!.filter.filter(opt_search_qna.query)
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
                recyclerQnaAdapter?.filter?.filter(s)
                return false
            }
        }


    //리사이클러뷰에 리사이클러뷰 어댑터 부착
    fun setAdapter() {
        opt_community_notice_qna_recycle.layoutManager = LinearLayoutManager(this)
        recyclerQnaAdapter = RecyclerQnaAdapter(items_qna)
        opt_community_notice_qna_recycle.adapter = recyclerQnaAdapter

    }


    //recycler에 값을 추가한다
    fun AddQnaData(): ArrayList<community_qna_recycle_data> {
        var QnaData = ArrayList<community_qna_recycle_data>()
        QnaData.add(community_qna_recycle_data(R.drawable.base_user_img,"egg"))
        QnaData.add(community_qna_recycle_data(R.drawable.base_user_img,"fri"))
        QnaData.add(community_qna_recycle_data(R.drawable.base_user_img,"question"))
        QnaData.add(community_qna_recycle_data(R.drawable.base_user_img,"hello"))
        QnaData.add(community_qna_recycle_data(R.drawable.base_user_img,"akakak"))

        return QnaData
    }
}