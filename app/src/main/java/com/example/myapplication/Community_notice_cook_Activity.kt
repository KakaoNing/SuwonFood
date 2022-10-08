package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.community_notice_cook.*
import kotlinx.android.synthetic.main.item_community_cook_recycle_image.*

class Community_notice_cook_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_notice_cook)


        //배열에 추가 img는 이미지로 수정가능
        val items  = arrayListOf(
            cook_recycle_image_data(R.drawable.comunity_cook_notice,"프로필","그림","요리제목"),
            cook_recycle_image_data(R.drawable.comunity_cook_notice,"프로필2","그림","요리제목2")
        )

        //리사이클러뷰 옵션
       opt_community_notice_cook_recycle_image.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        opt_community_notice_cook_recycle_image.setHasFixedSize(true)
        opt_community_notice_cook_recycle_image.adapter = RecyclerCookImgAdapter(items)







    }
}