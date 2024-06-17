package com.example.couroutines_tutorial_1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val TAG="aman"


    suspend fun doNetworkCall():String{
        delay(3000L)
        return "successfully connected"
    }
    suspend fun doNetworkCall2():String{
        delay(3000L)
        return "successfully connected"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


//        to start the coroutines --> globalscope means that this couroutines will live as long as this application does live
        GlobalScope.launch {
            delay(3000L)  //to make the coroutines sleep for the x amount of seconds
            Log.d(TAG, "coroutines says hello from thread ${Thread.currentThread().name}")

            Log.d(TAG, doNetworkCall())
            Log.d(TAG, doNetworkCall2())

        }

        Log.d(TAG, " hello from thread ${Thread.currentThread().name}")
    }
}