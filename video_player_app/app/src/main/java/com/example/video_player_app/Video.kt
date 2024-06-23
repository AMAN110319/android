package com.example.video_player_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "video")
class Video(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var songName: String,
    var link:String,
    var lyrics:String,
    var genre:String,
    var isFav:Boolean
    )