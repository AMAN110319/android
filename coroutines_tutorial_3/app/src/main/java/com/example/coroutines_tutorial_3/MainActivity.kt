package com.example.coroutines_tutorial_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout


class MainActivity : AppCompatActivity() {
    val TAG="AMAN"

//    fun fibo(n:Int): Long {
//        if(n==0 || n==1) {
//            return n.toLong();
//        }
//        else{
//            return fibo(n-1)+fibo(n-2)
//        }
//
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


//        getting these views by the id mentioned
        val button:Button= findViewById(R.id.btnStartActivity)


        button.setOnClickListener {
            lifecycleScope.launch {
                while(true){
                    delay(1000L)
                    Log.d(TAG, "Still running....")
                }
            }

            GlobalScope.launch {
                delay(5000L)
                Intent(this@MainActivity,Second_Activity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }


















//        val job=GlobalScope.launch(Dispatchers.Default) {
//            Log.d(TAG, "Starting long running calc.......")
//
//
//
//            withTimeout(1000L) {
//                for (i in 30..40) {
//                    if (isActive) {
//                        Log.d(TAG, "result for i = $i: ${fibo(i)}")
//                    }
//                }
//            }
//
//
//
//
//            Log.d(TAG, "Stopping long running calc.......")
//        }

//        runBlocking {
//            //this will block our thread
////            job.join()
//            delay(2000L)
//            job.cancel()
//            Log.d(TAG, "canceled the job....")
//        }

    }
}