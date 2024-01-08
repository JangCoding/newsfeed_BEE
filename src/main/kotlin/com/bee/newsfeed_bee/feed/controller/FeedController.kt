package com.bee.newsfeed_bee.feed.controller

import com.bee.newsfeed_bee.feed.dto.FeedCreateRequest
import com.bee.newsfeed_bee.feed.dto.FeedResponse
import com.bee.newsfeed_bee.feed.dto.FeedUpdateRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/feeds")
@RestController
class FeedController {

    @GetMapping
    fun getFeedList(): ResponseEntity<List<FeedResponse>> {

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(listOf())
    }

    @GetMapping("/{feedId}")
    fun getFeed(@PathVariable feedId: Long): ResponseEntity<FeedResponse> {

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(FeedResponse())
    }

    @PostMapping
    fun createFeed(@RequestBody feedCreateRequest: FeedCreateRequest): ResponseEntity<FeedResponse> {

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(FeedResponse())
    }

    @PutMapping("/{feedId}")
    fun updateFeed(
        @PathVariable feedId: Long,
        @RequestBody feedUpdateRequest: FeedUpdateRequest
    ): ResponseEntity<FeedResponse> {

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(FeedResponse())
    }

    @DeleteMapping("/{feedId}")
    fun deleteFeed(@PathVariable feedId: Long): ResponseEntity<Unit> {

        return ResponseEntity
            .status(HttpStatus.OK)
            .build()
    }
}
