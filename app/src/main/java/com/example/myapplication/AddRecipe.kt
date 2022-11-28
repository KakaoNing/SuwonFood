package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ddetail.*


class AddRecipe : AppCompatActivity() {
    var add_view: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_dialog_refrigerator_add_material)
        add_view!!.setOnClickListener {
            val n_layout = Sub(applicationContext)
            val con = findViewById<View>(R.id.con) as LinearLayout
            con.addView(n_layout)
            val but = view.findViewById(R.id.b1) as Button
            but.setOnClickListener {
                Toast.makeText(
                    this@AddRecipe,
                    "클릭되었습니다.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}