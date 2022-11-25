package com.example.myapplication.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Dialog_Refrigerator
import com.example.myapplication.RecyclerRefrigeratorSourceAdapter
import com.example.myapplication.databinding.FragmentHomeLeftBinding
import com.example.myapplication.databinding.ItemRefrigeratorSourceRecycleBinding
import com.example.myapplication.refrigerator_source_recycle_data
import kotlinx.android.synthetic.main.fragment_home_left.*

//홈 화면중 왼쪽에 해당하는 냉장고에 대한 DialogFragment이다.
class home_left : Fragment() {
    //초기 변수 선언 refrigerator_Data_Array는 데이터를 담는 그릇이고
    //refrigerator_recyclerViewGroup1은 냉동, refrigerator_recyclerViewGroup2는 냉장이다.
    val refrigerator_Data_Array:ArrayList<refrigerator_source_recycle_data> = java.util.ArrayList()
    lateinit var refrigerator_recyclerViewGroup1:RecyclerView
    lateinit var refrigerator_recyclerViewGroup2:RecyclerView
    private lateinit var binding : FragmentHomeLeftBinding
    private lateinit var buttonbinding:ItemRefrigeratorSourceRecycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeLeftBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //아이템에 데이터들을 저장시킨다.(냉장고 재료 데이터)
        //refrigerator_source_recycle_data은 Recycle_Datafile에 있는 data class이다.
        val items1  = arrayListOf(
            refrigerator_source_recycle_data("고기류"),
            refrigerator_source_recycle_data("소스류"),
            refrigerator_source_recycle_data("아이스크림"),
            refrigerator_source_recycle_data("김치"),
            refrigerator_source_recycle_data("해산물"),
            refrigerator_source_recycle_data("카테고리")
        )
        val items2  = arrayListOf(
            refrigerator_source_recycle_data("고기류"),
            refrigerator_source_recycle_data("유제품"),
            refrigerator_source_recycle_data("마시는거"),
            refrigerator_source_recycle_data("소스"),
            refrigerator_source_recycle_data("기본재료"),
            refrigerator_source_recycle_data("카테고리")

        )
        //54~61줄은 refigerator_vlist1(냉동 리사이클러뷰)에 대한 설정이다.
        //refigerator_vlist1의 형태를 정의한다. VERTICAL은 세로방향의 리사이클러를 설정한다.
        refigerator_vlist1.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        /*refigerator_vlist1.setHasFixedSize(true)*/

        //refigerator_vlist1의 어뎁터에 RecyclerRefrigeratorSourceAdapter의 어뎁터를 연결하고 items에 저장되어 있는 정보도 연결한다.
        refigerator_vlist1.adapter = RecyclerRefrigeratorSourceAdapter(items1)

        //63~71줄은 refigerator_vlist2(냉장 리사이클러뷰)에 대한 설정이다.
        //refigerator_vlist2의 형태를 정의한다. VERTICAL은 세로방향의 리사이클러를 설정한다.
        refigerator_vlist2.layoutManager=
            LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        /*refigerator_vlist2.setHasFixedSize(true)*/

        //refigerator_vlist2의 어뎁터에 RecyclerRefrigeratorSourceAdapter의 어뎁터를 연결하고 items에 저장되어 있는 정보도 연결한다.
        refigerator_vlist2.adapter= RecyclerRefrigeratorSourceAdapter(items2)

    }
}