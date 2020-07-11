package com.gladunalexander.overview

import org.springframework.data.mongodb.repository.MongoRepository

interface PostRepository : MongoRepository<Post, Long> {
}