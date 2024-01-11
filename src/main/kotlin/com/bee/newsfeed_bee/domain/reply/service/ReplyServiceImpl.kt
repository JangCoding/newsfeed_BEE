package com.bee.newsfeed_bee.domain.reply.service

import com.bee.newsfeed_bee.domain.exception.InputLengthException
import com.bee.newsfeed_bee.domain.exception.InvalidCredentialsException
import com.bee.newsfeed_bee.domain.exception.ModelNotFoundException
import com.bee.newsfeed_bee.domain.feed.repository.FeedRepository
import com.bee.newsfeed_bee.domain.reply.dto.ReplyCreateRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyDeleteRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.domain.reply.dto.ReplyUpdateRequest
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

    val USERNAME_MAX = 20
    val PASSWORD_MIN = 4
    val PASSWORD_MAX = 12
    val CONTENTS_MAX = 1000

    override fun getReplyList(feedId: Long): List<ReplyResponse> {
        return replyRepository.findAllByFeedIdAndDeletedAtIsNull(feedId)
            .map{it.toResponse()}
    }

    override fun getReply(replyId: Long): ReplyResponse {
        return replyRepository.findByIdAndDeletedAtIsNull(replyId)
            ?.toResponse()
            ?: throw ModelNotFoundException("Reply", replyId)
    }

    override fun createReply(feedId: Long, request: ReplyCreateRequest ): ReplyResponse {

        if(request.userName.length !in 1 .. PASSWORD_MAX)
            throw InputLengthException("UserName",request.userName.length,1,USERNAME_MAX)

        else if(request.password.length !in PASSWORD_MIN .. PASSWORD_MAX)
            throw InputLengthException("Password",request.password.length,PASSWORD_MIN,USERNAME_MAX)

        else if(request.contents.length !in 1 .. CONTENTS_MAX)
            throw InputLengthException("Contents",request.password.length,1,CONTENTS_MAX)


        val feed = feedRepository.findByIdAndDeletedDateTimeIsNull(feedId)
            ?: throw ModelNotFoundException("Feed",feedId)
        return Reply(
            userName = request.userName,
            password = request.password,
            contents = request.contents,
            feed = feed
        ).let{replyRepository.save(it)}.toResponse()

    }

    @Transactional
    override fun updateReply(replyId: Long, request: ReplyUpdateRequest): ReplyResponse {
        val reply = replyRepository.findByIdAndDeletedAtIsNull(replyId)
            ?: throw ModelNotFoundException("Reply", replyId)

        if (reply.password != request.password)
            throw InvalidCredentialsException("Password", "Reply")

        if(request.contents.length !in 1 .. CONTENTS_MAX)
            throw InputLengthException("Contents",request.password.length,1,CONTENTS_MAX)

        reply.contents = request.contents
        reply.updatedAt = OffsetDateTime.now()


        return reply.toResponse()
    }


    @Transactional
    override fun deleteReply(feedId: Long, replyId: Long, request: ReplyDeleteRequest) {
       // val feed = feedRepository.findByIdAndDeletedDateTimeIsNull(feedId) ?: throw ModelNotFoundException("Feed",feedId)
        val reply = replyRepository.findByIdAndDeletedAtIsNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)

        if (reply.password != request.password)
            throw InvalidCredentialsException("Password", "Reply")

        reply.deletedAt = OffsetDateTime.now()
    }
}