package com.bee.newsfeed_bee.domain.exception

data class InputLengthException(val field:String, val len:Int, val min:Int, val max:Int):RuntimeException(
    "$field Length($len) must between $min and $max"
)
