package com.bee.newsfeed_bee.feed.entity

import com.bee.newsfeed_bee.util.jpaBaseEntity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Feed( // TODO: 수정 가능한 속성에 대해서는 더 논의할 필요가 있음
    val userId: Long, // TODO: User entity는 별도로 작업하고 있으므로 추후 User entity merge 시 변경할 것
    var deleted: Boolean,
    var deletedDateTime: LocalDateTime?,
    var storeName: String, // store
    var category: String, // cuisineType? // enum // store
    var address: String, // store
    var score: Int,
    var visitedDateTime: LocalDateTime,
    var waited: Boolean,
    var storeSize: Int, // enum
    var content: String,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
