package com.example.video_player_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.video_player_app.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Initialize data binding
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load the image using Glide
        val imageUrl = "https://media.licdn.com/dms/image/D4D03AQFZFbcHyNy5Qw/profile-displayphoto-shrink_800_800/0/1681542394360?e=1724284800&v=beta&t=aHhemHmI00FDx6PQaLUk00g94cDcMOhDSPT5ZjHYgSE"
        Glide.with(this)
            .load(imageUrl)
            .circleCrop() // Apply circle cropping to the image
            .into(binding.imageView)

        // Set personal information
        binding.apply {
            textViewName.text= "AMAN TIWARI"
            textViewDesignation.text = "Designation: \n \n Software Engineer"
            textViewEmail.text = "Email: \n \n amant@example.com"
            textViewPhone.text = "Phone: \n \n +123 456 7890"
            textViewAddress.text = "Address:  \n \n 123, Sample Street, City, Country"
        }
    }
}
