package com.example.todo_app_database

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title)
        var priority: TextView = itemView.findViewById(R.id.priority)
        var layout: LinearLayout = itemView.findViewById(R.id.mylayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardInfo = data[position]

        // Set the background color based on priority
        when (cardInfo.priority.lowercase()) {
            "high" -> holder.layout.setBackgroundColor(Color.parseColor("#F05454"))
            "medium" -> holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#00917C"))
        }

        // Bind data to the view holder
        holder.title.text = cardInfo.title
        holder.priority.text = "Priority - ${cardInfo.priority.replaceFirstChar { it.uppercase() }}"

        animate(holder.itemView, position)

        // Set click listener for itemView to navigate to UpdateCard activity
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateCard::class.java).apply {
                putExtra("id", position)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    private fun animate(view: View, position: Int) {
        // Clear any existing animation
        view.clearAnimation()

        // Load the slide-in animation
        val slideIn = AnimationUtils.loadAnimation(view.context, android.R.anim.slide_in_left)
        view.startAnimation(slideIn)
    }
}
