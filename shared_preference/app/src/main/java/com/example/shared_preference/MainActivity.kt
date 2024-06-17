package com.example.shared_preference

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.shared_preference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedref.edit()

        binding.button2.setOnClickListener {
            val name = binding.editTextText.text.toString()
            val age = binding.editTextText2.text.toString().toInt()
            val isAdult = binding.checkBox.isChecked

            editor.apply {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply() // Apply saves the data asynchronously
            }
        }

        binding.button.setOnClickListener {
            val name = sharedref.getString("name", "abc")
            val age = sharedref.getInt("age", 0)
            val isAdult = sharedref.getBoolean("isAdult", false)

            binding.editTextText.setText(name)
            binding.editTextText2.setText(age.toString()) // Convert age to String
            binding.checkBox.isChecked = isAdult
        }
    }
}
