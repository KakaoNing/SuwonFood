package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CommunityNoticeFreeBinding
import com.example.myapplication.databinding.WriteCommunityNoticeFreeBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.community_notice_cook.*
import kotlinx.android.synthetic.main.community_notice_free.*
import kotlinx.android.synthetic.main.community_notice_qna.*

class Community_notice_free_Activity : AppCompatActivity() {

    lateinit var opt_community_notice_free_recycle: RecyclerView
    var recyclerFreeAdapter: RecyclerFreeAdapter? = null
    lateinit var items_free: ArrayList<community_free_recycle_data>
    lateinit var opt_search_free: SearchView
    lateinit var binding: CommunityNoticeFreeBinding

    val db = Firebase.firestore
    val getDB = db.getNamedQuery("free")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CommunityNoticeFreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.community_notice_free)
        //getData()
        items_free = AddFreeData()

        opt_community_notice_free_recycle = binding.optCommunityNoticeFreeRecycle
        opt_search_free = binding.optSearchFree
        opt_search_free.setOnQueryTextListener(searchViewTextListener)
        Log.d("items_free",items_free.toString())

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
            recyclerFreeAdapter?.initFilteredPersons()
//            Persons.getPersons().sort()
            recyclerFreeAdapter?.notifyDataSetChanged()
            recyclerFreeAdapter?.filter?.filter(opt_search_free.query)
        }
    }


    //DB에서 자유게시판 글 불러오기
    fun AddFreeData(): ArrayList<community_free_recycle_data> {
        var FreeData = ArrayList<community_free_recycle_data>()
        Log.d("초기 FREEdata",FreeData.toString())
        db.collection("free")
            .get()
            .addOnSuccessListener{ result ->
                //val itemList = mutableListOf<community_free_recycle_data>()
                for(document in result){
                    val item = document.toObject<community_free_recycle_data>()
                    //item.title=document.data.toString()
                    items_free.add(item)
                    Log.d("kimhwan", "${document.id} => ${document.data}")
                    Log.d("item", item.toString())
                    Log.d("FreeData", FreeData.toString())
                    Log.d("items_free",items_free.toString())
                    //recycler에 값을 추가한다
                    setAdapter()
                }
                Log.d("FreeData","데이터 불러오기 성공");
            }
            .addOnFailureListener{ e ->
                Log.d("kimhwan","데이터 불러오지 못했습니다.", e)
                Toast.makeText(this,"서버로부터 데이터를 불러오지 못했습니다.",Toast.LENGTH_SHORT).show()
            }
//        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"안녕하세요","오늘 처음 오게 되었습니다."))
//        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"오늘 학교왔는데","테스트"))
//        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"개발중","테스트123"))
//        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"완성중","요리 어려워요"))
//        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"개발 진행중","요리가 쉬워요"))
//        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"today","스파게티 만들기"))
//        FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"tomorrow","개발 진행중"))
        return FreeData
    }

    private fun getData(){

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
        recyclerFreeAdapter?.notifyDataSetChanged()

    }





}