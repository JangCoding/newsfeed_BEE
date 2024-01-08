package com.bee.newsfeed_bee.feed.dto

import java.time.LocalDateTime

data class FeedResponse( // TODO API 명세와 프로퍼티 순서 다름
    val id: Long, // TODO - 피드 번호를 내려줄 필요가 있을까?
    val userNickname: Long, // TODO API 명세와 다른 부분 - 명세에 없음 // 내려줄 때는 userId 제외하고 nickname만 내려줄 것인지?
    val createdDateTime: LocalDateTime,
    val storeName: String, // TODO: 수정 가능한 속성에 대해서는 더 논의할 필요가 있음
    val category: String,
    val address: String,
    val score: Int,
    val visitedDateTime: LocalDateTime,
    val waited: Boolean,
    val storeSize: Long,
    val content: String,
)
