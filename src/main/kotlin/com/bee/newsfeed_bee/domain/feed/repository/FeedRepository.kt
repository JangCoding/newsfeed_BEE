package com.bee.newsfeed_bee.domain.feed.repository

import com.bee.newsfeed_bee.domain.feed.entity.Feed
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository: JpaRepository<Feed, Long>, CustomFeedRepository {

    fun findAllByDeletedDateTimeIsNull(pageable: Pageable): Page<Feed> // 쿼리 메서드도 Pageable로 넣고 Page로 가져오겠다고 해도 알아서 잘 해결해줌

    fun findAllByCategoryAndDeletedDateTimeIsNull(category: String, pageable: Pageable): Page<Feed>

    fun findByIdAndDeletedDateTimeIsNull(id: Long): Feed
}
