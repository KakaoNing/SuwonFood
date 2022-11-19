package com.example.myapplication.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.*
import com.example.myapplication.Cookbook.Cookbook_get_Activity
//import com.example.myapplication.Cookbook.CookingManager.Cookbook_CookingtimeManagement_Activity
//import com.example.myapplication.Cookbook.Write.Cookbook_Create_Activity
//import com.example.myapplication.Cookbook.Manager.Cookbook_Management_Activity
import kotlinx.android.synthetic.main.fragment_home_right.*

// 홈 화면중 오른쪽에 해당하는 요리타임 Fragment.
class home_right : Fragment() {

    //버튼 변수 선언
    private lateinit var cookbook_create: Button
    private lateinit var cookbook_management: Button
    private lateinit var cookbook_cookingtimemanagement: Button
    private lateinit var cookbook_import: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home_right, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        //레시피 가져오기버튼작동 50~59
        //cookbook_button_Import버튼 불러오기
        cookbook_import = view.findViewById(R.id.cookbook_button_Import)

        //cookbook_import 클릭이벤트 작동
        cookbook_import.setOnClickListener {

            //Cookbook_get_Activity::class.java로 화면전환(intent 사용)
            var intent = Intent(context, Cookbook_get_Activity::class.java)
            startActivity(intent)
        }

        //레시피관리 버튼작동 62~71
        //cookbook_button_Management버튼 불러오기
        cookbook_management = view.findViewById(R.id.cookbook_button_Management)

        //cookbook_management 클릭이벤트 작동
        cookbook_management.setOnClickListener {

            //Cookbook_Management_Activity::class.java로 화면전환(intent 사용)
            var intent = Intent(context, Cookbook_Management_Activity::class.java)
            startActivity(intent)
        }

        //요리타임관리 버튼
        //cookbook_button_CookingtimeManagement버튼 불러오기
        cookbook_cookingtimemanagement = view.findViewById(R.id.cookbook_button_CookingtimeManagement)

        //cookbook_management 클릭이벤트 작동
        cookbook_cookingtimemanagement.setOnClickListener {

            //Cookbook_Community_Activity::class.java로 화면전환(intent 사용)
            var intent = Intent(context, Cookbook_Community_Activity::class.java)
            startActivity(intent)
        }
        /*

        //레시피 작성 버튼
        cookbook_create = view.findViewById(R.id.cookbook_button_Create)

        cookbook_create.setOnClickListener {
            var intent = Intent(context, Cookbook_Create_Activity::class.java)
            startActivity(intent)
        }





        //요리타임관리 버튼
        cookbook_cookingtimemanagement = view.findViewById(R.id.cookbook_button_CookingtimeManagement)

        cookbook_cookingtimemanagement.setOnClickListener {
            var intent = Intent(context, Cookbook_CookingtimeManagement_Activity::class.java)
            startActivity(intent)
        }*/

    }
}