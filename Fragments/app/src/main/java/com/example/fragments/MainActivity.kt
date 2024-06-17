package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstfragment = Firstfragment()
        val secondFragment= SecondFragment()

//        because we want to switch between fragments between first and second layout we use
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,firstfragment)
            commit() // to apply the changes need to commit as well
        }

        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,firstfragment)
                addToBackStack(null)
                commit() // to apply the changes need to commit as well
            }
        }
        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,secondFragment)
                addToBackStack(null)
                commit() // to apply the changes need to commit as well
            }
        }


    }
}