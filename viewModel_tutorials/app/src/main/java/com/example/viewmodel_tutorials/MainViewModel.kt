package com.example.viewmodel_tutorials

import androidx.lifecycle.ViewModel


//only used to store central data
class MainViewModel(val initialValue:Int): ViewModel(){

    var count=initialValue;
}