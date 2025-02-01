package com.example.nameslistapp
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import com.bumptech.glide.Glide

class ListAdapter(
    private val context: Context,
    private var items: List<ListItem>,
    private val onItemClicked: (ListItem) -> Unit
): BaseAdapter(){
    override fun getCount(): Int {
        return items.size
    }
    override fun getItem(position: Int): Any? {
        return items[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {

        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val image = view.findViewById<ImageView>(R.id.item_image)
        val textView = view.findViewById<TextView>(R.id.item_text)

        val item = items[position]
        Glide.with(view.context).load(item.imageUrl).circleCrop().into(image)

        textView.text = item.name

        view.setOnClickListener {
            onItemClicked(item)
//            findNavController(it).navigate(R.id.action_homeChildFragment_to_detailFragment)
        }
        return view

    }
    fun updateData(newItems: List<ListItem>) {
        items = newItems
        notifyDataSetChanged()
    }

}