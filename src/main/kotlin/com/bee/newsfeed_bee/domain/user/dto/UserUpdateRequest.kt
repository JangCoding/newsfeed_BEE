package com.bee.newsfeed_bee.domain.user.dto

data class UserUpdateRequest(
    val email : String,
    var password : String
)
