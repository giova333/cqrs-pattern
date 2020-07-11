package com.gladunalexander.overview

data class CommentAddedEvent(
        val id: String?,
        val postId: Long,
        val username: String,
        val text: String
)