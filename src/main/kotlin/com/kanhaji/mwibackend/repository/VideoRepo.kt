package com.kanhaji.mwibackend.repository

import com.kanhaji.mwibackend.entity.VideoData
import org.springframework.data.mongodb.repository.MongoRepository

interface VideoRepo : MongoRepository<VideoData, String>