package com.bee.newsfeed_bee.feed.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Feed(
    val userId: Long, // TODO: User entity는 별도로 작업하고 있으므로 추후 User entity merge 시 변경할 것
    val createdDateTime: LocalDateTime,
    var storeName: String, // store
    var category: String, // cuisineType? // enum // store
    var address: String, // store
    var score: Int,
    var visitedDateTime: LocalDateTime,
    var waited: Boolean,
    var storeSize: Long, // enum
    var content: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
