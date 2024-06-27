package com.example.tvfocussratch

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class GridAdapter(private val context: Context, private val dataList: List<Pair<String, Int>>) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataList[position].first

        // Initial background color
        holder.cardView.setCardBackgroundColor(Color.WHITE)

        // Set focus change listener
        holder.cardView.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                holder.cardView.setCardBackgroundColor(Color.BLUE)
                holder.cardView.animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start()
            } else {
                holder.cardView.setCardBackgroundColor(Color.WHITE)
                holder.cardView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start()
            }
        }

        // Set the initial focus
        if (position == 0) {
            holder.cardView.requestFocus()
        }
    }
}
