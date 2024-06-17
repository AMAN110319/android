package com.example.todo_app_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Entity::class], version = 1)
//class extending room database
abstract class myDatabase: RoomDatabase(){
    abstract fun dao():Dao

    companion object {
        @Volatile
        private var INSTANCE: myDatabase? = null

        fun getDatabase(context: Context): myDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    myDatabase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}