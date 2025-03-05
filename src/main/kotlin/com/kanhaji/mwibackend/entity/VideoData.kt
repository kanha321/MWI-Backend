package com.kanhaji.mwibackend.entity

import org.springframework.data.annotation.Id
import java.util.UUID

data class VideoData(

    @Id
    var videoId: String = UUID.randomUUID().toString(),
    var title: String,
    var description: String,
    var videoUrl: String,
    var thumbnailUrl: String,
    var uploaderId: String,
    var visibility: String = "public",
    var uploadTime: Long = System.currentTimeMillis(),
    var duration: Int,
    var views: Int = 0,
    var likes: Int = 0,
    var dislikes: Int = 0,
    var category: String,
    var tags: List<String> = emptyList(),
    var nsfw: Boolean = false,
    var commentsEnabled: Boolean = true,
    var comments: List<CommentData> = emptyList(),
    var followersOnly: Boolean = false
)
