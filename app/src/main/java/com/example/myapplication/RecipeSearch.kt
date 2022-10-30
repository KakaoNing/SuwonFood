package com.example.myapplication

import android.app.Activity
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import android.view.View
import org.xmlpull.v1.XmlPullParserFactory
import org.xmlpull.v1.XmlPullParser
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import java.net.URLEncoder

class RecipeSearch : Activity() {
    var edit: EditText? = null
    var text: TextView? = null
    var key = "a0b0314639de4e13bbbb"
    var data: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit = findViewById<View>(R.id.edit) as EditText
        text = findViewById<View>(R.id.text) as TextView
    }

    //Button을 클릭했을 때 자동으로 호출되는 callback method
    fun mOnClick(v: View) {
        when (v.id) {
            R.id.button ->
                // 급하게 짜느라 소스가 지저분해요..
                Thread {
                    // TODO Auto-generated method stub
                    data = xmlData //아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기
                    runOnUiThread {
                        // TODO Auto-generated method stub
                        text!!.text = data //TextView에 문자열 data출력
                    }
                }.start()
        }
    }// TODO Auto-generated catch blocke.printStackTrace();


    private val xmlData: String
        get() {
            val buffer = StringBuffer()
            val str = edit!!.text.toString() //EditText에 작성된 Text얻어오기
            val recipe = URLEncoder.encode(str) //한글의 경우 인식이 안되기에 utf-8 방식으로 encoding= //검색 위한 변수
            val queryUrl = ("https://openapi.foodsafetykorea.go.kr/api/" + key + "/COOKRCP01/xml/1/1000/"
                    +"RCP_NM="+recipe) //요청 URL

            try {
                val url = URL(queryUrl) //문자열로 된 요청 url을 URL 객체로 생성.
                val `is` = url.openStream() //url위치로 입력스트림 연결
                val factory = XmlPullParserFactory.newInstance()
                val xpp = factory.newPullParser()
                xpp.setInput(InputStreamReader(`is`, "UTF-8")) //inputstream 으로부터 xml 입력받기
                var tag: String
                xpp.next()
                var eventType = xpp.eventType
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    when (eventType) {
                        XmlPullParser.START_DOCUMENT -> buffer.append("파싱 시작...\n\n")
                        XmlPullParser.START_TAG -> {
                            tag = xpp.name //태그 이름 얻어오기
                            if (tag == "item") ; else if (tag == "RCP_NM") {
                                buffer.append("메뉴명 : ")
                                xpp.next()
                                buffer.append(xpp.text) //addr 요소의 TEXT 읽어와서 문자열버퍼에 추가
                                buffer.append("\n") //줄바꿈 문자 추가
                            } else if (tag == "RCP_PARTS_DTLS") {
                                buffer.append("재료 : ")
                                xpp.next()
                                buffer.append(xpp.text)
                                buffer.append("\n")
                            }
                        }
                        XmlPullParser.TEXT -> {}
                        XmlPullParser.END_TAG -> {
                            tag = xpp.name //태그 이름 얻어오기
                            if (tag == "item") buffer.append("\n") // 첫번째 검색결과종료..줄바꿈
                        }
                    }
                    eventType = xpp.next()
                }
            } catch (e: Exception) {
                // TODO Auto-generated catch blocke.printStackTrace();
            }
            buffer.append("파싱 끝\n")
            return buffer.toString() //StringBuffer 문자열 객체 반환
        }
}