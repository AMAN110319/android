package com.example.todolist

import android.icu.text.CaseMap.Title

data class Todo(
    val title: String,
    var isChecked:Boolean=false
)