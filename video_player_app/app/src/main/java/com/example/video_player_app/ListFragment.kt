package com.example.video_player_app

import SwipeToDeleteCallback
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.video_player_app.databinding.FragmentListBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: RecyclerAdapter
    private var videoList: MutableList<Video> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)



//        creating an observer for the viewModel
        viewModel.getAllVideo().observe(viewLifecycleOwner, Observer { videos ->
            videoList.clear()
            videoList.addAll(videos)
            adapter.notifyDataSetChanged()
        })

        // Initialize RecyclerView
        binding.recycler.layoutManager = LinearLayoutManager(context)
        adapter = RecyclerAdapter(requireContext(),viewModel,videoList)
        binding.recycler.adapter = adapter

        binding.fabAdd.setOnClickListener{
            showAddVideoDialog()
        }




        // Attach swipe functionality to RecyclerView
        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(adapter))
        itemTouchHelper.attachToRecyclerView(binding.recycler)



    }

    private fun showAddVideoDialog() {
        // Inflate the dialog with custom layout
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_video, null)
        val editTextTitle = dialogView.findViewById<EditText>(R.id.editTextTitle)
        val editTextUrl = dialogView.findViewById<EditText>(R.id.editTextUrl)
        val editTextDescription = dialogView.findViewById<EditText>(R.id.editTextDescription)
        val editTextCategory = dialogView.findViewById<EditText>(R.id.editTextCategory)
        val buttonAdd = dialogView.findViewById<Button>(R.id.buttonAdd)

        // Build the dialog
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        // Set the Add button click listener
        buttonAdd.setOnClickListener {
            val title = editTextTitle.text.toString()
            val url = editTextUrl.text.toString()
            val description = editTextDescription.text.toString()
            val category = editTextCategory.text.toString()

            if (title.isNotEmpty() && url.isNotEmpty() && description.isNotEmpty() && category.isNotEmpty()) {
                // Create new video object
                val newVideo = Video(
                    id = videoList.size + 1,  // Assign a new ID
                    songName = title,
                    link= url,
                   lyrics = description,
                    genre = category, isFav =false
                )

                // Add the new video to the list and update the RecyclerView
                videoList.add(newVideo)


                viewModel.insert(Video(0, songName = title,
                    link= url,
                    lyrics = description,
                    genre = category, isFav = false))

                adapter.notifyItemInserted(videoList.size - 1)

                // Dismiss the dialog
                dialog.dismiss()
            } else {
                // Show some error message if fields are empty
                // This could be a toast, or setting error on EditText, etc.
            }
        }

        // Show the dialog
        dialog.show()
    }



}
