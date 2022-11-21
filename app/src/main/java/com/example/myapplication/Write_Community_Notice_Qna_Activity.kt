package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.WriteCommunityNoticeCookBinding
import com.example.myapplication.databinding.WriteCommunityNoticeQnaBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*

class Write_Community_Notice_Qna_Activity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    lateinit var binding: WriteCommunityNoticeQnaBinding
    lateinit var storage:FirebaseStorage

    val db = Firebase.firestore


    val getDB = db.getNamedQuery("qna")
    val DEFAULT_GALLERY_REQUEST_CODE = 200
    val IMAGE_PICK = 111
    var selectImage: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.write_community_notice_free)
        binding = WriteCommunityNoticeQnaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var title = binding.writeCommunityNoticeQnaTitle
        var script = binding.writeCommunityNoticeQnaScript
        val button_qna = binding.buttonQna
        val button_qna2 = binding.buttonQna2

        val String = "content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F41/ORIGINAL/NONE/image%2Fpng/1563818880"
        val uri = Uri.parse(String)

        storage = FirebaseStorage.getInstance()

        //갤러리에서 사진 가져오기
        binding.buttonQna2.setOnClickListener {
            //gallery app........................
            val intent = Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(intent,IMAGE_PICK)
        }

        //저장
        button_qna.setOnClickListener(View.OnClickListener {
            val data = community_qna_recycle_data(R.drawable.base_user_img,title.text.toString(),script.text.toString())
            db.collection("qna")
                .add(data)
                .addOnSuccessListener { documentReference ->
                    Log.d("kimhwan","add successfully")
                    Toast.makeText(baseContext,"업로드가 완료되었습니다.", Toast.LENGTH_SHORT).show()
                }

                    //업로드 성공하면 사진도 업로드함
                .addOnFailureListener{ e ->
                    Log.w("kimhwan","업로드 실패")
                    Toast.makeText(baseContext,"업로드에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            println(data)
            finish()

        //사진 업로드
//        button_qna2.setOnClickListener(View.OnClickListener {
//
//        })
        })
    }

    //이미지 미리보기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==IMAGE_PICK&&resultCode==Activity.RESULT_OK){
            selectImage=data?.data
            binding.imageViewQna.setImageURI(selectImage)
            Log.d("selectImage Type ",selectImage.toString())
        }
    }

}