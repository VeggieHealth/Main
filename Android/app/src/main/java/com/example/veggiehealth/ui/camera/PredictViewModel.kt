package com.example.veggiehealth.ui.camera

import androidx.lifecycle.ViewModel
import com.example.veggiehealth.data.UserRepository
import okhttp3.MultipartBody

class PredictViewModel(private val repository: UserRepository): ViewModel() {
    fun predictVegetable(file : MultipartBody.Part) = repository.predictVegetable(file)
}