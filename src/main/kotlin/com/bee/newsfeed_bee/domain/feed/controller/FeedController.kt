package com.bee.newsfeed_bee.domain.feed.controller

import com.bee.newsfeed_bee.domain.feed.dto.FeedCreateRequest
import com.bee.newsfeed_bee.domain.feed.dto.FeedResponse
import com.bee.newsfeed_bee.domain.feed.dto.FeedUpdateRequest
import com.bee.newsfeed_bee.domain.feed.service.FeedService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction.DESC
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val feedService: FeedService
) {

    @GetMapping
    fun getFeedList(
        @RequestParam(name = "page", required = false, defaultValue = "0") pageNumber: Int
    ): ResponseEntity<Page<FeedResponse>> {

        return PageRequest.of(pageNumber, DEFAULT_FEED_PAGE_SIZE, Sort.by(DESC, DEFAULT_FEED_SORT_PROPERTY))
            .let { feedService.getFeedList(it) }
            .let {
                ResponseEntity
                    .status(HttpStatus.OK)
                    .body(it)
            }
    }

    @GetMapping("/{feedId}")
    fun getFeed(@PathVariable feedId: Long): ResponseEntity<FeedResponse> {
        
        return feedService.getFeed(feedId)
            .let {
                ResponseEntity
                    .status(HttpStatus.OK)
                    .body(it)
            }
    }

    @PostMapping
    fun createFeed(
        @Valid @RequestBody feedCreateRequest: FeedCreateRequest
    ): ResponseEntity<FeedResponse> {

        return feedService.createFeed(feedCreateRequest)
            .let {
                ResponseEntity
                    .status(HttpStatus.OK)
                    .body(it)
            }
    }

    @PutMapping("/{feedId}")
    fun updateFeed(
        @PathVariable feedId: Long,
        @Valid @RequestBody feedUpdateRequest: FeedUpdateRequest
    ): ResponseEntity<FeedResponse> {

        return feedService.updateFeed(feedId, feedUpdateRequest)
            .let {
                ResponseEntity
                    .status(HttpStatus.OK)
                    .body(it)
            }
    }

    @DeleteMapping("/{feedId}")
    fun deleteFeed(@PathVariable feedId: Long): ResponseEntity<Unit> {

        return feedService.deleteFeed(feedId)
            .let {
                ResponseEntity
                    .status(HttpStatus.OK)
                    .build()
            }
    }

    companion object {
        const val DEFAULT_FEED_PAGE_SIZE = 10
        const val DEFAULT_FEED_SORT_PROPERTY = "createdDateTime"
    }
}
