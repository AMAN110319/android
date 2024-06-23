package com.example.video_player_app

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val context: Context, private val viewModel: MainViewModel,private var data:MutableList<Video>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title:TextView= itemView.findViewById(R.id.title)
        val description:TextView=itemView.findViewById(R.id.description)
        val addToFav :ImageView =itemView.findViewById(R.id.addToFav)
        val layout:LinearLayout=itemView.findViewById(R.id.mylayout)
    }
//    val listfrag=ListFragment()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.video_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = data[position]

        // Bind data to views
        holder.title.text = video.songName
        holder.description.text = video.genre

        // Set click listener for the entire item view
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, VideoShowActivity::class.java).apply {
                putExtra("Song_name", video.songName)
                putExtra("Link", video.link)
                putExtra("Genre", video.genre)
                putExtra("Lyrics", video.lyrics)
            }
            holder.itemView.context.startActivity(intent)
        }

        when(video.genre.lowercase()){
            "happy" -> holder.layout.setBackgroundColor(Color.parseColor("#F05454"))
            "sad" -> holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
            "romantic" -> holder.layout.setBackgroundColor(Color.parseColor("#00917C"))
            else-> holder.layout.setBackgroundColor(Color.parseColor("#00917C"))
        }



        // Set long click listener to show a preview dialog
        holder.itemView.setOnLongClickListener {
            showPreviewDialog(video)
            true
        }

        // Set click listener for addToFav ImageView
        holder.addToFav.setOnClickListener {
            video.isFav = true // Toggle isFav value
            notifyItemChanged(position) // Update UI for this item

            // Update ViewModel or perform any other necessary actions
            viewModel.update(video)
        }

        // Update addToFav ImageView based on isFav value
        if (video.isFav) {
            holder.addToFav.setImageResource(R.drawable.baseline_favorite_24) // Use favorite icon
            holder.addToFav.setColorFilter(ContextCompat.getColor(context, R.color.red), PorterDuff.Mode.SRC_IN)
        } else {
            holder.addToFav.setImageResource(R.drawable.baseline_favorite_24) // Use default icon
            holder.addToFav.setColorFilter(ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_IN)
        }
    }


    fun getItemAt(position: Int): Video? {
        return if (position >= 0 && position < data.size) {
            data[position]
        } else {
            null
        }
    }
    fun updateItem(position: Int) {
        val video = getItemAt(position)
        if (video != null) {
            // Create a dialog
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.dialog_add_video)
            dialog.show()

            // Find and set the dialog elements
            val btn = dialog.findViewById<Button>(R.id.buttonAdd)
            btn.text = "Update"
            val changeTitle = dialog.findViewById<TextView>(R.id.title_update)
            changeTitle.text = "Update Video"

            val editTextTitle = dialog.findViewById<EditText>(R.id.editTextTitle)
            val editTextUrl = dialog.findViewById<EditText>(R.id.editTextUrl)
            val editTextDescription = dialog.findViewById<EditText>(R.id.editTextDescription)
            val editTextCategory = dialog.findViewById<EditText>(R.id.editTextCategory)

            // Pre-fill the EditText fields with the current video data
            editTextTitle.setText(video.songName)
            editTextUrl.setText(video.link)
            editTextDescription.setText(video.lyrics)
            editTextCategory.setText(video.genre)

            // Handle the update button click
            btn.setOnClickListener {
                // Update the video object with new values
                video.songName= editTextTitle.text.toString()
                video.link = editTextUrl.text.toString()
                video.lyrics = editTextDescription.text.toString()
                video.genre = editTextCategory.text.toString()


                viewModel.update(video)


                // Notify the adapter about the item update
                notifyItemChanged(position)
                dialog.dismiss()
                Toast.makeText(context, "Video updated successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun deleteItem(position: Int) {
        val video=getItemAt(position)
        if(video!=null) {
            viewModel.delete(video)
            data.removeAt(position)
            notifyItemRemoved(position)
            Toast.makeText(context, "Item deleted at :$position", Toast.LENGTH_LONG).show()
        }
    }



    private fun showPreviewDialog(video: Video) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_preview, null)
        val previewBanner = dialogView.findViewById<ImageView>(R.id.preview_banner)
        val previewTitle = dialogView.findViewById<TextView>(R.id.preview_title)
        val previewGenre = dialogView.findViewById<TextView>(R.id.preview_genre)
        val previewLyrics = dialogView.findViewById<TextView>(R.id.preview_lyrics)

        // Set the values for the preview
        previewTitle.text = video.songName
        previewGenre.text = video.genre
        previewLyrics.text = video.lyrics

        // Load the banner image if available (you may use libraries like Glide or Picasso)
        // For example, using Glide:
        // Glide.with(context).load(video.bannerUrl).into(previewBanner)

        // Create and show the dialog
        val dialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .setCancelable(true)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .create()

        dialog.show()
    }


}