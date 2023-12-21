package com.example.veggiehealth.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.veggiehealth.data.UserRepository
import com.example.veggiehealth.data.pref.UserModel
import com.example.veggiehealth.data.remote.response.LoginResponse
import com.example.veggiehealth.di.ResultState
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    fun saveSession(user:UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }
    fun login(email: String, password: String) = liveData {
        emit(ResultState.Loading)
        try {
            val message = repository.login(email, password)
            emit(ResultState.Success(message))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
            emit(ResultState.Error(errorResponse.message!!))
        }
    }
}