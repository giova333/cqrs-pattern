package com.gladunalexander.postservice

import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.data.rest.core.annotation.HandleAfterCreate
import org.springframework.data.rest.core.annotation.HandleAfterSave
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.stereotype.Component

@Component
@RepositoryEventHandler
class PostCreatedEventHandler(private val streamBridge: StreamBridge) {

    private val bindingName = "postCreatedBinding-out-0"

    @HandleAfterCreate
    @HandleAfterSave
    fun handle(post: Post) =
            streamBridge.send(bindingName, post.createdEvent())

    private fun Post.createdEvent(): PostCreatedEvent =
            PostCreatedEvent(id, text, username)
}