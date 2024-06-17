package com.example.databinding_with_live_data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    val quoteLiveData=MutableLiveData("what you give is what you get")

    fun updateQuote(){
        quoteLiveData.value="you'll see it when you believe it "
    }
}