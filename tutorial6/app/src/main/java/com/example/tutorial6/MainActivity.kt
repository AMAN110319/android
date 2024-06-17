package com.example.tutorial6

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.button.setOnClickListener {
//            need to pass the  context and message
//            Toast.makeText(this,"hi this is me aman",Toast.LENGTH_LONG).show()
            val inflater =layoutInflater
            val layout =inflater.inflate(R.layout.custom_toast,
                binding.root as ViewGroup, false)

            Toast(this).apply {
                duration=Toast.LENGTH_LONG
                view=layout
                show()
            }
        }
        }
    }
