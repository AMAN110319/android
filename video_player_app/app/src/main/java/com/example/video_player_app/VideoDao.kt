package com.example.video_player_app

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface VideoDao {

    @Query("SELECT * from video")
    fun getVideos(): LiveData<List<Video>>

    @Insert
    suspend fun insertVideo(video: Video)

    @Delete
    suspend fun deleteVideo(video: Video) // Delete a single video

    @Query("DELETE FROM video WHERE id = :videoId")
    suspend fun deleteVideoById(videoId: Long): Int // Delete a video by its ID (returns number of rows deleted)

    @Query("DELETE FROM video")
    suspend fun deleteAllVideos(): Int // Delete all videos (returns number of rows deleted)

    @Query("SELECT * FROM video WHERE id = :videoId")
    fun getVideoById(videoId: Long): LiveData<Video> // Read a single video by ID

    @Update
    suspend fun updateVideo(video: Video) // Update an existing video
}
