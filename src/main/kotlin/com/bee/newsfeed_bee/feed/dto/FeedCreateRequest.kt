package com.bee.newsfeed_bee.feed.dto

import java.time.LocalDateTime

data class FeedCreateRequest(
    val userId: Long,
    val createdDateTime: LocalDateTime,
    val storeName: String,
    val category: String,
    val address: String,
    val score: Int,
    val visitedDateTime: LocalDateTime,
    val waited: Boolean,
    val storeSize: Long,
    val content: String,
)
