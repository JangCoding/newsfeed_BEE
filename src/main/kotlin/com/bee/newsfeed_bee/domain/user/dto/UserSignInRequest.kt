package kotlin.com.bee.newsfeed_bee.domain.user.dto

data class UserSignInRequest (
    val email : String,
    var nickname : String,
    var password : String
)