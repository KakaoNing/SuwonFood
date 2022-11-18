package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import androidx.core.content.ContextCompat
import androidx.core.view.doOnLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.community_notice_cook.*

class Community_notice_cook_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_notice_cook)


        //배열에 추가 img는 이미지로 수정가능
        val items  = arrayListOf(
            community_cook_recycle_data(R.drawable.base_user_img,"User1","계란말이","집에서 하기 좋은 계란말이"),
            community_cook_recycle_data(R.drawable.base_user_img,"User2","김치찌개","얼큰 김치찌개")
        )

        //리사이클러뷰 옵션
       opt_community_notice_cook_recycle_image.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        opt_community_notice_cook_recycle_image.setHasFixedSize(true)
        opt_community_notice_cook_recycle_image.adapter = RecyclerCookImgAdapter(items)


        community_notice_cook_button_write.setOnClickListener {
            var intent = Intent(this,Write_Community_Notice_Cook_Activity::class.java)
            startActivity(intent)
        }











    }
}