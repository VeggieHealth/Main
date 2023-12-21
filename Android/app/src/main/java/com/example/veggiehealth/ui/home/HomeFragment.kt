package com.example.veggiehealth.ui.home

import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.veggiehealth.R
import com.example.veggiehealth.ViewModelFactory
import com.example.veggiehealth.data.remote.response.UserProfile
import com.example.veggiehealth.databinding.FragmentHomeBinding
import com.example.veggiehealth.di.ResultState
import com.example.veggiehealth.ui.camera.CameraActivity
import com.example.veggiehealth.ui.list.VeggieListActivity
import com.example.veggiehealth.ui.game.GameActivity
import com.example.veggiehealth.ui.person.ProfileViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val profileViewModel: ProfileViewModel by viewModels {
        ViewModelFactory.getInstance(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateTimeOfDayGreeting()
        val parentActivity = activity

        binding.cvScan.setOnClickListener {
            val intent = Intent(parentActivity, CameraActivity::class.java)
            startActivity(intent)
        }
        binding.btnListHome.setOnClickListener {
            val intent = Intent(parentActivity, VeggieListActivity::class.java)
            startActivity(intent)
        }
        binding.cvQuiz.setOnClickListener {
            val intent = Intent(parentActivity, GameActivity::class.java)
            startActivity(intent)
        }
        profileViewModel.getDetailProfile().observe(viewLifecycleOwner) { profileResult ->
            when (profileResult) {

                is ResultState.Success -> {
                    val userData = profileResult.data.userProfile
                    getDetailuser(userData)
                }

                is ResultState.Error -> {
                    showToast(profileResult.error)
                }
                else -> Unit
            }
        }
    }
    private fun updateTimeOfDayGreeting() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)

        val greetingText = when (hour) {
            in 6..11 -> "Good Morning"
            in 12..17 -> "Good Afternoon"
            in 18..23 -> "Good Evening"
            in 0..5 -> "Good Night"
            else -> "Hello"
        }


        binding.tvWelcomeHome.text = greetingText
    }

    private fun getDetailuser(user: UserProfile) {
        binding.tvNamaHome.text = user.userProfile
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}