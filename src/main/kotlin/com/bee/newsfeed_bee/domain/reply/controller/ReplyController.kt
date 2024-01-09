package com.bee.newsfeed_bee.domain.reply.controller

import com.bee.newsfeed_bee.domain.reply.dto.CreateReplyRequest
import com.bee.newsfeed_bee.domain.reply.dto.DeleteReplyRequest
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.domain.reply.dto.UpdateReplyRequest
import com.bee.newsfeed_bee.domain.reply.service.ReplyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}
