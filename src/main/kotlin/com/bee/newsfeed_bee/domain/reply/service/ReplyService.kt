package com.bee.newsfeed_bee.domain.reply.service

import com.bee.newsfeed_bee.domain.reply.dto.CreateReplyRequest
import com.bee.newsfeed_bee.domain.reply.dto.DeleteReplyRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.domain.reply.dto.UpdateReplyRequest


interface ReplyService {
    fun getReplyList(feedId:Long) : List<ReplyResponse>
    fun getReply(replyId:Long) : ReplyResponse
    fun createReply(feedId:Long, request: CreateReplyRequest) : ReplyResponse
    fun updateReply(replyId: Long, request: UpdateReplyRequest) : ReplyResponse
    fun deleteReply( feedId: Long, replyId: Long, request: DeleteReplyRequest)
}