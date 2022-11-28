package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.WriteCommunityNoticeCookBinding
import com.example.myapplication.databinding.WriteCommunityNoticeFreeBinding
import com.example.myapplication.databinding.WriteCommunityNoticeQnaBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.util.*

class Write_Community_Notice_Cook_Activity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    lateinit var binding: WriteCommunityNoticeCookBinding
    lateinit var storage: FirebaseStorage

    val db = Firebase.firestore

    val getDB = db.getNamedQuery("cook")
    val DEFAULT_GALLERY_REQUEST_CODE = 200
    val IMAGE_PICK = 111
    val IMAGE_PICK_1 = 112
    val IMAGE_PICK_2 = 113
    val IMAGE_PICK_3 = 114
    val IMAGE_PICK_4 = 115
    var selectImage: Uri? = null
    var image : String? = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.write_community_notice_free)
        binding = WriteCommunityNoticeCookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var profile = binding.cookTitleImage
        var title = binding.title
        var summary = binding.titleSummary
        var tools = binding.tools
        var ingredients = binding.ingredients
        var number = binding.number

        val button_add_ingre = binding.ingreButton

        var imgplus1 = binding.imagePlus1
        var imgplus2 = binding.imagePlus2
        var imgplus3 = binding.imagePlus3
        var imgplus4 = binding.imagePlus4
        var imgplus1_source :String? = " "
        var imgplus2_source :String? = " "
        var imgplus3_source :String? = " "
        var imgplus4_source :String? = " "
        var script: String? = " "
        var source: String? = " "
        val button_add = binding.submit
        //val button_qna2 = binding.buttonQna2

        storage = FirebaseStorage.getInstance()

        //갤러리에서 사진 가져오기
        binding.cookTitleImage.setOnClickListener {
            //gallery app........................
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(intent,IMAGE_PICK)
        }

        imgplus1.setOnClickListener{
            //gallery app........................
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(intent,IMAGE_PICK)
        }

        imgplus2.setOnClickListener{
            //gallery app........................
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(intent,IMAGE_PICK)
        }

        imgplus3.setOnClickListener{
            //gallery app........................
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(intent,IMAGE_PICK)
        }

        imgplus4.setOnClickListener{
            //gallery app........................
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(intent,IMAGE_PICK)
        }

//        ,source, ,tools.text.toString()
//        imgplus1_source,imgplus2_source,imgplus3_source,imgplus4_source
        //저장
        button_add.setOnClickListener(View.OnClickListener {
            ImageUpload()
            val data = community_cook_recycle_data(image,title.text.toString(),summary.text.toString(),
            script)
            db.collection("cook")
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
        if(requestCode==IMAGE_PICK&&resultCode== Activity.RESULT_OK){
            selectImage=data?.data
            binding.cookTitleImage.setImageURI(selectImage)
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

    private fun ImageUpload_1(){
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

    private fun ImageUpload_2(){
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

    private fun ImageUpload_3(){
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

    private fun ImageUpload_4(){
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