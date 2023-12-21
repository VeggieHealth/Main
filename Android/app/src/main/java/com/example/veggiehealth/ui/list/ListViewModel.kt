package com.example.veggiehealth.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.veggiehealth.data.UserRepository
import com.example.veggiehealth.data.remote.response.VegetablesItem

class ListViewModel(private val repository: UserRepository) : ViewModel() {
    val vegetables: LiveData<PagingData<VegetablesItem>> =
        repository.getlistSayuran().cachedIn(viewModelScope)
}