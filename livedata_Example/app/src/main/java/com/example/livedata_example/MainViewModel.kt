package com.example.livedata_example

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel(){
    val factslivedata=MutableLiveData<String>("this is a fact")

    fun updateLiveData(){
        factslivedata.value="another fact"
    }
}