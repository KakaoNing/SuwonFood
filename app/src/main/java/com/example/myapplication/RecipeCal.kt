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
    var e1: EditText? = null
    var b1: Button? = null
    var t1: TextView? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_dialog_refrigerator_add_material) //전체뷰(xml파일) 들고오기
        e1 = findViewById<View>(R.id.Edit1) as EditText
        b1 = findViewById<View>(R.id.BtnAdd) as Button
        t1 = findViewById<View>(R.id.TextResult) as TextView


        //버튼.1( 리스너 )
        b1!!.setOnClickListener {
            if (e1!!.text.toString() == "") {
                Toast.makeText(
                    this@RecipeCal,
                    "값이 없습니다.",
                    Toast.LENGTH_LONG
                ).show()
            } else { //둘 다 공백이 아닐때

                val result = e1!!.text.toString()
                t1!!.text = "재료확인:$result"
            }

            //t1.setText(String.valueOf(result));
        }
    }
}