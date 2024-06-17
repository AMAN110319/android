package com.example.data_passing_intents

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.data_passing_intents.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val name=binding.etName.text.toString();
            val age=binding.etAge.text.toString().toInt();
            val country=binding.etCountry.text.toString();
            val person=Person(name, age, country)
            Intent(this,SecondActivity::class.java).also {
//                it.putExtra("EXTRA_NAME",name);
//                it.putExtra("EXTRA_AGE",age);
//                it.putExtra("EXTRA_COUNTRY",country);
                it.putExtra("EXTRA_PERSON",person)
                startActivity(it)
            }
        }
    }
}