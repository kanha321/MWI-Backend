package com.kanhaji.mwibackend.service

import com.kanhaji.mwibackend.entity.VideoData
import com.kanhaji.mwibackend.repository.VideoRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

    fun getVideoById(id:String) : Optional<VideoData> {
        return videoRepo.findById(id)
    }

    fun updateVideoData(id: String, videoData: VideoData): ResponseEntity<VideoData> {
        val videoToUpdate = videoRepo.findById(id)
        return if (videoToUpdate.isPresent) {
            val video = videoToUpdate.get()
            val updatedVideo = video.copy(
                title = videoData.title,
                description = videoData.description,
                videoUrl = videoData.videoUrl,
                thumbnailUrl = videoData.thumbnailUrl,
                visibility = videoData.visibility,
                duration = videoData.duration,
                category = videoData.category,
                tags = videoData.tags,
                nsfw = videoData.nsfw,
                commentsEnabled = videoData.commentsEnabled,
                followersOnly = videoData.followersOnly
            )
            videoRepo.save(updatedVideo)
            ResponseEntity(updatedVideo, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
        /*
        following json i have to give in postman to update video
        {
            "title": "updated title",
            "description": "updated description",
            "videoUrl": "updated videoUrl",
            "thumbnailUrl": "updated thumbnailUrl",
            "visibility": "updated visibility",
            "duration": 100,
            "category": "updated category",
            "tags": ["updated tag1", "updated tag2"],
            "nsfw": true,
            "commentsEnabled": false,
            "followersOnly": true
        }

         */
    }
}