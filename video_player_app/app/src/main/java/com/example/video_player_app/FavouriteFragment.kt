package com.example.video_player_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.video_player_app.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment() {
    private lateinit var binding: FragmentFavouriteBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: FavouriteVideoAdapter
    private var favlist:MutableList<Video> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
//        favRecyclerView = view.findViewById(R.id.favRecyclerView)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        // Initialize the RecyclerView and Adapter
        binding.favRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = FavouriteVideoAdapter(requireContext(),viewModel,favlist)
        binding.favRecyclerView.adapter = adapter

        // Observe the list of favorite videos
        viewModel.getAllVideo().observe(viewLifecycleOwner, Observer { videos ->
            val favoriteVideos = videos.filter { it.isFav }
            adapter.updateList(favoriteVideos)
        })
    }
}
