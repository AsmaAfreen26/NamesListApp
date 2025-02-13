package com.example.nameslistapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nameslistapp.R
import com.example.nameslistapp.SharedViewModel

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {
    override fun onViewCreated(view: android.view.View, savedInstanceState:Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        // Add delay of 3 seconds to show splash screen
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate to Home screen after 3 seconds
            findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
        }, 3000)
    }
}