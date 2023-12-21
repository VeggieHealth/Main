package com.example.veggiehealth.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veggiehealth.MainActivity
import com.example.veggiehealth.ViewModelFactory
import com.example.veggiehealth.databinding.ActivityVeggieListBinding


class VeggieListActivity : AppCompatActivity() {
    private val viewModel by viewModels<ListViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var binding : ActivityVeggieListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVeggieListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val layoutManager = LinearLayoutManager(this)
        binding.rvFruit.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvFruit.addItemDecoration(itemDecoration)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        supportActionBar?.hide()
        getVegetables()
    }

    private fun getVegetables() {
        val adapter = AdapterListSayuran()
        showLoading(true)
        binding.rvFruit.adapter = adapter.withLoadStateFooter(
            footer = LoadingStateAdapter {
                adapter.retry()
            }
        )

        viewModel.vegetables.observe(this) { pagingData->
            showLoading(false)
            adapter.submitData(lifecycle, pagingData)
        }
    }
    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}