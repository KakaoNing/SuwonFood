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
import java.text.SimpleDateFormat
import java.util.*


class RecipeActivity4 : AppCompatActivity() {
    var apiKey = "a0b0314639de4e13bbbb"
    var listView: ListView? = null
    var adapter: ArrayAdapter<*>? = null
    var items = ArrayList<String?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe4)
        listView = findViewById(R.id.listview)
        adapter = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, items as List<Any?>)

        listView!!.setAdapter(adapter)
    }

    fun clickBtn(v: View?) {


        object : Thread() {
            override fun run() {

                items.clear()
                val adress =
                    ("https://openapi.foodsafetykorea.go.kr/api/" + apiKey + "/COOKRCP01/xml/1/10/")



                try {
                    //URL객체생성
                    val url = URL(adress)

                    //Stream 열기                                     //is는 바이트 스트림이라 문자열로 받기위해 isr이 필요하고 isr을 pullparser에게 줘야하는데
                    val `is` = url.openStream() //바이트스트림
                    //문자스트림으로 변환
                    val isr = InputStreamReader(`is`)

                    //읽어들인 XML문서를 분석(parse)해주는 객체 생성    //pullparser를 만들려면 Factory가 필요해서 팩토리 만들고 pullparser를 만들었다. 결론, 그리고 pullparser에게 isr연결
                    val factory = XmlPullParserFactory.newInstance()
                    val xpp = factory.newPullParser()
                    xpp.setInput(isr)

                    //xpp를 이용해서 xml문서를 분석

                    //xpp.next();   //XmlPullParser는 시작부터 문서의 시작점에 있으므로 next해주면 START_DOCUMENT를 못만난다.
                    var eventType = xpp.eventType
                    var tagName: String
                    var buffer: StringBuffer? = null
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        when (eventType) {
                            XmlPullParser.START_DOCUMENT -> runOnUiThread {
                                Toast.makeText(
                                    this@RecipeActivity4,
                                    "파싱을 시작했다.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            XmlPullParser.START_TAG -> {
                                tagName = xpp.name
                                if (tagName == "item") {
                                    buffer = StringBuffer()
                                } else if (tagName == "RCP_NM") {
                                    buffer!!.append("순위:")
                                    xpp.next()
                                    buffer.append(
                                        """
                                            ${xpp.text}
                                            
                                            """.trimIndent()
                                    ) //아래 두줄을 한줄로 줄일 수 있다.
                                    //                                    String text = xpp.getText();
//                                    buffer.append(text+"\n");
                                } else if (tagName == "RCP_PARTS_DTLS") {
                                    buffer!!.append("제목:")
                                    xpp.next()
                                    buffer.append(
                                        """
                                            ${xpp.text}
                                            
                                            """.trimIndent()
                                    )
                                }
                            }
                            XmlPullParser.TEXT -> {}
                            XmlPullParser.END_TAG -> {
                                tagName = xpp.name
                                if (tagName == "item") {
                                    items.add(buffer.toString())

                                    //리스트뷰 갱신
                                    runOnUiThread { adapter!!.notifyDataSetChanged() }
                                }
                            }
                        }
                        eventType = xpp.next()
                        //                        xpp.next();   //두줄을 한줄로 쓸 수 있다.
                        //                        eventType=xpp.getEventType();
                    } //while ..
                    runOnUiThread {
                        Toast.makeText(this@RecipeActivity4, "파싱종료!!", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: MalformedURLException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: XmlPullParserException) {
                    e.printStackTrace()
                }
            } // run() ..
        }.start()
    }
}
