package com.example.video_player_app

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class FavouriteVideoAdapter(
    private val context: Context,
    private val viewModel: MainViewModel,
    private var favoriteVideos: List<Video>
) : RecyclerView.Adapter<FavouriteVideoAdapter.FavoriteViewHolder>() {

    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val genre: TextView = itemView.findViewById(R.id.description)
        val removeFromFav: ImageView = itemView.findViewById(R.id.removeFromFav)
        val layout: LinearLayout =itemView.findViewById(R.id.mylayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_favourite_video, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val video = favoriteVideos[position]
        holder.title.text = video.songName
        holder.genre.text = video.genre


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, VideoShowActivity::class.java).apply {
                putExtra("Song_name", video.songName)
                putExtra("Link", video.link)
                putExtra("Genre", video.genre)
                putExtra("Lyrics", video.lyrics)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.removeFromFav.setOnClickListener {
            video.isFav = false// Toggle isFav value
            notifyItemChanged(position) // Update UI for this item

            // Update ViewModel or perform any other necessary actions
            viewModel.update(video)
        }

        when(video.genre.lowercase()){
            "happy" -> holder.layout.setBackgroundColor(Color.parseColor("#F05454"))
            "sad" -> holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
            "romantic" -> holder.layout.setBackgroundColor(Color.parseColor("#00917C"))
            else-> holder.layout.setBackgroundColor(Color.parseColor("#00917C"))
        }

        holder.itemView.setOnLongClickListener {
            showPreviewDialog(video)
            true
        }

        if (video.isFav) {
            holder.removeFromFav.setImageResource(R.drawable.baseline_favorite_24) // Use favorite icon
            holder.removeFromFav.setColorFilter(ContextCompat.getColor(context, R.color.red), PorterDuff.Mode.SRC_IN)
        } else {
            holder.removeFromFav.setImageResource(R.drawable.baseline_favorite_24) // Use default icon
            holder.removeFromFav.setColorFilter(ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_IN)
        }
    }

    override fun getItemCount(): Int {
        return favoriteVideos.size
    }

    fun updateList(newVideos: List<Video>) {
        favoriteVideos = newVideos
        notifyDataSetChanged()
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
