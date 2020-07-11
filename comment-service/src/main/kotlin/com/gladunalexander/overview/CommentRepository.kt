package com.gladunalexander.overview

import org.springframework.data.mongodb.repository.MongoRepository

interface CommentRepository : MongoRepository<Comment, String> {

    fun findByPostId(postId: Long): List<Comment>

}