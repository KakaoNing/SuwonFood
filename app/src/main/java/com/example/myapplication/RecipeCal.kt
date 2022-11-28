package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class RecipeCal : AppCompatActivity() {
    private var e1: EditText? = null
    var b1: Button? = null
    var t1: TextView? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_dialog_refrigerator_add_material) //전체뷰(xml파일) 들고오기
        e1 = findViewById<View>(R.id.Edit1) as EditText
        b1 = findViewById<View>(R.id.BtnAdd) as Button
        t1 = findViewById<View>(R.id.TextResult) as TextView


        b1!!.setOnClickListener {
            if (e1!!.text.toString() == "") {
                Toast.makeText(
                    this@RecipeCal,
                    "값이 없습니다.",
                    Toast.LENGTH_LONG
                ).show()
            } else { //둘 다 공백이 아닐때
                val s1 = e1!!.text.toString() //값 가져오기
                t1!!.text = ":$s1"
            }
        }
        t1!!.setOnClickListener {
            if (t1!!.text.toString()=="") {
                Toast.makeText(
                this@RecipeCal,
                "재료가없습니다.",
                Toast.LENGTH_LONG
                ).show()
            }else{
                Toast.makeText(
                this@RecipeCal,
                "값이 추가되었습니다.",
                Toast.LENGTH_LONG
            ).show()
            }
         }
            //t1.setText(String.valueOf(result));
    }
}