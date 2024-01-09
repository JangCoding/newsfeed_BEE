package com.bee.newsfeed_bee.reply.service

import com.bee.newsfeed_bee.reply.dto.ReplyResponse
import org.springframework.stereotype.Service

@Service
class ReplyServiceImpl : ReplyService {
    override fun getReplys(feedId: Long): List<ReplyResponse> {
        TODO("Not yet implemented")
    }

    override fun getReply(feedId: Long, replyId: Long): ReplyResponse {
        TODO("Not yet implemented")
    }

    override fun createReply(feedId: Long): ReplyResponse {
        TODO("Not yet implemented")
    }

    override fun updateReply(feedId: Long, replyId: Long): ReplyResponse {
        TODO("Not yet implemented")
    }

    override fun deleteReply(feedId: Long, replyId: Long) {
        TODO("Not yet implemented")
    }
}