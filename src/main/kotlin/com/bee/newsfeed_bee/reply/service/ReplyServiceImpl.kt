package com.bee.newsfeed_bee.reply.service

import com.bee.newsfeed_bee.reply.dto.CreateReplyRequest
import com.bee.newsfeed_bee.reply.dto.DeleteReplyRequest
import com.bee.newsfeed_bee.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.reply.dto.UpdateReplyRequest
import org.springframework.stereotype.Service

@Service
class ReplyServiceImpl : ReplyService {
    override fun getReplys(feedId: Long): List<ReplyResponse> {
        TODO("Not yet implemented")
    }

    override fun getReply(replyId: Long): ReplyResponse {
        TODO("Not yet implemented")
    }

    override fun createReply(feedId: Long, request: CreateReplyRequest): ReplyResponse {
        TODO("Not yet implemented")
    }

    override fun updateReply(replyId: Long, request: UpdateReplyRequest): ReplyResponse {
        TODO("Not yet implemented")
    }

    override fun deleteReply(feedId: Long, replyId: Long, request: DeleteReplyRequest) {
        TODO("Not yet implemented")
    }
}