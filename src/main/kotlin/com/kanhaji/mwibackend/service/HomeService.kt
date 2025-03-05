package com.kanhaji.mwibackend.service

import com.kanhaji.mwibackend.entity.VideoData
import com.kanhaji.mwibackend.repository.VideoRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class HomeService {

    @Autowired
    private lateinit var videoRepo: VideoRepo

    fun getVideos() = videoRepo.findAll()

    fun addVideo(videoData: VideoData) {
        val videoToSave = videoData.copy(
            videoId = UUID.randomUUID().toString(),
            uploadTime = System.currentTimeMillis()
        )
        videoRepo.save(videoToSave)
    }

    fun deleteVideo(id: String){
        videoRepo.deleteById(id)
    }

    fun getVideoById(id:String) : VideoData {
        return videoRepo.findById(id).orElse(null)
    }
}