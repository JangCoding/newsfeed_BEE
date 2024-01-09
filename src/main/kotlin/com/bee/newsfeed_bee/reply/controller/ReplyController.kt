package com.bee.newsfeed_bee.reply.controller

import com.bee.newsfeed_bee.reply.dto.DeleteReplyRequest
import com.bee.newsfeed_bee.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.reply.model.Reply
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/feeds/{feedId}/replys")

class ReplyController {
    @GetMapping()
    fun getReplys(@PathVariable feedId:Long) : ResponseEntity<List<ReplyResponse>>
    {
        TODO()
    }

    @GetMapping("/{replyId}")
    fun getReply(@PathVariable feedId:Long, @PathVariable replyId:Long) : ResponseEntity<ReplyResponse>
    {
        TODO()
    }

    @PostMapping()
    fun createReply(@PathVariable feedId:Long) : ResponseEntity<ReplyResponse>
    {
        TODO()
    }

    @PutMapping("/{replyId")
    fun updateReply(@PathVariable feedId: Long, @PathVariable replyId: Long) : ResponseEntity<ReplyResponse>
    {
        TODO()
    }

    @DeleteMapping("/{replyId")
    fun deleteReply(@PathVariable feedId: Long, @PathVariable replyId: Long)
    {
        TODO()
    }
}
