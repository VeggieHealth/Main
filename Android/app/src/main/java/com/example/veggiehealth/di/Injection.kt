package com.example.veggiehealth.di

import android.content.Context
import com.example.veggiehealth.data.UserRepository
import com.example.veggiehealth.data.pref.UserPreference
import com.example.veggiehealth.data.pref.dataStore
import com.example.veggiehealth.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return UserRepository.getInstance(pref, apiService)
    }
}