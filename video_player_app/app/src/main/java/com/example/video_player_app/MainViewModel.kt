package com.example.video_player_app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val videoRepository: VideoRepository, application: Application) :AndroidViewModel(application) {
    private val _videos = MutableLiveData<List<Video>>()
    val videos:LiveData<List<Video>> get()= _videos
    fun getAllVideo():LiveData<List<Video>> {
        return videoRepository.getVideos()
    }



    fun insert(video: Video) {
        viewModelScope.launch {
            videoRepository.insertVideo(video)
        }
    }

    fun delete(video: Video) {
        viewModelScope.launch {
            videoRepository.deleteVideo(video)
        }
    }

    fun deleteById(videoId: Long) {
        viewModelScope.launch {
            videoRepository.deleteVideoById(videoId)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            videoRepository.deleteAllVideos()
        }
    }

    fun getVideoById(videoId: Long): LiveData<Video> {
        return videoRepository.getVideoById(videoId)
    }

    fun update(video: Video) {
        viewModelScope.launch {
            videoRepository.updateVideo(video)
        }
    }
}
