package com.example.listview

import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var arrNames:MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

//        we have data and listview
        arrNames.add("aman")
        arrNames.add("sohan")
        arrNames.add("mohan")
        arrNames.add("rohan")
        arrNames.add("dohan")
        arrNames.add("aman")
        arrNames.add("sohan")
        arrNames.add("mohan")
        arrNames.add("rohan")
        arrNames.add("dohan")
        arrNames.add("aman")
        arrNames.add("sohan")
        arrNames.add("mohan")
        arrNames.add("rohan")
        arrNames.add("dohan")
        arrNames.add("aman")
        arrNames.add("sohan")
        arrNames.add("mohan")
        arrNames.add("rohan")
        arrNames.add("dohan")
        arrNames.add("aman")
        arrNames.add("sohan")
        arrNames.add("mohan")
        arrNames.add("rohan")
        arrNames.add("dohan")
        arrNames.add("aman")
        arrNames.add("sohan")
        arrNames.add("mohan")
        arrNames.add("rohan")
        arrNames.add("dohan")


        // ArrayAdapter to bind data
        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, arrNames)

        // Set the adapter to the ListView
        binding.listView.adapter = adapter


//        pos -> gives the index of the item and id-> gives the row id-> necessary in case of the databases accessiung the data
        binding.listView.setOnItemClickListener { adapterView, view, position, id ->
             val clickedView=view as TextView
            clickedView.setTextColor(Color.RED)

                Toast.makeText(this, "Clicked item ${id+ 1}", Toast.LENGTH_LONG).show()
        }

    }
}