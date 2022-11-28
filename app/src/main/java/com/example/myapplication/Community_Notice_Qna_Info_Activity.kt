package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myapplication.databinding.ActivityRecipeBinding
import com.example.myapplication.databinding.WriteCommunityNoticeQnaInfoBinding
import com.google.firebase.storage.FirebaseStorage

class Community_Notice_Qna_Info_Activity : AppCompatActivity() {

    val DEFAULT_GALLERY_REQUEST_CODE = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = WriteCommunityNoticeQnaInfoBinding.inflate(layoutInflater)
        val storage: FirebaseStorage = FirebaseStorage.getInstance("gs://suwonfood-final.appspot.com/")
        val storageReference = storage.reference

        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        val script = intent.getStringExtra("script")
        val profile = intent.getStringExtra("profile")
        val button = binding.buttonQna
        val image = binding.qnaInfoImage
        val pathReference = storageReference.child("images/$profile")

        binding.writeCommunityNoticeQnaInfoTitle.text = title
        binding.writeCommunityNoticeQnaInfoScript.text = script

        pathReference.downloadUrl.addOnSuccessListener { uri ->
            GlideApp.with(this)
                .load(uri)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerCrop()
                .into(image)
            Log.d("kimhwan","로딩 성공")
        }



        button.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"답변을 달아주세요",Toast.LENGTH_SHORT).show()
        })

    }
}