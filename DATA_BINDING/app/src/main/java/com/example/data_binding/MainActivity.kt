package com.example.data_binding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.data_binding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //BINDED OUR DATA WITH THE VIEW
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val quoteObj= Quote("do what i say","raju")
        binding.quote = quoteObj

//        binding.quoteText.text="i want to succedd"
//        binding.quoteAuthor.text="ana puna"


    }
}