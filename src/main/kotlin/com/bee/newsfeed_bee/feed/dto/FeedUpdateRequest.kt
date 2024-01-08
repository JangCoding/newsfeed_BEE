package com.bee.newsfeed_bee.feed.dto

import java.time.LocalDateTime

data class FeedUpdateRequest(
    val id:Long,
    val storeName: String,
    val category: String,
    val address: String,
    val score: Int,
    val visitedDateTime: LocalDateTime,
    val waited: Boolean,
    val storeSize: Long,
    val content: String,
)
