package com.gladunalexander.overview

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Comment(
        @Id
        var id: String? = null,
        val postId: Long,
        val username: String,
        val text: String
)