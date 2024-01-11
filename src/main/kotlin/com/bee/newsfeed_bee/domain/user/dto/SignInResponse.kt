package com.bee.newsfeed_bee.domain.user.dto

data class SignInResponse (
    var id: Long,
    var nickname: String,
    val email: String,
    var password: String
)
