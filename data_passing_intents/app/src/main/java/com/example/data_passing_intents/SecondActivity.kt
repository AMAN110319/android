package com.example.data_passing_intents

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.data_passing_intents.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

//        val name= intent.getStringExtra("EXTRA_NAME")
//        val age= intent.getIntExtra("EXTRA_AGE",0)
//        val country= intent.getStringExtra("EXTRA_COUNTRY")

        val person =intent.getSerializableExtra("EXTRA_PERSON") as Person
        val personString="${person.name} of ${person.age} years old and lives in ${person.country}"

        binding.textView.text=personString
    }
}