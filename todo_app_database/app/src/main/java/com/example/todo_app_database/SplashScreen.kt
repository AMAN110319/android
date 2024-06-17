package com.example.todo_app_database

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.todo_app_database.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    private lateinit var database:myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = myDatabase.getDatabase(applicationContext)

        GlobalScope.launch {
                DataObject.listdata=database.dao().getTasks() as MutableList<CardInfo>
        }
        // Show the splash screen for 2 seconds-->we create a thread asynchronous programming -->parallel programming
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close the splash screen activity-->it pops it up from the back stack
        }, 2000) // 2000 milliseconds = 2 seconds
    }
}
