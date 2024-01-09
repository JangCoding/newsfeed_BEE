package com.bee.newsfeed_bee.reply.dto

data class CreateReplyRequest (
    val userName:String,
    val password:String,
    val content:String
)