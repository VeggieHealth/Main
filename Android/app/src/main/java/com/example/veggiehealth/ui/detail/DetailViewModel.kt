package com.example.veggiehealth.ui.detail

import androidx.lifecycle.ViewModel
import com.example.veggiehealth.data.UserRepository
class DetailViewModel(private val repository: UserRepository) : ViewModel() {

    fun detailVegetables(id : String) = repository.getDetailSayuran(id)
}