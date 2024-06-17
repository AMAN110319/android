package com.example.coroutines_tutorial_2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import com.example.coroutines_tutorial_2.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    suspend fun doNetworkCall():String{
//        delay(3000L)
//        return "successfully connected"
//    }
    val TAG="aman"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.Main){
            delay(1000L)
        }

//        this blocks the main thread --->
//   this will be in sync of the main thread and we want the main thread to wait for some secs
//this runblocking helps to call suspend functions from inside
        Log.d(TAG, "started")
        runBlocking {
            Log.d(TAG, "inside")
            delay(5000)
            Log.d(TAG, "coming out")
        }
        Log.d(TAG, "out")

//        GlobalScope.launch(newSingleThreadContext("My thread")){
//
//        }

//        to do network call in one thread and change it to the other

//
//        GlobalScope.launch(Dispatchers.IO){
//            val answer=doNetworkCall()
//            //so we can switch the context to the main dispatcher
//            withContext(Dispatchers.Main){
//                binding.tvDummy.setText(answer)
//            }
//        }
    }
}