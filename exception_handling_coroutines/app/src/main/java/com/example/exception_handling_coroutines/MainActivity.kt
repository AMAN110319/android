package com.example.exception_handling_coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    val TAG="aman"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        an exAPMPLE OF THAT THIS IS CANCELLABLE IN NATURE BY DEFAULT
        runBlocking {
            Log.d(TAG, "main program running on ${Thread.currentThread().name}")

            val job= launch(Dispatchers.Default){
                try {
                    for(i in 0..500){
                        print("$i.")
                        delay(5)
                    }
                }catch(e:CancellationException){
                    Log.d(TAG, "SOme exception occurred ${e}")
                }

            }

            delay(10)
            job.cancelAndJoin()
        }

    }
}