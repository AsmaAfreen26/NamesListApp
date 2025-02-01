package com.example.nameslistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ViewPagerAdapter(private val images: List<String>): RecyclerView.Adapter<ViewPagerAdapter.ImageViewHolder>() {

    class ImageViewHolder(view:View): RecyclerView.ViewHolder(view) {
       val imageView:ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item,parent,false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
      Glide.with(holder.imageView.context).load(images[position]).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return images.size
    }


}