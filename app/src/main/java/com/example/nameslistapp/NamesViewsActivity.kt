package com.example.nameslistapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.nameslistapp.fragments.SearchChildFragment
import com.example.nameslistapp.fragments.HomeChildFragment

class NamesViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_names_views)


        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_search_container, SearchChildFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_home_container, HomeChildFragment())
            .commit()

    }
}