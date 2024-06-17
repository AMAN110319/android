package com.example.quotes_app

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context:Context):ViewModel(){

    private  var quoteList:Array<Quote> = emptyArray()

    private var index=0

    init {
        quoteList= loadQuotesFromAsset()
    }

    private fun loadQuotesFromAsset():Array<Quote>{
        val inputStream=context.assets.open("quotes.json")
        val size:Int=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8) //getting a string
        val gson= Gson() //  parse that string into json object
        return gson.fromJson(json,Array<Quote>::class.java) //returning that array to the file
    }

    fun getQuote()= quoteList[index]


    fun nextQuote() = if(index==quoteList.size-1) quoteList[index] else quoteList[++index]
    fun prevQuote() = if(index==0) quoteList[index] else quoteList[--index]
}