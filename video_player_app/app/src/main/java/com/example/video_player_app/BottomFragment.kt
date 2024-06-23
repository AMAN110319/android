package com.example.video_player_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class BottomFragment : Fragment() {
    private  var title:TextView?=null
    private  var genre:TextView?=null
    private  var lyrics:TextView?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_bottom, container, false)

        title=view.findViewById(R.id.title)
        genre=view.findViewById(R.id.genre)
        lyrics=view.findViewById(R.id.lyrics)

        title?.setText(arguments?.getString("Song_name"))
        genre?.setText(arguments?.getString("Genre"))
        lyrics?.setText(arguments?.getString("Lyrics"))


        return view
    }

}
