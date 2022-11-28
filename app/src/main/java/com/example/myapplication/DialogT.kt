package com.example.myapplication


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DialogT : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_dialog_refrigerator_material)

        //activity_main.xml layout에 존재하는 textView 얻기
        val tv_text = findViewById<View>(R.id.TextResult) as TextView

        //LayoutInflater 객체 생성
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.item_dialog_refrigerator_add_material, null)

        //activity_sub.xml layout에 존재하는 Button, TextView 객체 생성(얻기)
        val btn: Button = view.findViewById(R.id.dialog_material_choicbutton) as Button
        val tv = view.findViewById(R.id.dialog_Textview) as TextView

        //activity_main.xml layout의 textView에    activity_sub.xml layout에 존재하는  값을 얻어와서 보여주기
        tv_text.text = """
            버튼에 써있는 글자는 [${btn.getText().toString().toString()}]이고
            텍스트뷰에 써있는 글자는 [${tv.text}]이다
            """.trimIndent()
    }
}