package com.example.tutorials3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorials3.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val firstNumber=binding.textView.text.toString().toInt();
            val secondNumber=binding.textView2.text.toString().toInt();
            val result = firstNumber+secondNumber;
            binding.textView3.text= result.toString();
        }


    }
}