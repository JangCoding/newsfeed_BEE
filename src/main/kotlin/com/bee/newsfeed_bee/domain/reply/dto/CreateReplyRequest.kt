package com.bee.newsfeed_bee.domain.reply.dto

data class CreateReplyRequest (
    val userName:String,
    val password:String,
    val contents:String
)