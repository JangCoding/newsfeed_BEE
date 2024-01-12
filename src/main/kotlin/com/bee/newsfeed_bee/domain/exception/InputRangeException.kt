package com.bee.newsfeed_bee.domain.exception

data class InputRangeException(val field:String, val len:Int, val min:Int, val max:Int):RuntimeException(
    "$field value($len) must between $min and $max"
)
