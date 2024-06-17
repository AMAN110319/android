package com.example.tutorial2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//var btn: Button?= null
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 0


        binding.btCount.setOnClickListener{
            count++
            binding.tvCount.text = "Let's count together: $count"
            Log.d("MainActivity", "Count incremented to: $count")
        }
    }


}
