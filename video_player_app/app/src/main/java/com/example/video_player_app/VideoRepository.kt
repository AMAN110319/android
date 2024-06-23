package com.example.video_player_app

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoRepository(private val videoDao: VideoDao) {

    // Function to get all videos
    fun getVideos(): LiveData<List<Video>> {
        return videoDao.getVideos()
    }

    // Function to insert a video
    suspend fun insertVideo(video: Video) {
        withContext(Dispatchers.IO) {
            videoDao.insertVideo(video)
        }
    }

    // Function to delete a video
    suspend fun deleteVideo(video: Video) {
        withContext(Dispatchers.IO) {
            videoDao.deleteVideo(video)
        }
    }

    // Function to delete a video by ID
    suspend fun deleteVideoById(videoId: Long): Int {
        return withContext(Dispatchers.IO) {
            videoDao.deleteVideoById(videoId)
        }
    }

    // Function to delete all videos
    suspend fun deleteAllVideos(): Int {
        return withContext(Dispatchers.IO) {
            videoDao.deleteAllVideos()
        }
    }

    // Function to get a video by ID
    fun getVideoById(videoId: Long): LiveData<Video> {
        return videoDao.getVideoById(videoId)
    }

    // Function to update a video
    suspend fun updateVideo(video: Video) {
        withContext(Dispatchers.IO) {
            videoDao.updateVideo(video)
        }
    }
}
