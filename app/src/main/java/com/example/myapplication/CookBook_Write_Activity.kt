package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.util.Log.i
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.CookbookWriteBinding
import com.google.firestore.v1.StructuredAggregationQuery

/*import kotlinx.android.synthetic.main.cookbook_write.*
import kotlinx.android.synthetic.main.fragment_home_left.*
import kotlinx.android.synthetic.main.fragment_home_middle.**/


class CookBook_Write_Activity : AppCompatActivity() {

    var count=0
    private val GALLERY=1
    val binding by lazy { CookbookWriteBinding.inflate(layoutInflater) }
    private val FRAGMENT_TAG: String? = "FRAGMENT_TAG"
    private val KEY_NUMBER = "KEY_NUMBER"
    private var mNumber = 0
    private val viewpagerarray= arrayOf<String>("")

    private val mListener: FragmentManager.OnBackStackChangedListener =
        object : FragmentManager.OnBackStackChangedListener {
            override fun onBackStackChanged() {
                val fragmentManager: FragmentManager = supportFragmentManager
                var count = 0
                for (f in fragmentManager.getFragments()) {
                    if (f != null) {
                        count++
                    }
                }
                mNumber = count
                Log.d("MainActivity", "onBackStackChanged mNumber=$mNumber")
            }
        }
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
            count=count+1
            pagerAdapter.addFragment(CookBook_Write_Fragment())
            //추가시 배열 등록 함수

        }

        binding.cookbookRecipeInformPagerDelbutton.setOnClickListener{
            if(count>0) count=count-1
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

        var Materialadditems= arrayListOf(recipe_write_material_data("",""))
        var additemmaterialnumber=1
        binding.writeEditAddMaterialInput.setOnClickListener{

            val write_editadd_MaterialName:String=binding.writeEditAddMaterialName.text.toString()
            val write_editadd_MaterialValue:String=binding.writeEditAddMaterialValue.text.toString()
            if(additemmaterialnumber==1){
                additemmaterialnumber=0

                //viewpagerarray= arrayOf()

                Materialadditems=
                    arrayListOf(recipe_write_material_data("$write_editadd_MaterialName","$write_editadd_MaterialValue"))
            }
            else{
                Materialadditems.add(recipe_write_material_data("$write_editadd_MaterialName","$write_editadd_MaterialValue")) }
            binding.recyclerviewWriteMaterial.adapter = RecipeWriteMaterialAdapter(Materialadditems)
        }

        binding.writePluseImage1.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent,GALLERY)
        }

        binding.writePluseImage2.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent,GALLERY)
        }

        binding.writePluseImage3.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent,GALLERY)
        }

        binding.writePluseImage4.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent,GALLERY)
        }

        binding.recipeWriteSavebutton.setOnClickListener{
            //edit 사용한 글 담는 변수
            val write_TextCookware=binding.cookbookRecipeInformEditCookware.text.toString()
            val write_TextSummary = binding.cookbookRecipeInformEditSummary.text.toString()
            val write_TextTitle=binding.cookbookRecipeInformEditTitle.text.toString()
            val write_TextDescription=binding.cookbookRecipeInformEditDescription.text.toString()

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
        }
    }
}