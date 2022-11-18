package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.community_notice_cook.*
import kotlinx.android.synthetic.main.community_notice_free.*
import kotlinx.android.synthetic.main.community_notice_qna.*

class Community_notice_qna_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_notice_qna)



        //배열에 추가 img는 이미지로 수정가능
        val items  = arrayListOf(
            community_qna_recycle_data(R.drawable.base_user_img,"E1"),
            community_qna_recycle_data(R.drawable.base_user_img,"E2"),
            community_qna_recycle_data(R.drawable.base_user_img,"E3"),
            community_qna_recycle_data(R.drawable.base_user_img,"E4"),
            community_qna_recycle_data(R.drawable.base_user_img,"E5")
        )

        //리사이클러뷰 옵션
        opt_community_notice_qna_recycle_letter.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        opt_community_notice_qna_recycle_letter.setHasFixedSize(true)
        opt_community_notice_qna_recycle_letter.adapter = RecyclerQnaImgAdapter(items)

        community_notice_qna_button_write.setOnClickListener {
            var intent = Intent(this,Write_Community_Notice_Qna_Activity::class.java)
            startActivity(intent)
        }




    }
}