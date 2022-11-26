package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.community_notice_cook.*
import kotlinx.android.synthetic.main.community_notice_qna.*

class Community_notice_qna_Activity : AppCompatActivity() {

    lateinit var opt_community_notice_qna_recycle: RecyclerView
    var recyclerQnaAdapter: RecyclerQnaAdapter? = null
    lateinit var items_qna: ArrayList<community_qna_recycle_data>
    lateinit var opt_search_qna: SearchView

    val db = Firebase.firestore
    //val getDB = db.getNamedQuery("free")


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
        recyclerQnaAdapter?.notifyDataSetChanged()

    }


    //recycler에 값을 추가한다
    fun AddQnaData(): ArrayList<community_qna_recycle_data> {

        var QnaData = ArrayList<community_qna_recycle_data>()
        Log.d("초기 FREEdata",QnaData.toString())
        db.collection("qna")
            .get()
            .addOnSuccessListener{ result ->
                //val itemList = mutableListOf<community_free_recycle_data>()
                for(document in result){
                    val item_qna = document.toObject<community_qna_recycle_data>()
                    //item.title=document.data.toString()
                    items_qna.add(item_qna)
                    Log.d("kimhwan", "${document.id} => ${document.data}")
                    Log.d("item", item_qna.toString())
                    Log.d("cookdata", QnaData.toString())
                    Log.d("items_free",items_qna.toString())
                    //recycler에 값을 추가한다
                    setAdapter()
                }
                Log.d("FreeData","데이터 불러오기 성공");
            }
            .addOnFailureListener{ e ->
                Log.d("kimhwan","데이터 불러오지 못했습니다.", e)
                Toast.makeText(this,"서버로부터 데이터를 불러오지 못했습니다.", Toast.LENGTH_SHORT).show()
            }

        return QnaData

    }


}