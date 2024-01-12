package com.bee.newsfeed_bee.domain.feed.entity

import com.bee.newsfeed_bee.domain.feed.dto.FeedCreateRequest
import com.bee.newsfeed_bee.domain.feed.dto.FeedResponse
import com.bee.newsfeed_bee.domain.feed.dto.FeedUpdateRequest
import com.bee.newsfeed_bee.util.jpaBaseEntity.BaseEntity
import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
class Feed( // TODO: 수정 가능한 속성에 대해서는 더 논의할 필요가 있음
    var deletedDateTime: OffsetDateTime?,
    val userId: Long, // TODO: User entity는 별도로 작업하고 있으므로 추후 User entity merge 시 변경할 것
    var storeName: String,
    @Convert(converter = CuisineCategoryConverter::class) var category: CuisineCategory,
    var address: String,
    var score: Int,
    var visitedDateTime: OffsetDateTime,
    var waited: Boolean,
    var storeSize: Int, // enum?
    var content: String,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Feed.toResponse(): FeedResponse {
    return FeedResponse(
        id = this.id!!,
        userNickname = "TODO",
        createdDateTime = this.createdDateTime,
        lastModifiedDateTime = this.lastModifiedDateTime,
        storeName = this.storeName,
        category = this.category,
        address = this.address,
        score = this.score,
        visitedDateTime = this.visitedDateTime,
        waited = this.waited,
        storeSize = this.storeSize,
        content = this.content,
        )
}

fun Feed.updateFrom(request: FeedUpdateRequest): Feed {
    this.storeName = request.storeName
    this.category = request.category
    this.address = request.address
    this.score = request.score
    this.visitedDateTime = request.visitedDateTime
    this.waited = request.waited
    this.storeSize = request.storeSize
    this.content = request.content

    return this
}

fun FeedCreateRequest.toEntity(): Feed {
    return Feed(
        deletedDateTime = null,
        userId = 0, // TODO 현재 인증 관련 부분이 추가되지 않았기 때문에 임시로만 넣어둠
        storeName = this.storeName,
        category = this.category,
        address = this.address,
        score = this.score,
        visitedDateTime = this.visitedDateTime,
        waited = this.waited,
        storeSize = this.storeSize,
        content = this.content,
    )
}
