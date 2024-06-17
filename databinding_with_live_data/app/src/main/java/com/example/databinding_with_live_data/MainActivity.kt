package com.example.databinding_with_live_data

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databinding_with_live_data.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)


//        mainViewModel.quoteLiveData.observe(this, Observer{
//            binding.text.text=it
//        })

        binding.lifecycleOwner=this



        binding.mainViewModel=mainViewModel
//        binding.btn.setOnClickListener {
//            mainViewModel.updateQuote()
//        }

    }
}