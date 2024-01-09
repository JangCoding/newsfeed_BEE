package com.bee.newsfeed_bee.reply.service

import com.bee.newsfeed_bee.reply.dto.CreateReplyRequest
import com.bee.newsfeed_bee.reply.dto.DeleteReplyRequest
import com.bee.newsfeed_bee.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.reply.dto.UpdateReplyRequest
import com.bee.newsfeed_bee.reply.repository.ReplyRepository
import org.springframework.stereotype.Service

@Service
class ReplyServiceImpl(
    private var replyRepository: ReplyRepository
) : ReplyService {
    override fun getReplys(feedId: Long): List<ReplyResponse> {
        return replyRepository.findAllByFeedId(feedId).map{it.toResponse()}
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