package com.bee.newsfeed_bee.domain.reply.repository

import com.bee.newsfeed_bee.domain.reply.entity.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository : JpaRepository<Reply, Long>{
    fun findAllByFeedIdAndDeletedDateTimeIsNull(feedId:Long):List<Reply>
    fun findByIdAndDeletedDateTimeIsNull(id:Long):Reply?
}