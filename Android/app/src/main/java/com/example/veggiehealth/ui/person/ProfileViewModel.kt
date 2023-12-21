package com.example.veggiehealth.ui.person

import androidx.lifecycle.ViewModel
import com.example.veggiehealth.data.UserRepository

class ProfileViewModel(private val user: UserRepository): ViewModel() {

    fun getDetailProfile() = user.getDetailUser()

    suspend fun logOut() = user.logout()
}