package com.example.veggiehealth.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.veggiehealth.data.UserRepository
import com.example.veggiehealth.data.remote.response.RegisterResponse
import com.example.veggiehealth.di.ResultState
import com.google.gson.Gson
import retrofit2.HttpException

class RegisterViewModel(private val repository: UserRepository): ViewModel() {
    fun register(username: String, email: String, password: String) = liveData {
        emit(ResultState.Loading)
        try {
            val message = repository.register(username, email, password)
            emit(ResultState.Success(message))
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, RegisterResponse::class.java)
            emit(errorBody.message?.let { ResultState.Error(it) })
        }
    }
}