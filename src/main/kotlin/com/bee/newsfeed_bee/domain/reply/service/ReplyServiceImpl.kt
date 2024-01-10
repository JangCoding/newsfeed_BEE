package com.bee.newsfeed_bee.domain.reply.service

import com.bee.newsfeed_bee.domain.exception.InvalidCredentialsException
import com.bee.newsfeed_bee.domain.exception.ModelNotFoundException
import com.bee.newsfeed_bee.domain.feed.entity.toEntity
import com.bee.newsfeed_bee.domain.feed.entity.toResponse
import com.bee.newsfeed_bee.domain.feed.repository.FeedRepository
import com.bee.newsfeed_bee.domain.reply.dto.CreateReplyRequest
import com.bee.newsfeed_bee.domain.reply.dto.DeleteReplyRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.domain.reply.dto.UpdateReplyRequest
import com.bee.newsfeed_bee.domain.reply.entity.Reply
import com.bee.newsfeed_bee.domain.reply.entity.toResponse
import com.bee.newsfeed_bee.domain.reply.repository.ReplyRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Service
class ReplyServiceImpl(
    private var replyRepository: ReplyRepository,
    private var feedRepository : FeedRepository
) : ReplyService {
    override fun getReplyList(feedId: Long): List<ReplyResponse> {
        return replyRepository.findAllByFeedIdAndDeletedAtIsNull(feedId).map{it.toResponse()}
    }

    override fun getReply(replyId: Long): ReplyResponse {
        val reply = replyRepository.findByIdAndDeletedAtIsNull(replyId)
            .let{
                if(it == null)
                    throw ModelNotFoundException("Reply", replyId)
                else
                    return it.toResponse()
            }
    }

    override fun createReply(feedId: Long, request: CreateReplyRequest): ReplyResponse {
        val feed = feedRepository.findByIdAndDeletedDateTimeIsNull(feedId)
            ?: throw ModelNotFoundException("Feed",feedId)
        val reply = Reply(
            userName = request.userName,
            password = request.password,
            contents = request.contents,
            feed = feed
        )
        replyRepository.save(reply)
        return reply.toResponse()
    }

    @Transactional
    override fun updateReply(replyId: Long, request: UpdateReplyRequest): ReplyResponse {
        val reply = replyRepository.findByIdAndDeletedAtIsNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        if (reply.password == request.password)
        {
            reply.contents = request.contents
            reply.updatedAt = OffsetDateTime.now()
        }
        else
            throw InvalidCredentialsException("Password", "Reply")
        return reply.toResponse()
    }

    @Transactional
    override fun deleteReply(feedId: Long, replyId: Long, request: DeleteReplyRequest) {
       // val feed = feedRepository.findByIdAndDeletedDateTimeIsNull(feedId) ?: throw ModelNotFoundException("Feed",feedId)
        val reply = replyRepository.findByIdAndDeletedAtIsNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)

        if (reply.password == request.password)
        {
            reply.deletedAt = OffsetDateTime.now()
        }
        else
            throw InvalidCredentialsException("Password", "Reply")
    }
}