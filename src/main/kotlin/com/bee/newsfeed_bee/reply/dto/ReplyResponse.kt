package com.bee.newsfeed_bee.reply.dto

import jakarta.persistence.JoinColumn
import java.time.LocalDate
import java.time.LocalDateTime

data class ReplyResponse (
    var id:Long,
    var userName : String,
    var content : String,
    var createdAt: LocalDateTime,
    var updated_date_time: LocalDateTime
)