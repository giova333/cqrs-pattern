package com.gladunalexander.overview

data class PostCreatedEvent(
        val id: Long,
        val text: String,
        val username: String
)

data class CommentAddedEvent(
        val id: String,
        val postId: Long,
        val username: String,
        val text: String
)

data class StatisticCalculatedEvent(
        val postId: Long,
        val viewsNumber: Long,
        val clicksNumber: Long,
        val repostNumber: Long,
        val id: Long
)