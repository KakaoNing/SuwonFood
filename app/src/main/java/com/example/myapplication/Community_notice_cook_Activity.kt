package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.community_notice_cook.*

class Community_notice_cook_Activity : AppCompatActivity() {


    lateinit var opt_community_notice_cook_recycle: RecyclerView
    var recyclerCookAdapter: RecyclerCookAdapter? = null
    lateinit var items_cook: ArrayList<community_cook_recycle_data>
    lateinit var opt_search_cook: SearchView

    val db = Firebase.firestore
    val getDB = db.getNamedQuery("free")

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
        recyclerCookAdapter?.notifyDataSetChanged()

    }


    //recycler에 값을 추가한다
    fun AddCookData(): ArrayList<community_cook_recycle_data> {
        var CookData = ArrayList<community_cook_recycle_data>()
        Log.d("초기 FREEdata",CookData.toString())
        db.collection("free")
            .get()
            .addOnSuccessListener{ result ->
                //val itemList = mutableListOf<community_free_recycle_data>()
                for(document in result){
                    val item_cook = document.toObject<community_cook_recycle_data>()
                    //item.title=document.data.toString()
                    items_cook.add(item_cook)
                    Log.d("kimhwan", "${document.id} => ${document.data}")
                    Log.d("item", item_cook.toString())
                    Log.d("FreeData", CookData.toString())
                    Log.d("items_free",items_cook.toString())
                    //recycler에 값을 추가한다
                    setAdapter()
                }
                Log.d("FreeData","데이터 불러오기 성공");
            }
            .addOnFailureListener{ e ->
                Log.d("kimhwan","데이터 불러오지 못했습니다.", e)
                Toast.makeText(this,"서버로부터 데이터를 불러오지 못했습니다.", Toast.LENGTH_SHORT).show()
            }

        return CookData
    }

}