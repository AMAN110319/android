package com.example.data_passing_intents

import java.io.Serializable

//the only purpose of this class is to hold the data
data class Person (
    val name:String,
    val age:Int,
    val country:String
):Serializable

//make it serialisable because to parse the object passing between data