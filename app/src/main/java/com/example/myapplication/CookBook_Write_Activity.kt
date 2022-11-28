package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build.VERSION_CODES.M
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.CookbookWriteBinding
import kotlinx.android.synthetic.main.activity_main.*



class CookBook_Write_Activity : AppCompatActivity() {

    private val GALLERY=1
    private val SUBGALLERY1=2
    private val SUBGALLERY2=3
    private val SUBGALLERY3=4
    private val SUBGALLERY4=5
    val binding by lazy { CookbookWriteBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //버튼 클릭
        binding.cookbookWriteImgTitle.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent,GALLERY)
        }

        val pagerAdapter= Recipe_Write_add_ViewPager2adapter(this)

        binding.cookbookRecipeInformPagerAddbutton.setOnClickListener {
            pagerAdapter.addFragment(CookBook_Write_Fragment())
            //추가시 배열 등록 함수

        }

        binding.cookbookRecipeInformPagerDelbutton.setOnClickListener{
            pagerAdapter.removeFragement()
        }

        //어뎁터를 홈페이저의 어뎁터에 복사
        binding.cookbookRecipeInformPager.adapter=pagerAdapter

        //초기 레시피 작성 프래그먼트 추가
        pagerAdapter.addFragment(CookBook_Write_Fragment())

        //처음 뷰페이저2 화면 설정(0= 맨위)
        binding.cookbookRecipeInformPager.setCurrentItem(0, false)

        //뷰페이저2 방향 설정 ORIENTATION_VERTICAL=가로방향
        binding.cookbookRecipeInformPager.orientation= ViewPager2.ORIENTATION_HORIZONTAL

        //item_recyclerview_write_material의 형태를 정의한다. VERTICAL은 세로방향의 리사이클러를 설정한다.
        binding.recyclerviewWriteMaterial.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)


        //재료 추가 리사이클러 함수
        var Materialadditems= arrayListOf(recipe_write_material_data("",""))
        binding.recyclerviewWriteMaterial.adapter = RecipeWriteMaterialAdapter(Materialadditems)
        var additemmaterialnumber=1
        binding.writeEditAddMaterialInput.setOnClickListener{

            val write_editadd_MaterialName:String=binding.writeEditAddMaterialName.text.toString()
            val write_editadd_MaterialValue:String=binding.writeEditAddMaterialValue.text.toString()
            if(additemmaterialnumber==1){
                additemmaterialnumber=0

                Materialadditems=
                    arrayListOf(recipe_write_material_data("$write_editadd_MaterialName","$write_editadd_MaterialValue"))
            }
            else{
                Materialadditems.add(recipe_write_material_data("$write_editadd_MaterialName","$write_editadd_MaterialValue")) }
            binding.recyclerviewWriteMaterial.adapter = RecipeWriteMaterialAdapter(Materialadditems)
        }

        //사진 추가 버튼 함수
        binding.writePluseImage1.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent,SUBGALLERY1)
        }

        binding.writePluseImage2.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent,SUBGALLERY2)
        }

        binding.writePluseImage3.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent,SUBGALLERY3)
        }

        binding.writePluseImage4.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent,SUBGALLERY4)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( resultCode == Activity.RESULT_OK){
            if( requestCode ==  GALLERY)
            {
                var ImnageData: Uri? = data?.data
                Toast.makeText(this,ImnageData.toString(), Toast.LENGTH_SHORT ).show()
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImnageData)
                    binding.cookbookWriteImgTitle.setImageBitmap(bitmap)
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
            }
            if (requestCode==SUBGALLERY1)
            {
                var ImnageData: Uri? = data?.data
                Toast.makeText(this,ImnageData.toString(), Toast.LENGTH_SHORT ).show()
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImnageData)
                    binding.writePluseImage1.setImageBitmap(bitmap)
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
            }
            if (requestCode==SUBGALLERY2)
            {
                var ImnageData: Uri? = data?.data
                Toast.makeText(this,ImnageData.toString(), Toast.LENGTH_SHORT ).show()
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImnageData)
                    binding.writePluseImage2.setImageBitmap(bitmap)
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
            }
            if (requestCode==SUBGALLERY3)
            {
                var ImnageData: Uri? = data?.data
                Toast.makeText(this,ImnageData.toString(), Toast.LENGTH_SHORT ).show()
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImnageData)
                    binding.writePluseImage3.setImageBitmap(bitmap)
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
            }
            if (requestCode==SUBGALLERY4)
            {
                var ImnageData: Uri? = data?.data
                Toast.makeText(this,ImnageData.toString(), Toast.LENGTH_SHORT ).show()
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImnageData)
                    binding.writePluseImage4.setImageBitmap(bitmap)
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
            }
        }
    }
}