package com.example.quotes_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private val quoteText:TextView
        get()=findViewById(R.id.quoteText)
    private val quoteAuthor:TextView
        get()= findViewById(R.id.quoteAuthor)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mainViewModel=ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
        setQuotes(mainViewModel.getQuote())
    }

    fun setQuotes(quote: Quote){
        quoteText.text=quote.text
        quoteAuthor.text=quote.author
    }

    fun onPrevious(view: View) {
        setQuotes(mainViewModel.prevQuote())
    }
    fun onNext(view: View) {
        setQuotes(mainViewModel.nextQuote())
    }

    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,mainViewModel.getQuote().text)
        startActivity(intent)
    }
}