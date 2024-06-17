package com.example.todo_app_database

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.todo_app_database.DataObject
import com.example.todo_app_database.MainActivity
import com.example.todo_app_database.databinding.ActivityUpdateCardBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateCard : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateCardBinding

    private lateinit var database:myDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = myDatabase.getDatabase(applicationContext)

        // Get the position from the intent
        val pos = intent.getIntExtra("id", -1)

        // If position is valid, update the UI with the existing data
        if (pos != -1) {
            val cardInfo = DataObject.getData(pos)
            val title = cardInfo.title
            val priority = cardInfo.priority

            binding.createTitle.setText(title)
            binding.createPriority.setText(priority)

            // Set up delete button
            binding.deleteButton.setOnClickListener {
                DataObject.deleteData(pos)
                GlobalScope.launch {
                    database.dao().deleteTask(
                        Entity(pos+1,title,priority)
                    )
                }
                navigateToMainActivity()
            }

            // Set up update button
            binding.updateButton.setOnClickListener {
                DataObject.updateData(
                    pos,
                    binding.createTitle.text.toString(),
                    binding.createPriority.text.toString()
                )
                Toast.makeText(this, "Updated: $title - $priority", Toast.LENGTH_LONG).show()
                GlobalScope.launch {
                    database.dao().updateTask(
                        Entity(pos+1,binding.createTitle.text.toString(),binding.createPriority.text.toString())
                    )
                }
                navigateToMainActivity()
            }
        } else {
            // Handle the case where the position is invalid
            Toast.makeText(this, "Invalid card position", Toast.LENGTH_SHORT).show()
            finish() // Close the activity if no valid position is passed
        }
    }

    // Navigate back to the main activity
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Close the current activity to prevent returning to it
    }
}
