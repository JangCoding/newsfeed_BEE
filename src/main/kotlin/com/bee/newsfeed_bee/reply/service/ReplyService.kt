package com.bee.newsfeed_bee.reply.service

import com.bee.newsfeed_bee.reply.dto.CreateReplyRequest
import com.bee.newsfeed_bee.reply.dto.DeleteReplyRequest
import com.bee.newsfeed_bee.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.reply.dto.UpdateReplyRequest


interface ReplyService {
    fun getReplys(feedId:Long) : List<ReplyResponse>
    fun getReply(replyId:Long) : ReplyResponse
    fun createReply(feedId:Long, request:CreateReplyRequest) : ReplyResponse
    fun updateReply(replyId: Long, request:UpdateReplyRequest) : ReplyResponse
    fun deleteReply( feedId: Long, replyId: Long, request:DeleteReplyRequest)
}