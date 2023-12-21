package com.example.veggiehealth.ui.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.veggiehealth.R
import com.example.veggiehealth.adapter.ViewPagerAdapter
import com.example.veggiehealth.ui.screen.FirstScreenFragment
import com.example.veggiehealth.ui.screen.SecondScreenFragment
import com.example.veggiehealth.ui.screen.ThirdScreenFragment
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        val fragmentList = arrayListOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            supportFragmentManager,
            lifecycle
        )

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = adapter

        val indicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        indicator.attachTo(viewPager)
    }
}