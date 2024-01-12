package com.bee.newsfeed_bee.domain.reply.dto

import jakarta.validation.constraints.NotBlank

data class ReplyDeleteRequest (
    //@field:NotBlank(message = "password는 필수 입력 정보입니다.")
    val password:String
)