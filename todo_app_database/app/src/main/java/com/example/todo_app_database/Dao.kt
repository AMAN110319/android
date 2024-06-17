package com.example.todo_app_database

import androidx.room.*
import androidx.room.Dao

//to do these things on the background threads we use couroutines and it is done by writing suspend

@Dao
interface Dao {
    @Insert
    suspend fun insertTask(entity: Entity)

    @Update
    suspend fun updateTask(entity: Entity)

    @Delete
    suspend fun deleteTask(entity: Entity)

    @Query("Delete from TO_DO")
    suspend fun deleteAll()

    @Query("Select * from TO_DO")
    suspend fun getTasks():List<CardInfo>
}
