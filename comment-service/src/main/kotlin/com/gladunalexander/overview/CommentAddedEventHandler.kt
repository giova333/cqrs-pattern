package com.gladunalexander.overview

import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.data.rest.core.annotation.HandleAfterCreate
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.stereotype.Component

@Component
@RepositoryEventHandler
class CommentAddedEventHandler(private val streamBridge: StreamBridge) {

    private val bindingName = "commentAddedBinding-out-0"

    @HandleAfterCreate
    fun handle(comment: Comment) =
            streamBridge.send(bindingName, comment.addedEvent())

    private fun Comment.addedEvent(): CommentAddedEvent =
            CommentAddedEvent(id, postId, username, text)
}
