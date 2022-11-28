package com.example.myapplication.Home

//import com.example.myapplication.Cookbook.Write.Cookbook_Create_Cooking_Utensils
//import com.example.myapplication.Cookbook.Write.Cookbook_Create_Material
//import com.example.myapplication.Other.Home_Middle_ViewPager2adapter
//import com.example.myapplication.Recipe.RecipeActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.Home_Middle_ViewPager2adapter
import com.example.myapplication.R
import com.example.myapplication.home_middle_recipe2
import com.example.myapplication.home_middle_recipe3
import kotlinx.android.synthetic.main.base_main_layout.*
import kotlinx.android.synthetic.main.fragment_home_middle.*
import kotlinx.android.synthetic.main.fragment_home_middle_recipe.*

// 홈 화면중 가운데에 해당하는 추천화면에 대한 Fragment이다.
class home_middle : Fragment() {

    private val MIN_SCALE = 0.85f // 뷰가 몇퍼센트로 줄어들 것인지
    private val MIN_ALPHA = 0.5f

    /*
    //인스턴스 초기화
    init{
        instance = this
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    //private val sliderImageRunnable = Runnable { home_recipe_viewpager2.currentItem = home_recipe_viewpager2.currentItem + 1 }

        /* 여백, 너비에 대한 정의 */

    }
    /*companion object {
        private var instance: home_middle? = null
        fun getInstance(): home_middle?{
            //인스턴스 리턴
            return instance
        }
    }*/


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home_middle,container,false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        //pagerAdapter어뎁터 선언(Home_Middle_ViewPager2adapter)
        val pagerAdapter= Home_Middle_ViewPager2adapter(requireActivity())

        //pagerAdapter어뎁터에 레시피 프래그먼트를 추가
        pagerAdapter.addFragment(Home_Middle_Recipe())
        pagerAdapter.addFragment(home_middle_recipe2())
        pagerAdapter.addFragment(home_middle_recipe3())


        //어뎁터를 홈페이저의 어뎁터에 복사
        home_recipe_viewpager2.adapter=pagerAdapter

        //처음 뷰페이저2 화면 설정(0= 맨위)
        home_recipe_viewpager2.setCurrentItem(0, false)

        //뷰페이저2 방향 설정 ORIENTATION_VERTICAL=세로방향
        home_recipe_viewpager2.orientation=ViewPager2.ORIENTATION_VERTICAL




        home_recipe_viewpager2.offscreenPageLimit = 2 // 몇 개의 페이지를 미리 로드 해둘것인지

        //뷰페이저 애니메이션 설정
        home_recipe_viewpager2.setPageTransformer(ZoomOutPageTransformer())





    }
    //뷰페이저 애니메이션 설정 클래스
    inner class ZoomOutPageTransformer : ViewPager2.PageTransformer {
        override fun transformPage(view: View, position: Float) {
            view.apply {
                val pageWidth = width
                val pageHeight = height
                val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen 파일 안에 크기를 정의해두었다.
                val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimen 파일이 없으면 생성해야함
                val screenWidth = resources.displayMetrics.heightPixels // 스마트폰의 높이 길이를 가져옴
                val offsetPx = screenWidth - pageMarginPx - pagerWidth

                    //home_recipe_viewpager2.setPageTransformer { page, position -> page.translationY = position * -offsetPx}




                when {

                    position < -1 -> { // [-Infinity,-1)
                        // This page is way off-screen to the left.
                        alpha = 0f

                    }

                    position <= 1 ->{
                        val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))

                        //val vertMargin = pageHeight * (1 - scaleFactor) / 2
                        //val horzMargin = pageWidth * (1 - scaleFactor) / 2

                        /*  (변경시 X축 변경)
                        translationX = if (position < 0) {
                            horzMargin - vertMargin / 2

                        } else {

                            horzMargin + vertMargin / 2
                        }*/
                        //Y축설정 공식홈피 정보 (안씀)
                        //scaleY = scaleFactor

                        scaleX = scaleFactor
                        //내가사용하는 코드
                        translationY = position * -offsetPx

                        alpha = (MIN_ALPHA +
                                (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))


                    }

                    /*
                    position <= 1 -> { // [-1,1]
                        // Modify the default slide transition to shrink the page as well
                        val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                        val vertMargin = pageHeight * (1 - scaleFactor) / 2
                        val horzMargin = pageWidth * (1 - scaleFactor) / 2
                        translationX = if (position < 0) {
                            horzMargin - vertMargin / 2

                        } else {

                            horzMargin + vertMargin / 2
                        }

                        // Scale the page down (between MIN_SCALE and 1)
                        scaleX = scaleFactor
                        scaleY = scaleFactor

                        // Fade the page relative to its size.
                        alpha = (MIN_ALPHA +
                                (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                    }*/

                    else -> { // (1,+Infinity]

                        // This page is way off-screen to the right.
                        alpha = 0f
                    }
                }

            }
        }
}}