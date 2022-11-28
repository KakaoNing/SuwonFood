package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.WriteCommunityNoticeQnaBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.selects.select
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
    var image : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.write_community_notice_free)
        binding = WriteCommunityNoticeQnaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var title = binding.writeCommunityNoticeQnaTitle
        var script = binding.writeCommunityNoticeQnaScript
        val button_qna = binding.buttonQna
        val button_qna2 = binding.buttonQna2

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
            ImageUpload()
            val data = community_qna_recycle_data(image,title.text.toString(),script.text.toString())
            db.collection("qna")
                .add(data)
                .addOnSuccessListener { documentReference ->
                    Log.d("kimhwan","add successfully")
                    Log.d("kimhwan","image : $image")
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

    //이미지 업로드
    private fun ImageUpload(){
        var timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        var imgFileName = "Image_"+timeStamp+"_.png"
        var storageRef = storage?.reference?.child("images")?.child(imgFileName)
        image = imgFileName

        storageRef?.putFile(selectImage!!)?.addOnSuccessListener {
            Log.d("kimhwan","Image Upload successfully")
            Toast.makeText(this, "Image upload successful", Toast.LENGTH_SHORT).show()
        }
            ?.addOnFailureListener{ e->
                Log.w("kimhwan","업로드 실패")
                Toast.makeText(baseContext,"업로드에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
    }

}