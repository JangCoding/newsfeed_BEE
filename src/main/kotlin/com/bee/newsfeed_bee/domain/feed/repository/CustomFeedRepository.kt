package com.bee.newsfeed_bee.domain.feed.repository

import com.bee.newsfeed_bee.domain.feed.entity.Feed
import org.springframework.data.domain.Pageable

interface CustomFeedRepository {

    fun findAllByCategoryDongDeletedDateTime(category: String?, address: String?, pageable: Pageable): List<Feed>
}