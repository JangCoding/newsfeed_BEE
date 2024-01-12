package com.bee.newsfeed_bee.domain.reply.service

import com.bee.newsfeed_bee.domain.exception.ModelNotFoundException
import com.bee.newsfeed_bee.domain.feed.repository.FeedRepository
import com.bee.newsfeed_bee.domain.reply.dto.ReplyCreateRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyDeleteRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.domain.reply.dto.ReplyUpdateRequest
import com.bee.newsfeed_bee.domain.reply.entity.Reply
import com.bee.newsfeed_bee.domain.reply.entity.chkPassword
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
        return replyRepository.findAllByFeedIdAndDeletedDateTimeIsNull(feedId)
            .map{it.toResponse()}
    }

    override fun getReply(replyId: Long): ReplyResponse {
        return replyRepository.findByIdAndDeletedDateTimeIsNull(replyId)
            ?.toResponse()
            ?: throw ModelNotFoundException("Reply", replyId)
    }

    override fun createReply(feedId: Long, request: ReplyCreateRequest ): ReplyResponse {

        val feed = feedRepository.findByIdAndDeletedDateTimeIsNull(feedId)
            ?: throw ModelNotFoundException("Feed",feedId)
        return Reply(
            userName = request.userName,
            password = request.password,
            content = request.contents,
            feed = feed
        ).also{it.validate()}
            .let{replyRepository.save(it)}.toResponse()

    }

    @Transactional
    override fun updateReply(replyId: Long, request: ReplyUpdateRequest): ReplyResponse {
        val reply = replyRepository.findByIdAndDeletedDateTimeIsNull(replyId)
            ?: throw ModelNotFoundException("Reply", replyId)

        reply.chkPassword(request.password)

        reply.content = request.contents

        reply.validate()

        return reply.toResponse()
    }

    @Transactional
    override fun deleteReply(feedId: Long, replyId: Long, request: ReplyDeleteRequest) {
       // val feed = feedRepository.findByIdAndDeletedDateTimeIsNull(feedId) ?: throw ModelNotFoundException("Feed",feedId)
        val reply = replyRepository.findByIdAndDeletedDateTimeIsNull(replyId)
            ?: throw ModelNotFoundException("Reply", replyId)

        reply.chkPassword(request.password)

        reply.deletedDateTime = OffsetDateTime.now()
    }
}