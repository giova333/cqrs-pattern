package com.gladunalexander.statisticservice

import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.data.rest.core.annotation.HandleAfterCreate
import org.springframework.data.rest.core.annotation.HandleAfterSave
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.stereotype.Component

@Component
@RepositoryEventHandler
class PostStatisticCalculatedEventHandler(private val streamBridge: StreamBridge) {

    private val bindingName = "statisticCalculatedBinding-out-0"

    @HandleAfterCreate
    @HandleAfterSave
    fun handle(statistic: PostStatistic) =
            streamBridge.send(bindingName, statistic.calculatedEvent())

    private fun PostStatistic.calculatedEvent(): PostStatisticCalculatedEvent =
            PostStatisticCalculatedEvent(postId, viewsNumber, clicksNumber, repostNumber, id)
}