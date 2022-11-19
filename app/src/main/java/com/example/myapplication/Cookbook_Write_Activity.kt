package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityCookbookWriteBinding
import kotlinx.android.synthetic.main.cookbook_get.*

//레시피 작성 Activity
class Cookbook_Write_Activity : AppCompatActivity() {

    //binding 변수 선언
    lateinit var binding:ActivityCookbookWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding 초기화
        binding= ActivityCookbookWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(
            R.id.cookbook_Create_cooking_cookware_recycler_fragment,
            Cookbook_Write_Cookware()
        ).commit()

        supportFragmentManager.beginTransaction().replace(
            R.id.cookbook_Create_cooking_material_recycler_fragment,
            Cookbook_Write_Cookware()
        ).commit()

        supportFragmentManager.beginTransaction().replace(
            R.id.cookbook_create_Recipe_creation_box,
            Cookbook_Write_Box_Fragment()
        ).comit
    }
}