package com.example.livedata_example

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    private val factsTextView:TextView
        get()=findViewById(R.id.text_)
    private val button:TextView
        get()=findViewById(R.id.buttonupdate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)


//        live data tabhi data bhejta h jab active state me hote h toh wahi baat h ki
        mainViewModel.factslivedata.observe(this,Observer{
            factsTextView.text=it
        })
        button.setOnClickListener {
            mainViewModel.updateLiveData()
        }
    }
}