package com.gladunalexander.statisticservice

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class PostStatistic(
        val postId: Long,
        val viewsNumber: Long,
        val clicksNumber: Long,
        val repostNumber: Long,
        @Id @GeneratedValue var id: Long? = null
)