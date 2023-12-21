package com.example.veggiehealth.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.veggiehealth.MainActivity
import com.example.veggiehealth.ViewModelFactory
import com.example.veggiehealth.data.pref.UserModel
import com.example.veggiehealth.databinding.ActivityLoginBinding
import com.example.veggiehealth.di.ResultState
import com.example.veggiehealth.textfield.EmailText
import com.example.veggiehealth.textfield.PasswordText
import com.example.veggiehealth.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private val viewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginAction()

        binding.tvSignUp.setOnClickListener {
            val signUpIntent  = Intent(this, RegisterActivity::class.java)
            startActivity(signUpIntent)
        }



        supportActionBar?.hide()
    }
    private fun loginAction() {
        binding.buttonLogin.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            viewModel.login(email, password).observe(this) { response ->
                if (response != null){
                    when (response) {
                        is ResultState.Loading -> {
                            showLoading(true)
                        }
                        is ResultState.Success -> {
                            showLoading(false)
                            showToast(response.data.message.toString())
                            val token = response.data.token
                            viewModel.saveSession(UserModel(email, token.toString()))
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                        }
                        is ResultState.Error -> {
                            showLoading(false)
                            AlertDialog.Builder(this).apply {
                                setTitle("Login Failed")
                                setMessage(response.error)
                                setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                                create()
                                show()
                            }
                        }
                    }
                }
            }
        }
    }
    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}