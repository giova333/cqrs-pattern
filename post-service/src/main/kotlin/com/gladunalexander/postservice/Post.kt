package com.gladunalexander.postservice

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Post(
        @Id
        @GeneratedValue
        var id: Long? = null,

        val text: String,

        val username: String
)