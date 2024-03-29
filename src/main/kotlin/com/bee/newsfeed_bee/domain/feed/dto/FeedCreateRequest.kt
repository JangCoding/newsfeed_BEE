package com.bee.newsfeed_bee.domain.feed.dto

import com.bee.newsfeed_bee.domain.feed.entity.CuisineCategory
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import java.time.OffsetDateTime

data class FeedCreateRequest( // TODO API 명세와 프로퍼티 순서 다름
    @field:NotBlank(message = "storeName은 필수 입력 정보입니다.") val storeName: String,
    val category: CuisineCategory,
    @field:NotBlank(message = "address는 필수 입력 정보입니다.") val address: String, // Address라는 객체를 만들 필요가 있지 않을까?
    @field:Min(1) @field:Max(5) val score: Int, // 정책적으로 결정할 부분 있음 // enum으로 만드는 편이 낫지 않을까?
    val visitedDateTime: OffsetDateTime,
    val waited: Boolean,
    val storeSize: Int,
    @field:NotBlank(message = "content는 필수 입력 정보입니다.") val content: String,
)
