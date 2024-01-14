package com.bee.newsfeed_bee.domain.exception

data class InvalidCredentialsException(val credential:String, val model:String) : RuntimeException(
    "$credential does not match ( $model )"
)
