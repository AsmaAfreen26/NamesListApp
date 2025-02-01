package com.example.nameslistapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.nameslistapp.R
import com.example.nameslistapp.ViewPagerAdapter

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val buyButton:Button = view.findViewById(R.id.buyButton)
        val emiButton:Button = view.findViewById(R.id.emiButton)
        val viewPager:ViewPager2 = view.findViewById(R.id.viewPager)

        val images = listOf("https://picsum.photos/id/1//200/300",
            "https://picsum.photos/id/2/200/300",
            "https://picsum.photos/id/3//200/300",
            "https://picsum.photos/id/4//200/300",
            "https://picsum.photos/id/5//200/300")

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter
    return view
    }
}