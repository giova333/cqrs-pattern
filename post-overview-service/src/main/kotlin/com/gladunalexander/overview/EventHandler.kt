package com.gladunalexander.overview

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class EventHandler(private val repository: PostRepository) {

    @Bean
    fun handlePostCreatedEvent(): Consumer<PostCreatedEvent> = Consumer {
        repository.save(Post(it.id, it.text, it.username))
    }

    @Bean
    fun handleCommentAddedEvent(): Consumer<CommentAddedEvent> = Consumer { event ->
        repository.findById(event.postId)
                .map { it.addComment(Comment(event.id, event.username, event.text)); it }
                .map { repository.save(it) }
                .orElseThrow { PostNotFoundException() }
    }

    @Bean
    fun handleStatisticCalculatedEvent(): Consumer<StatisticCalculatedEvent> = Consumer { event ->
        repository.findById(event.postId)
                .map { it.statistic = Statistic(event.viewsNumber, event.clicksNumber, event.repostNumber, event.id); it }
                .map { repository.save(it) }
                .orElseThrow { PostNotFoundException() }
    }

}