package com.example.tutorial1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    this binds the mainactivity.kt to the activity_main file
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnApply.setOnClickListener{
            val firstName = binding.etFirstName.text.toString();
            val lastName =binding.etLastName.text.toString();
            val birthdate=binding.etDob.text.toString();
            val country = binding.etCity.text.toString()

            Log.d("activity", "$firstName $lastName , born on $birthdate and resident of $country is the author")
        }

//        val btnApply=findViewById<Button>(R.id.btnApply)





//        Log.d("activity","onCreate called")
//
//        val list = listOf(5,3,6,7,9,1)
//
//        sortlist(list);
//        println("aman $list")
//        Log.e("Aman", "onCreate: $list ")
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }




    override fun onStart() {
        super.onStart()
        print("i am inside the on start yay")
        // Log a message indicating that onStart is called
        Log.d("activity", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activity","onResume the activity is running")
    }
}