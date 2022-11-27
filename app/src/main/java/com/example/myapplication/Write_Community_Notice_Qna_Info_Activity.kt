package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRecipeBinding
import com.example.myapplication.databinding.WriteCommunityNoticeQnaInfoBinding

class Write_Community_Notice_Qna_Info_Activity : AppCompatActivity() {

    val DEFAULT_GALLERY_REQUEST_CODE = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = WriteCommunityNoticeQnaInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        val script = intent.getStringExtra("script")
        val button = binding.buttonQna

        binding.writeCommunityNoticeQnaInfoTitle.text = title
        binding.writeCommunityNoticeQnaInfoScript.text = script

        button.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"답변을 달아주세요",Toast.LENGTH_SHORT).show()
        })

    }
}