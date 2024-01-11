package com.bee.newsfeed_bee.domain.feed.repository

import com.bee.newsfeed_bee.domain.feed.entity.CuisineCategory
import com.bee.newsfeed_bee.domain.feed.entity.Feed
import org.springframework.data.domain.Pageable

interface CustomFeedRepository {

    fun findAllByCategoryAddressDeletedDateTime(category: CuisineCategory?, address: String?, pageable: Pageable): List<Feed>
}