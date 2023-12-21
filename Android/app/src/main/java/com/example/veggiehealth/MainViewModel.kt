package com.example.veggiehealth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.veggiehealth.data.UserRepository
import com.example.veggiehealth.data.pref.UserModel

class MainViewModel(private val repository: UserRepository):ViewModel() {

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

}