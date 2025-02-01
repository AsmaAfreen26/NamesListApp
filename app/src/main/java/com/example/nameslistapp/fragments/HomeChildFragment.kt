package com.example.nameslistapp.fragments

import com.example.nameslistapp.R
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.nameslistapp.ListAdapter
import androidx.navigation.fragment.findNavController
import com.example.nameslistapp.ListItem
import com.example.nameslistapp.SharedViewModel


class HomeChildFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var adapter: ListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_child, container, false)
        val listView: ListView = view.findViewById(R.id.listView)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        adapter = ListAdapter(requireContext(), emptyList()) { item ->
        showPopup(item)
    }
//            findNavController().navigate(R.id.action_homeChildFragment_to_detailFragment)
        listView.adapter = adapter


        viewModel.listItems.observe(viewLifecycleOwner) { items ->
            adapter.updateData(items)

        }
        return view
    }

    private fun showPopup(item: ListItem) {
        val popupView = LayoutInflater.from(requireContext()).inflate(R.layout.popup_item, null)

        val popupWindow = PopupWindow(
            popupView,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            true
        )
        val imageView: ImageView = popupView.findViewById(R.id.imageItem)
        val textView: TextView = popupView.findViewById(R.id.textItem)
        val button: Button = popupView.findViewById(R.id.button)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
            popupWindow.dismiss()
            }
        textView.text = item.name
        Glide.with(requireContext()).load(item.imageUrl).circleCrop().into(imageView)

        popupWindow.showAtLocation(requireView(), Gravity.CENTER_VERTICAL, 0, 0)
        val decorView = requireActivity().window.decorView
        decorView.alpha = 0.5f
        popupWindow.setOnDismissListener { decorView.alpha = 1.0f }
    }

}

