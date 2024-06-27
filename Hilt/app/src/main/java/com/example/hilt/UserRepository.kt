package com.example.hilt

import android.util.Log
import javax.inject.Inject

const val TAG="AMAN"
class UserReopsitory @Inject constructor() {

    fun saveuser(email:String,password:String){
        Log.d(TAG, "user saved in DB: ")
    }
}