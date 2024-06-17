package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val todoList: MutableList<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val tvTodoTitle: TextView = itemView.findViewById(R.id.tvTodoTitle)
        val cbDone: CheckBox = itemView.findViewById(R.id.cbDone)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
//        we assign this parameter to be false because if it attach directly it could cause app to crash
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.tvTodoTitle.text = todo.title
        holder.cbDone.isChecked = todo.isChecked
        holder.cbDone.setOnCheckedChangeListener { _, isChecked ->
            todo.isChecked = isChecked
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun addTodoItem(todo: Todo) {
        todoList.add(todo)
        notifyItemInserted(todoList.size - 1)
    }

    fun deleteTodoItems() {
        todoList.removeAll { it.isChecked }
        notifyDataSetChanged()
    }
}
