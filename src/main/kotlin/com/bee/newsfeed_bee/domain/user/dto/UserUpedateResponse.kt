package com.bee.newsfeed_bee.domain.user.dto

import java.time.OffsetDateTime

data class UserUpedateResponse (
    val createdDateTime: OffsetDateTime,
    var lastModifiedDateTime: OffsetDateTime,
    var deletedDateTime: OffsetDateTime
)
