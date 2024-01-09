package com.bee.newsfeed_bee.feed.controller

import com.bee.newsfeed_bee.feed.dto.FeedCreateRequest
import com.bee.newsfeed_bee.feed.dto.FeedResponse
import com.bee.newsfeed_bee.feed.dto.FeedUpdateRequest
import com.bee.newsfeed_bee.feed.service.FeedService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val feedService: FeedService
) {

    @GetMapping
    fun getFeedList(): ResponseEntity<List<FeedResponse>> {

        return feedService.getFeedList()
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
}
