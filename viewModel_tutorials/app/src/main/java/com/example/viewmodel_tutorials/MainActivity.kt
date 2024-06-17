package com.example.viewmodel_tutorials

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_tutorials.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

// created an object of our viewModel -->normal viewModel
//        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
//        this is parameterised viewmodel
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(10)).get(MainViewModel::class.java)

        enableEdgeToEdge()
        setContentView(binding.root)

//        this is the flow of data
        binding.textView.text= mainViewModel.count.toString()

        binding.increment.setOnClickListener {
            mainViewModel.count=mainViewModel.count+1;
            binding.textView.text= mainViewModel.count.toString()
        }
    }
}