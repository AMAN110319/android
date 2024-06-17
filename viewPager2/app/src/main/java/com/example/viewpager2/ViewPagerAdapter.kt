package com.example.viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    val images:List<Int>
): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>(){

    inner class ViewPagerHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var image:ImageView =itemView.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {

       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return ViewPagerHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        var curImage=images[position]
        holder.image.setImageResource(curImage)

    }
}