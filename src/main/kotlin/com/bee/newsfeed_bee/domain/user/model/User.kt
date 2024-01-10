package com.bee.newsfeed_bee.domain.user.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.OffsetDateTime

@Entity
class User(
    val createdDateTime: OffsetDateTime,
    var lastModifiedDateTime: OffsetDateTime,
    var deletedDateTime: OffsetDateTime,
    var nickname: String,
    val email: String,
    var password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

