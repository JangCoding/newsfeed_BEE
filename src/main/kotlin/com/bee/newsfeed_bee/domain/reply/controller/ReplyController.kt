package com.bee.newsfeed_bee.domain.reply.controller

import com.bee.newsfeed_bee.domain.reply.dto.ReplyCreateRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyDeleteRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.domain.reply.dto.ReplyUpdateRequest
import com.bee.newsfeed_bee.domain.reply.service.ReplyService
import jakarta.validation.Valid
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
    fun createReply(@PathVariable feedId:Long, @Valid @RequestBody request: ReplyCreateRequest) : ResponseEntity<ReplyResponse>
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(replyService.createReply(feedId, request))
    }

    @PutMapping("/{replyId}")
    fun updateReply(@PathVariable feedId: Long, @PathVariable replyId: Long, @RequestBody request: ReplyUpdateRequest) : ResponseEntity<ReplyResponse>
    {
        return ResponseEntity.status(HttpStatus.OK).body(replyService.updateReply(replyId, request))
    }

    @DeleteMapping("/{replyId}")
    fun deleteReply(@PathVariable feedId: Long, @PathVariable replyId: Long, @RequestBody request: ReplyDeleteRequest) : ResponseEntity<Unit>
    {
        replyService.deleteReply(feedId, replyId, request)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}
