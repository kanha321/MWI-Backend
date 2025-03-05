package com.kanhaji.mwibackend.entity

data class CommentData(
    var commentId: String,
    var videoId: String,
    var userId: String,
    var comment: String,
    var time: Long,
    var likes: Int,
    var dislikes: Int,
)
