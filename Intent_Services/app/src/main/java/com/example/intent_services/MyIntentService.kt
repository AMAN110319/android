package com.example.intent_services

//import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyIntentService : Service() {
    val TAG = "MyService"

    init {
        Log.d(TAG, "Service is running")
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand called")

        val dataString = intent?.getStringExtra("EXTRA_DATA")

        dataString?.let {
            Log.d(TAG, "Data received: $dataString")
        } ?: run {
            Log.d(TAG, "No data received")
        }

        Thread{
            while (true){}
        }.start()



        return START_STICKY
    }
}











//
//init {
//    instance=this
//}
//
//companion object{
//    private lateinit var instance:MyIntentService
//
//    var isRunning=false
//
//    fun stopService(){
//        Log.d("MyIntentService","stopService: ")
//        isRunning=false
//        instance.stopSelf()
//    }
//}
//override fun onHandleIntent(intent: Intent?) {
//
//    try {
//        isRunning=true
//        while (isRunning){
//            Log.d("MyIntentService", "Service is running.......")
//            Thread.sleep(1000)
//        }
//    }
//    catch (e:InterruptedException ){
//        Thread.currentThread().interrupt()
//    }
//}