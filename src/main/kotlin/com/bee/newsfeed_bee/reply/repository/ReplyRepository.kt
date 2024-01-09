package com.bee.newsfeed_bee.reply.repository

import com.bee.newsfeed_bee.reply.model.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository : JpaRepository<Reply, Long>{
    fun findAllByFeedId(feedId:Long):List<Reply>
}