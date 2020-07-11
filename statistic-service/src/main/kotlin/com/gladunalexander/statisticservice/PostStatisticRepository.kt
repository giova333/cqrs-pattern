package com.gladunalexander.statisticservice

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "statistic", path = "statistic")
interface PostStatisticRepository : JpaRepository<PostStatistic, Long> {

    fun findByPostId(postId: Long): PostStatistic

}