package com.example.tutorial5

import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnOrder.setOnClickListener {
            val checkedMeatRadioButtonId = binding.Meat.checkedRadioButtonId
            val meat=findViewById<RadioButton>(checkedMeatRadioButtonId)
            val cheese=binding.cheese.isChecked
            val onions=binding.onions.isChecked
            val salad=binding.salad.isChecked

            val orderString ="You ordered a burger with : \n"+"${meat.text} "+ (if(cheese) "\n $cheese" else "") +(if(onions) "\n $onions" else "")+(if(salad) "\n $salad" else "")

            binding.display.text=orderString;
        }

    }
}