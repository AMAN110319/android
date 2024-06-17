package com.example.intents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intents.databinding.ActivitySecondBinding

class SecondActivity :AppCompatActivity(){
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            finish()  //this kills the current activity
        }

        binding.buttonNext.setOnClickListener {
            Intent(this,thirdActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}