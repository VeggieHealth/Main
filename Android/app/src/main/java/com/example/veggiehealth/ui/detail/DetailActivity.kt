package com.example.veggiehealth.ui.detail

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.veggiehealth.MainActivity
import com.example.veggiehealth.ViewModelFactory
import com.example.veggiehealth.data.remote.response.Vegetable
import com.example.veggiehealth.databinding.ActivityDetailBinding
import com.example.veggiehealth.di.ResultState

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private val viewModel by viewModels<DetailViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extraDetail = intent.getStringExtra(EXTRA_DETAIL) as String

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        viewModel.detailVegetables(extraDetail).observe(this) { vegResult ->
            when (vegResult) {
                is ResultState.Loading -> {
                    showLoading(true)
                }
                is ResultState.Success -> {
                    showLoading(false)
                    val detailVegetable = vegResult.data.vegetable
                    setDetailVegetable(detailVegetable)
                }
                is ResultState.Error -> {
                    showLoading(false)
                    showToast(vegResult.error)
                }
            }
        }
        setupView()
    }


    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setDetailVegetable(detailVegetable: Vegetable) {
        binding.tvKcalDetail.text = detailVegetable.calories + " "+"Kcal"
        binding.tvProteins.text = detailVegetable.protein + "g" + " Pro"
        binding.tvVitamin.text = "Vitamin " + detailVegetable.vitamins
        binding.tvCarbs.text = detailVegetable.carbs + "g" + " Carbs"
        binding.namaTextDetail.text = detailVegetable.name
        binding.tvManfaatDesc.text = detailVegetable.benefits
        Glide.with(binding.root.context)
            .load(detailVegetable.image)
            .into(binding.imageDetailSayuran)

    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRA_DETAIL = "id"
    }
}