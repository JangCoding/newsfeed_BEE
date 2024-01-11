package com.bee.newsfeed_bee.domain.feed.repository

import com.bee.newsfeed_bee.domain.feed.entity.Feed
import com.bee.newsfeed_bee.domain.feed.entity.QFeed
import com.bee.newsfeed_bee.util.queryDsl.QueryDslSupport
import org.springframework.data.domain.Pageable

class CustomFeedRepositoryImpl : CustomFeedRepository, QueryDslSupport() {

    private val feed = QFeed.feed

    override fun findAllByCategoryDongDeletedDateTime(category: String?, address: String?, pageable: Pageable): List<Feed> {
        return queryFactory.selectFrom(feed)
            .let { if (category != null) it.where(feed.category.eq(category)) else it }
            .let { if (address != null) it.where(feed.address.contains(address)) else it }
            .orderBy(feed.createdDateTime.desc())
            .limit(pageable.pageSize.toLong())
            .offset(pageable.pageNumber * pageable.pageSize.toLong())
            .fetch()
    }
}