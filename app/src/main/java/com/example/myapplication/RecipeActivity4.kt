package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.util.*


class RecipeActivity4 : AppCompatActivity() {
    var apiKey = "a0b0314639de4e13bbbb"
    var listView: ListView? = null
    var adapter: ArrayAdapter<*>? = null
    var items = ArrayList<String?>()
    var data: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe4)
        listView = findViewById(R.id.listview)
        adapter = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, items as List<Any?>)
        listView!!.setAdapter(adapter)
    }

    fun mOnClick(v: View) {
        when (v.id) {
            R.id.button ->
                Thread {

                    data = xmlData //아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기

                }.start()
        }
    }

    private val xmlData: String

        get() {
            var buffer = StringBuffer()
            val adress =
                ("https://openapi.foodsafetykorea.go.kr/api/" + apiKey + "/COOKRCP01/xml/1/50/")

            try {
                //URL객체생성
                val url = URL(adress)

                //Stream 열기
                val `is` = url.openStream() //바이트스트림
                //문자스트림으로 변환
                val isr = InputStreamReader(`is`)

                //읽어들인 XML문서를 분석(parse)해주는 객체 생성
                val factory = XmlPullParserFactory.newInstance()
                val xpp = factory.newPullParser()
                xpp.setInput(isr)

                //xpp를 이용해서 xml문서를 분석


                var eventType = xpp.eventType
                var tagName: String
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    when (eventType) {
                        XmlPullParser.START_DOCUMENT -> buffer.append("\n")
                        XmlPullParser.START_TAG -> {
                            tagName = xpp.name
                            if (tagName == "RCP_NM"); else if (tagName == "RCP_PAT2") {
                                buffer.append("category:")
                                xpp.next()
                                buffer.append(
                                    xpp.text)
                                buffer.append("\n")

//
                            } else if (tagName == "RCP_PARTS_DTLS") {
                                buffer.append("이름:")
                                xpp.next()
                                buffer.append(
                                    xpp.text)

                            }
                        }
                        XmlPullParser.TEXT -> {}
                        XmlPullParser.END_TAG -> {
                            tagName = xpp.name
                            if (tagName == "RCP_NM") {
                                items.add(buffer.toString())

                                //리스트뷰 갱신
                                runOnUiThread { adapter!!.notifyDataSetChanged() }
                            }
                        }
                    }
                    eventType = xpp.next()
                   ;
                } //while ..

            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: XmlPullParserException) {
                e.printStackTrace()
            }
            return buffer.toString()
        }
}

