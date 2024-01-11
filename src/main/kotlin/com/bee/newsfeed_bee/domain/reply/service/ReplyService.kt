package com.bee.newsfeed_bee.domain.reply.service

import com.bee.newsfeed_bee.domain.reply.dto.ReplyCreateRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyDeleteRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.domain.reply.dto.ReplyUpdateRequest


interface ReplyService {
    fun getReplyList(feedId:Long) : List<ReplyResponse>
    fun getReply(replyId:Long) : ReplyResponse
    fun createReply(feedId:Long, request: ReplyCreateRequest) : ReplyResponse
    fun updateReply(replyId: Long, request: ReplyUpdateRequest) : ReplyResponse
    fun deleteReply( feedId: Long, replyId: Long, request: ReplyDeleteRequest)
}