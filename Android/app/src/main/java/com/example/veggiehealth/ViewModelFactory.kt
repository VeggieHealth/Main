package com.example.veggiehealth

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.veggiehealth.data.UserRepository
import com.example.veggiehealth.di.Injection
import com.example.veggiehealth.ui.camera.PredictViewModel
import com.example.veggiehealth.ui.detail.DetailViewModel
import com.example.veggiehealth.ui.list.ListViewModel
import com.example.veggiehealth.ui.login.LoginViewModel
import com.example.veggiehealth.ui.person.ProfileViewModel
import com.example.veggiehealth.ui.register.RegisterViewModel

class ViewModelFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ListViewModel::class.java) -> {
                ListViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(repository) as T
            }
            modelClass.isAssignableFrom(PredictViewModel::class.java) -> {
                PredictViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
    companion object {
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {

            return ViewModelFactory(Injection.provideRepository(context))
        }
    }
}