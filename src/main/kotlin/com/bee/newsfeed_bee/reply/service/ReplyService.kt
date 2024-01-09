package com.bee.newsfeed_bee.reply.service

import com.bee.newsfeed_bee.reply.dto.ReplyResponse


interface ReplyService {
    fun getReplys(feedId:Long) : List<ReplyResponse>
    fun getReply(feedId:Long, replyId:Long) : ReplyResponse
    fun createReply(feedId:Long) : ReplyResponse
    fun updateReply(feedId: Long, replyId: Long) : ReplyResponse
    fun deleteReply( feedId: Long, replyId: Long)
}