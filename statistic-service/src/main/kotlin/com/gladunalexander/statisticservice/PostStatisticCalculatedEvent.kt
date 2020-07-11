package com.gladunalexander.statisticservice

data class PostStatisticCalculatedEvent(
        val postId: Long,
        val viewsNumber: Long,
        val clicksNumber: Long,
        val repostNumber: Long,
        val id: Long?
)