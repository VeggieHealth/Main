package com.example.veggiehealth.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.veggiehealth.R
import com.example.veggiehealth.ui.onboarding.OnBoardingActivity


class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splash : ImageView = findViewById(R.id.splashImage)
        splash.alpha = 0f
        splash.animate().setDuration(DURATION_ANIMATION).alpha(ALPHA_VAL).withEndAction{
            val i = Intent(this, OnBoardingActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
        supportActionBar?.hide()
    }

    companion object {
        private const val DURATION_ANIMATION = 3000L
        private const val  ALPHA_VAL = 1f
    }
}