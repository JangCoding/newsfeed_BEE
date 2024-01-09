package com.bee.newsfeed_bee.domain.reply.service

import com.bee.newsfeed_bee.domain.exception.InvalidCredentialsException
import com.bee.newsfeed_bee.domain.exception.ModelNotFoundException
import com.bee.newsfeed_bee.domain.reply.dto.CreateReplyRequest
import com.bee.newsfeed_bee.domain.reply.dto.DeleteReplyRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.domain.reply.dto.UpdateReplyRequest
import com.bee.newsfeed_bee.domain.reply.model.Reply
import com.bee.newsfeed_bee.domain.reply.model.toResponse
import com.bee.newsfeed_bee.domain.reply.repository.ReplyRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ReplyServiceImpl(
    private var replyRepository: ReplyRepository
) : ReplyService {
    override fun getReplys(feedId: Long): List<ReplyResponse> {
        return replyRepository.findAllByFeedId(feedId).map{it.toResponse()}
    }

    override fun getReply(replyId: Long): ReplyResponse {
        var reply = replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        return reply.toResponse()
    }

    override fun createReply(feedId: Long, request: CreateReplyRequest): ReplyResponse {
        var feed = feedRepository.findByIdOrNull(feedId) ?: throw ModelNotFoundException("Feed",feedId)
        var reply = Reply(
            userName = request.userName,
            password = request.password,
            contents = request.contents,
            feed = feed
        )
    }

    override fun updateReply(replyId: Long, request: UpdateReplyRequest): ReplyResponse {
        var reply = replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        if (reply.password == request.password)
        {
            reply.contents = request.contents
        }
        else
            throw InvalidCredentialsException("Password", "Reply")
        return reply.toResponse()
    }

    override fun deleteReply(feedId: Long, replyId: Long, request: DeleteReplyRequest) {
        var feed = feedRepository.findByIdOrNull(feedId) ?: throw ModelNotFoundException("Feed",feedId)
        var reply = replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)

        if (reply.password == request.password)
        {
            feed.delete(reply)
        }
        else
            throw InvalidCredentialsException("Password", "Reply")
    }
}