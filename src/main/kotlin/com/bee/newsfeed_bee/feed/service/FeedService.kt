package com.bee.newsfeed_bee.feed.service

import com.bee.newsfeed_bee.feed.dto.FeedCreateRequest
import com.bee.newsfeed_bee.feed.dto.FeedResponse
import com.bee.newsfeed_bee.feed.dto.FeedUpdateRequest
import com.bee.newsfeed_bee.feed.entity.toResponse
import com.bee.newsfeed_bee.feed.repository.FeedRepository
import org.springframework.stereotype.Service

@Service
class FeedService(
    private val feedRepository: FeedRepository
) {
    fun getFeedList(): List<FeedResponse> {
        return feedRepository.findAll().map { it.toResponse() }
    }

    fun getFeed(feedId: Long): FeedResponse {
        return TODO()
    }

    fun createFeed(feedCreateRequest: FeedCreateRequest): FeedResponse {
        return TODO()
    }

    fun updateFeed(feedId: Long, feedUpdateRequest: FeedUpdateRequest): FeedResponse {
        return TODO()
    }

    fun deleteFeed(feedId: Long): Unit {
        TODO()
    }
}