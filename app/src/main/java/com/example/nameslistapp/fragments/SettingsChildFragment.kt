package com.example.nameslistapp.fragments
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nameslistapp.R

class SettingsChildFragment : Fragment(R.layout.fragment_settings_child) {

    override fun onCreateView(
        inflater: android.view.LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings_child, container, false)
    }

}