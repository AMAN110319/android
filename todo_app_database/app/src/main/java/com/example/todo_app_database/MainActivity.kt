package com.example.todo_app_database

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.todo_app_database.CreateCard
import com.example.todo_app_database.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


//entity -- table

//dao--> queries

//database

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database:myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        database = Room.databaseBuilder(applicationContext,myDatabase::class.java,"TO_DO").build()

        binding.add.setOnClickListener {
            val intent = Intent(this,CreateCard::class.java)
            startActivity(intent)
        }
        binding.deleteAll.setOnClickListener {
            DataObject.deleteAll()
            GlobalScope.launch {
                database.dao().deleteAll()
            }
            setRecycler()
        }
        setRecycler()
    }

    fun setRecycler(){
        binding.recyclerView.adapter=Adapter(DataObject.getAllData())
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
    }
}