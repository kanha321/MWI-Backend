package com.kanhaji.mwibackend.controller

import com.kanhaji.mwibackend.entity.VideoData
import com.kanhaji.mwibackend.service.HomeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/home")
class HomeController {

    @Autowired
    private lateinit var homeService: HomeService

    @GetMapping("/get-videos")
    fun getVideos(): List<VideoData> {
        return homeService.getVideos()
    }

    @PostMapping("/add-video")
    fun addVideo(@RequestBody videoData: VideoData): VideoData {
        homeService.addVideo(videoData)
        return videoData
    }

    @DeleteMapping("/delete/{id}")
    fun deleteVideo(@PathVariable id: String): ResponseEntity<VideoData> {
        val videoToDelete = homeService.getVideoById(id)
        return if (videoToDelete.isPresent) {
            homeService.deleteVideo(id)
            ResponseEntity(videoToDelete.get(), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/get/{id}")
    fun getVideoById(@PathVariable id: String): ResponseEntity<VideoData> {
        val video = homeService.getVideoById(id)
        return if (video.isPresent) {
            ResponseEntity(video.get(), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @PutMapping("/update/{id}")
    fun updateVideo(@PathVariable id: String, @RequestBody videoData: VideoData): ResponseEntity<VideoData> {
        return homeService.updateVideoData(id, videoData)
    }
}