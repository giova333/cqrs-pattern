package com.gladunalexander.overview

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Post(
        @Id
        val id: Long,
        val text: String,
        val username: String,
        var comments: MutableList<Comment> = mutableListOf(),
        var statistic: Statistic? = null) {

        fun addComment(comment: Comment) =
                comments.add(comment)
}

data class Comment(
        val id: String,
        val username: String,
        val text: String
)

data class Statistic(
        val viewsNumber: Long,
        val clicksNumber: Long,
        val repostNumber: Long,
        val id: Long
)

