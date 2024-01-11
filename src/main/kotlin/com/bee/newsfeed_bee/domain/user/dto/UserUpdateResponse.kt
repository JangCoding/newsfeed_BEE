package com.bee.newsfeed_bee.domain.user.dto

import java.time.OffsetDateTime

data class UserUpdateResponse(
    val email : String,
    var nikename : String,
    val createdAt : OffsetDateTime,
    val updateAt : OffsetDateTime

)
