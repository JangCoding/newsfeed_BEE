package com.bee.newsfeed_bee.domain.feed.service

import com.bee.newsfeed_bee.domain.feed.dto.FeedCreateRequest
import com.bee.newsfeed_bee.domain.feed.dto.FeedResponse
import com.bee.newsfeed_bee.domain.feed.dto.FeedUpdateRequest
import com.bee.newsfeed_bee.domain.feed.entity.toEntity
import com.bee.newsfeed_bee.domain.feed.entity.toResponse
import com.bee.newsfeed_bee.domain.feed.entity.updateFrom
import com.bee.newsfeed_bee.domain.feed.repository.FeedRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Service
class FeedService(
    private val feedRepository: FeedRepository
) {
    fun getFeedList(pageable: Pageable): Page<FeedResponse> {
        return feedRepository.findAll(pageable).map { it.toResponse() }
    }

    fun getFeed(feedId: Long): FeedResponse {
        return feedRepository.findByIdAndDeletedDateTimeIsNull(feedId).toResponse() // TODO EmptyResultDataAccessException 처리
    }

    fun createFeed(feedCreateRequest: FeedCreateRequest): FeedResponse {
        return feedCreateRequest.toEntity()
            .let { feedRepository.save(it) }.toResponse()
    }

    @Transactional
    fun updateFeed(feedId: Long, feedUpdateRequest: FeedUpdateRequest): FeedResponse {
        return feedRepository.findByIdAndDeletedDateTimeIsNull(feedId) // TODO EmptyResultDataAccessException 처리
            .updateFrom(feedUpdateRequest)
            .toResponse()
    }

    @Transactional
    fun deleteFeed(feedId: Long): Unit {
        val feed = feedRepository.findByIdAndDeletedDateTimeIsNull(feedId) // TODO EmptyResultDataAccessException 처리
        feed.deletedDateTime = OffsetDateTime.now()
        feedRepository.save(feed)
    }

//    companion object {
//        val feedPageSize = 6
//    }
}
