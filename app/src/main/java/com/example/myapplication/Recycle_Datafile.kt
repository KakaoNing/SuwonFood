package com.example.myapplication

import android.graphics.drawable.Drawable
import java.util.jar.Attributes

//cook notice image의 데이터
data class cook_recycle_image_data(


    val profile : Int,
    val name : String,
    val img : String,
    val title : String


)

data class free_recycle_letter_data(
    val profile  : Int,
    val title : String

)

data class qna_recycle_letter_data(

    val profile : Int,
    val title : String
)
