package com.bee.newsfeed_bee.domain.reply.dto

import java.time.OffsetDateTime

data class ReplyResponse (
    val id:Long,
    val userName : String,
    val contents : String,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime?
)