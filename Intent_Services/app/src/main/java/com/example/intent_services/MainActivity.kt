package com.example.intent_services

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.intent_services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.Start.setOnClickListener {
            Intent(this,MyIntentService::class.java).also{
                startService(it)
                binding.textView.text="Service Running"
            }
        }
        binding.Stop.setOnClickListener {
//            MyIntentService.stopService()
            Intent(this,MyIntentService::class.java).also{
                startService(it)
                binding.textView.text="Service Stopped"
            }
        }
        binding.button3.setOnClickListener {
            Intent(this,MyIntentService::class.java).also {
                val dataString=binding.editTextText.text.toString()
                it.putExtra("EXTRA_DATA",dataString)
                startService(it)
            }
        }
    }
}