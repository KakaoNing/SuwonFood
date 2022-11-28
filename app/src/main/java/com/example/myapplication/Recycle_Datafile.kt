package com.example.myapplication

import android.graphics.drawable.Drawable
import android.net.Uri
import java.net.URI
import java.util.jar.Attributes


//냉장고 재료 데이터
data class refrigerator_source_recycle_data(
    var name:String,
)

//레시피 작성 중 요리재료 리사이클러 데이터
data class recipe_write_Matarialrecycle_data(
    val image: Int,
    val title:String
)

//레시피 작성 중 요리도구 리사이클러 데이터
data class recipe_write_Cookwarerecycle_data(
    val image: Int,
    val title:String
)

//레시피 완료화면 리사이클러 데이터
data class recipe_done_image_recycle_data(
    val image: Int
)

//레시피 조리도구 리사이클러 데이터
data class recipe_cookware_recycle_data(
    val name : String
)

//레시피 재료 리사이클러 데이터
data class recipe_source_recycle_data(

    val name : String,
    val value: String

)

//요리게시판 리사이클러 데이터

//필요한 데이터
//대표 이미지, 레시피 한줄 요약, 레시피 제목, 레시피 내용(ArrayList), 조리도구, 재료, 추가 사진
data class community_cook_recycle_data(
    val profile: String? = "",
    val title : String? = "",
    val name : String? = "",
    val script : String? = "",
    //val tools : String? = "",
    //val ingredients : String? = "",
    //val img_plus : String? = "",
    //val img_plus_2 : String? = "",
    //val img_plus_3 : String? = "",
    //val img_plus_4 : String? = ""
)


//자유게시판 리사이클러 데이터
data class community_free_recycle_data(
    var profile  : Int? = 0,
    var title : String? = "",
    var script : String? = ""
)


// 질문 게시판 리사이클러 데이터
data class community_qna_recycle_data(
    val profile: String? = "",
    val title : String? = "",
    val script : String? = ""
)


// 검색 리사이클 데이터
data class search_recycle_data(
    val profile: Int,
    val name : String,
    val inform : String

)

// 오늘의 레시피 데이터
data class community_today_recipe(
    val profile : Int,
    val name : String,
    val img : Int,
    val title : String
)
// 오늘의 게시글 데이터

data class community_today_notice(
    val profile : Int,
    val title : String
)
