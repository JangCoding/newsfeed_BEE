package com.bee.newsfeed_bee.domain.user.service

import com.bee.newsfeed_bee.domain.user.dto.*

interface UserService {

    fun getUserSignIn() : UserSignInResponse

    fun getUserLogIn(UserId:Long, userLogIn: UserLoginRequest) : UserLoginResponse

    fun getUserUpdate(UserId: Long, userUpdate : UserUpdateRequest) : UserUpdateResponse
}