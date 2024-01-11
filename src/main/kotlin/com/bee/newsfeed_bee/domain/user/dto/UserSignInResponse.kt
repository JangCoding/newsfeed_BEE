package com.bee.newsfeed_bee.domain.user.dto

import java.time.OffsetDateTime

data class UserSignInResponse (
    val email : String,
    var nickname : String,
    val createdAt : OffsetDateTime
)