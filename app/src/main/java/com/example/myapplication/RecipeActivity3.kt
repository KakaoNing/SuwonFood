package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.util.*


class RecipeActivity3 : AppCompatActivity() {
    private val apiKey = "a0b0314639de4e13bbbb"
    private val address =
        "https://openapi.foodsafetykorea.go.kr/api/" + apiKey + "/COOKRCP01/json/2/6/"
    private var btnData: Button? = null
    private var recyclerview: RecyclerView? = null
    private val adapter: RecyclerAdapter = RecyclerAdapter() // adapter 생성
    private val list: ArrayList<Data> = ArrayList<Data>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cookbook_get)
        btnData = findViewById(R.id.btnData)
        recyclerview = findViewById(R.id.cookbook_import_recommendation_recyclerview)

        // RecyclerView
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview!!.setLayoutManager(linearLayoutManager)
        // recyclerview에 adapter 적용
        recyclerview!!.setAdapter(adapter)


        // 데이터 불러오기 버튼 클릭
        btnData!!.setOnClickListener(View.OnClickListener {


            object : Thread() {
                override fun run() {
                    try {
                        val url = URL(address)
                        val `is` = url.openStream()
                        val isr = InputStreamReader(`is`)
                        val reader = BufferedReader(isr)
                        val buffer = StringBuffer()
                        var line = reader.readLine()
                        while (line != null) {
                            buffer.append(
                                """
                                    $line
                                    
                                    """.trimIndent()
                            )
                            line = reader.readLine()
                        }
                        val jsonData = buffer.toString()

                        // jsonData를 먼저 JSONObject 형태로 바꾼다.
                        val obj = JSONObject(jsonData)

                        // obj의 "boxOfficeResult"의 JSONObject를 추출
                        val boxOfficeResult = obj["row"] as JSONObject

                        // boxOfficeResult의 JSONObject에서 "dailyBoxOfficeList"의 JSONArray 추출
                        val dailyBoxOfficeList = boxOfficeResult["row"] as JSONArray
                        runOnUiThread {
                            try {

                                // dailyBoxOfficeList의 length만큼 for문 반복
                                for (i in 0 until dailyBoxOfficeList.length()) {
                                    // dailyBoxOfficeList를 각 JSONObject 형태로 객체를 생성한다.
                                    val temp = dailyBoxOfficeList.getJSONObject(i)
                                    // list의 json 값들을 넣는다.
                                    list.add(
                                        Data(
                                            temp.getString("RCP_NM"),
                                            temp.getString("RCP_PARTS_DTLS"),
                                            temp.getString("RCP_WAY2")
                                        )
                                    )
                                }
                                // adapter에 적용
                                adapter.setmovieList(list)
                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }
                        }
                    } catch (e: MalformedURLException) {
                        e.printStackTrace()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }.start()
        })
    }
}