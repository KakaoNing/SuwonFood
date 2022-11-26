package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.WriteCommunityNoticeCookBinding
import com.example.myapplication.databinding.WriteCommunityNoticeFreeBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Write_Community_Notice_Cook_Activity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    lateinit var binding: WriteCommunityNoticeCookBinding

    val db = Firebase.firestore
    val getDB = db.getNamedQuery("free")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.write_community_notice_free)
        binding = WriteCommunityNoticeCookBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var title = binding.writeCommunityNoticeCookTitle
//        var script = binding.writeCommunityNoticeFreeScript
//        val button = binding.writeCommunityFreeButton

        //val data = community_free_recycle_data(R.drawable.base_user_img,"123","테스트내용")


//        button.setOnClickListener(View.OnClickListener {
//            val data = community_free_recycle_data(R.drawable.base_user_img,title.text.toString(),script.text.toString())
//            db.collection("free")
//                .add(data)
//                .addOnSuccessListener { documentReference ->
//                    Log.d("kimhwan","add successfully")
//                    Toast.makeText(baseContext,"업로드가 완료되었습니다.", Toast.LENGTH_SHORT).show()
//                }
//                .addOnFailureListener{ e ->
//                    Log.w("kimhwan","업로드 실패")
//                    Toast.makeText(baseContext,"업로드에 실패했습니다.", Toast.LENGTH_SHORT).show()
//                }
//            println(data)
//
//            finish()
//
//        })

    }

    // 글을 작성해서 DB에 글 저장하기
    // data 양식 community_free_recycle_data
    fun WriteFreeData(){
        //var FreeData = ArrayList<community_free_recycle_data>()
        //FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"안녕하세요","오늘 처음 오게 되었습니다."))
        //FreeData.add(community_free_recycle_data(R.drawable.base_user_img,"오늘 학교왔는데","테스트"))


    }
}