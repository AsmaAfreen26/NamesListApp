package com.example.nameslistapp.fragments


import com.example.nameslistapp.R
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.bumptech.glide.Glide
import com.example.nameslistapp.ListAdapter
import com.example.nameslistapp.ListItem
import com.example.nameslistapp.SharedViewModel

class SearchChildFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search_child, container, false)
        viewModel =
            ViewModelProvider(requireContext() as ViewModelStoreOwner).get(SharedViewModel::class.java)

        val searchView: SearchView = view.findViewById(R.id.searchView)
        val matchingListView: ListView = view.findViewById(R.id.matchingListView)

        adapter = ListAdapter(requireContext(), emptyList())
        { item ->
            showPopup(item)
        }
        matchingListView.adapter = adapter

        viewModel.filteredItems.observe(viewLifecycleOwner) { items ->
            adapter.updateData(items)
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.filterItems(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { viewModel.filterItems(it) }

                return true
            }
        })
        return view
    }

    private fun showPopup(item: ListItem) {
        val popupView = LayoutInflater.from(requireContext()).inflate(R.layout.popup_item,null)

        val imageView: ImageView = popupView.findViewById(R.id.imageItem)
        val textView: TextView = popupView.findViewById(R.id.textItem)

        textView.text = item.name
        Glide.with(requireContext()).load(item.imageUrl).circleCrop().into(imageView)

        val popupWindow = PopupWindow(
            popupView,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            true
        )
        popupWindow.showAtLocation(view, Gravity.CENTER_VERTICAL,0,0)
        val decorView = requireActivity().window.decorView
        decorView.alpha = 0.5f
        popupWindow.setOnDismissListener { decorView.alpha = 1.0f }
    }

}