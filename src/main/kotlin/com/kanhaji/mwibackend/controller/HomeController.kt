package com.kanhaji.mwibackend.controller

import com.kanhaji.mwibackend.entity.VideoData
import com.kanhaji.mwibackend.service.HomeService
import org.springframework.beans.factory.annotation.Autowired
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
    fun addVideo(@RequestBody videoData: VideoData) : VideoData {
        homeService.addVideo(videoData)
        return videoData
    }

    @DeleteMapping("/delete/{id}")
    fun deleteVideo(@PathVariable id: String) : VideoData {
        val videoToDelete = homeService.getVideoById(id)
        homeService.deleteVideo(id)
        return videoToDelete
    }

    @GetMapping("/get/{id}")
    fun getVideoById(@PathVariable id: String) : VideoData {
        return homeService.getVideoById(id)
    }
}