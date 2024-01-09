package com.bee.newsfeed_bee.domain.reply.controller

import com.bee.newsfeed_bee.domain.exception.InvalidCredentialsException
import com.bee.newsfeed_bee.domain.exception.ModelNotFoundException
import com.bee.newsfeed_bee.domain.reply.dto.CreateReplyRequest
import com.bee.newsfeed_bee.domain.reply.dto.DeleteReplyRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.domain.reply.dto.UpdateReplyRequest
import com.bee.newsfeed_bee.domain.reply.service.ReplyService
import com.example.courseregistration.domain.exception.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/feeds/{feedId}/replys")

class ReplyController(
    private val replyService : ReplyService
) {
    @GetMapping()
    fun getReplyList(@PathVariable feedId:Long) : ResponseEntity<List<ReplyResponse>>
    {
        return ResponseEntity.status(HttpStatus.OK).body(replyService.getReplyList(feedId))
    }

    @GetMapping("/{replyId}")
    fun getReply(@PathVariable feedId:Long, @PathVariable replyId:Long) : ResponseEntity<ReplyResponse>
    {
        return ResponseEntity.status(HttpStatus.OK).body(replyService.getReply(replyId))
    }

    @PostMapping()
    fun createReply(@PathVariable feedId:Long, @RequestBody request: CreateReplyRequest) : ResponseEntity<ReplyResponse>
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(replyService.createReply(feedId, request))
    }

    @PutMapping("/{replyId}")
    fun updateReply(@PathVariable feedId: Long, @PathVariable replyId: Long, @RequestBody request: UpdateReplyRequest) : ResponseEntity<ReplyResponse>
    {
        return ResponseEntity.status(HttpStatus.OK).body(replyService.updateReply(replyId, request))
    }

    @DeleteMapping("/{replyId}")
    fun deleteReply(@PathVariable feedId: Long, @PathVariable replyId: Long, @RequestBody request: DeleteReplyRequest) : ResponseEntity<Unit>
    {
        replyService.deleteReply(feedId, replyId, request)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @ExceptionHandler(ModelNotFoundException::class)
    fun handleModelNotFoundException(e: ModelNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorResponse(e.message))
    }
    @ExceptionHandler(InvalidCredentialsException::class)
    fun handleInvalidCredentialsException(e: InvalidCredentialsException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorResponse(e.message))
    }
}
