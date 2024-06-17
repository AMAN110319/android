package com.example.todo_app_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TO_DO")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val priority:String
)