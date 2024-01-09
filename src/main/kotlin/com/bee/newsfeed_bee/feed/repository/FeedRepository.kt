package com.bee.newsfeed_bee.feed.repository

import com.bee.newsfeed_bee.feed.entity.Feed
import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository: JpaRepository<Feed, Long> {

    fun findAllByDeletedDateTimeIsNull(): List<Feed>

    fun findByIdAndDeletedDateTimeIsNull(id: Long): Feed
}
