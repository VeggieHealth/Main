package com.example.veggiehealth.ui.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.veggiehealth.ui.game.Constants
import com.example.veggiehealth.MainActivity
import com.example.veggiehealth.R
import com.example.veggiehealth.databinding.ActivityResultBinding
import com.example.veggiehealth.ui.game.GameActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        binding.tvScore.text = "Your Score is $correctAnswers out of $totalQuestions."
        when (correctAnswers) {
            in 2..5 -> {
                binding.tvCongratulations.text = "WKWKWK, You Nob!!"
                binding.ivTrophy.setImageResource(R.drawable.emotquiz1)
            }
            in 6..8 -> {
                binding.tvCongratulations.text = "Great job!"
                binding.ivTrophy.setImageResource(R.drawable.emotquiz2)
            }
            in 9..10 -> {
                binding.tvCongratulations.text = "Excellent work!"
                binding.ivTrophy.setImageResource(R.drawable.emotquiz3)
            }
            else -> {
                binding.tvCongratulations.text = "You Very Stupid"
                binding.ivTrophy.setImageResource(R.drawable.emotquizz4)
            }
        }
        Log.d("ResultActivity", "correctAnswers: $correctAnswers")


        binding.buttonFinish.setOnClickListener {
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        binding.buttonReset.setOnClickListener {

            Constants.resetGame()


            val intent = Intent(this@ResultActivity, GameActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}