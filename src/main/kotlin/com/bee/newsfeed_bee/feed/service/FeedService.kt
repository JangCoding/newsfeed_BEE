package com.bee.newsfeed_bee.feed.service

import com.bee.newsfeed_bee.feed.dto.FeedCreateRequest
import com.bee.newsfeed_bee.feed.dto.FeedResponse
import com.bee.newsfeed_bee.feed.dto.FeedUpdateRequest
import com.bee.newsfeed_bee.feed.entity.toEntity
import com.bee.newsfeed_bee.feed.entity.toResponse
import com.bee.newsfeed_bee.feed.entity.updateFrom
import com.bee.newsfeed_bee.feed.repository.FeedRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Service
class FeedService(
    private val feedRepository: FeedRepository
) {
    fun getFeedList(): List<FeedResponse> {
        return feedRepository.findAll().map { it.toResponse() }
    }

    fun getFeed(feedId: Long): FeedResponse {
        return feedRepository.findByIdOrNull(feedId)?.toResponse()
            ?: throw IllegalArgumentException("id에 해당하는 Feed가 존재하지 않습니다.")
    }

    fun createFeed(feedCreateRequest: FeedCreateRequest): FeedResponse {
        return feedCreateRequest.toEntity()
            .let { feedRepository.save(it) }.toResponse()
    }

    @Transactional
    fun updateFeed(feedId: Long, feedUpdateRequest: FeedUpdateRequest): FeedResponse {
        return feedRepository.findByIdOrNull(feedId)
            .let { it?.updateFrom(feedUpdateRequest) ?: throw IllegalArgumentException("id에 해당하는 Feed가 존재하지 않습니다.") }
            .toResponse()
    }

    @Transactional
    fun deleteFeed(feedId: Long): Unit {
        return feedRepository.findByIdOrNull(feedId)
            .let {
                it?.deletedDateTime = OffsetDateTime.now()
                    ?: throw IllegalArgumentException("id에 해당하는 Feed가 존재하지 않습니다.")
            }
    }
}
