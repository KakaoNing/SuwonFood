package com.example.myapplication

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.item_dialog_refrigerator_material.*

class Dialog_Refrigerator(context: Context){
    //변수 선언
    private val dialog = Dialog(context)


    private lateinit var onClickListener: OnDialogClickListener

    //클릭 이벤트 설정
    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    //다이얼로그 실행 코드
    fun showDialog()
    {
        //화면 설정 25~29
        dialog.setContentView(R.layout.item_dialog_refrigerator_material)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        //button1~4.setOnClickListener는 재료 버튼 클릭 이벤트이다.
        dialog.dialog_material_button1.setOnClickListener {

            //다이얼로그 빌드 생성
            val vlist1dialog= AlertDialog.Builder(dialog.context)

            //화면 연결
            var v1 = dialog.layoutInflater.inflate(R.layout.item_dialog_refrigerator_add_material,null)

            //화면을 다이얼로그빌드에 세트
            vlist1dialog.setView(v1)

            //다이얼로그 빌드 실행
            vlist1dialog.show()

        }
        dialog.dialog_material_button2.setOnClickListener {

            //다이얼로그 빌드 생성
            val vlist2dialog= AlertDialog.Builder(dialog.context)

            //화면 연결
            var v2 = dialog.layoutInflater.inflate(R.layout.item_dialog_refrigerator_add_material,null)

            //화면을 다이얼로그빌드에 세트
            vlist2dialog.setView(v2)

            //다이얼로그 빌드 실행
            vlist2dialog.show()
        }
        dialog.dialog_material_button3.setOnClickListener {

            //다이얼로그 빌드 생성
            val vlist3dialog= AlertDialog.Builder(dialog.context)

            //화면 연결
            var v3 = dialog.layoutInflater.inflate(R.layout.item_dialog_refrigerator_add_material,null)
            //화면을 다이얼로그빌드에 세트
            vlist3dialog.setView(v3)

            //다이얼로그 빌드 실행
            vlist3dialog.show()
        }
        dialog.dialog_material_button4.setOnClickListener {

            //다이얼로그 빌드 생성
            val vlist4dialog= AlertDialog.Builder(dialog.context)

            //화면 연결
            var v4 = dialog.layoutInflater.inflate(R.layout.item_dialog_refrigerator_add_material,null)

            //화면을 다이얼로그빌드에 세트
            vlist4dialog.setView(v4)

            //다이얼로그 빌드 실행
            vlist4dialog.show()
        }

        //카테고리버튼 클릭 이벤트 함수
        dialog.dialog_material_choicbutton.setOnClickListener {

            //다이얼로그 빌드 생성
            val choicedialog= AlertDialog.Builder(dialog.context)

            //화면 연결
            var choicebutton = dialog.layoutInflater.inflate(R.layout.item_dialog_refrigerator_category,null)

            //화면을 다이얼로그빌드에 세트
            choicedialog.setView(choicebutton)

            //다이얼로그 빌드 실행
            choicedialog.show()
        }
    }

    interface OnDialogClickListener
    {
        fun onClicked(name: String)
    }
}