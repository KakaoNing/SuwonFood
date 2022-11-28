package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var mData: ArrayList<Data> = ArrayList<Data>()

    // 아이템 뷰를 저장하는 viewholder 클래스
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView1 // 영화이름
                : TextView
        var textView2 // 누적관객수
                : TextView
        var textView3 // 영화개봉일
                : TextView

        fun onBind(data1: Data) {
            textView1.setText(data1.getRCP_NM())
            textView2.setText(data1.getRCP_PARTS_DTLS())
            textView3.setText(data1.getRCP_WAY2())
        }

        init {
            textView1 = itemView.findViewById(R.id.textView1)
            textView2 = itemView.findViewById(R.id.textView2)
            textView3 = itemView.findViewById(R.id.textView3)
        }
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 return
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(mData[position])
    }

    // 사이즈
    override fun getItemCount(): Int {
        return mData.size
    }

    // data 모델의 객체들을 list에 저장
    @SuppressLint("NotifyDataSetChanged")
    fun setmovieList(list: ArrayList<Data>) {
        mData = list
        notifyDataSetChanged()
    }
}