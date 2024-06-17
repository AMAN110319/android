package com.example.todolist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.rvTodoItems.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter(mutableListOf())
        binding.rvTodoItems.adapter = todoAdapter

        // Set up button listeners
        binding.btnAddtodo.setOnClickListener {
            val todoTitle = binding.edTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle, false)
                todoAdapter.addTodoItem(todo)
                binding.edTodoTitle.text.clear()
            } else {
                Toast.makeText(this, "Please enter a Todo", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnDeleteTodo.setOnClickListener {
            todoAdapter.deleteTodoItems()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
