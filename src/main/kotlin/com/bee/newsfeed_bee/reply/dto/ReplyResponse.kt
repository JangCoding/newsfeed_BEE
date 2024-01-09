package com.bee.newsfeed_bee.reply.dto

import jakarta.persistence.JoinColumn
import java.time.LocalDate
import java.time.LocalDateTime

data class ReplyResponse (
    val id:Long,
    val userName : String,
    val content : String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)