package com.example.video_player_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class VideoShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_show)

        if (savedInstanceState == null) {
            // Get data from the intent
            val intent = intent
            val songName = intent.getStringExtra("Song_name")
            val link = intent.getStringExtra("Link")
            val genre = intent.getStringExtra("Genre")
            val lyrics = intent.getStringExtra("Lyrics")

            // Create Bundle for Fragment1
            val fragment1Bundle = Bundle().apply {
                putString("Link", link)
            }

            // Create Bundle for Fragment2
            val fragment2Bundle = Bundle().apply {
                putString("Song_name", songName)
                putString("Link", link)
                putString("Genre", genre)
                putString("Lyrics", lyrics)
            }

            // Create Fragment1 and set its arguments
            val fragment1 =TopFragment().apply {
                arguments = fragment1Bundle
            }

            // Create Fragment2 and set its arguments
            val fragment2 = BottomFragment().apply {
                arguments = fragment2Bundle
            }

            // Begin transaction to replace fragments
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_top, fragment1)
            transaction.replace(R.id.fragment_bottom, fragment2)
            transaction.commit()
        }
    }
}
