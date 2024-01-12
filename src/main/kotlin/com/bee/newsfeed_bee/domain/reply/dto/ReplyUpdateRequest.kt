package com.bee.newsfeed_bee.domain.reply.dto

import jakarta.validation.constraints.NotBlank

data class ReplyUpdateRequest (
    @field:NotBlank(message = "password는 필수 입력 정보입니다.")
    val password:String,
    @field:NotBlank(message = "contents는 필수 입력 정보입니다.")
    val contents:String
)