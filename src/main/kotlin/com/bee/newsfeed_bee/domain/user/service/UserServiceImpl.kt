package com.bee.newsfeed_bee.domain.user.service

import com.bee.newsfeed_bee.domain.user.dto.*
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    override fun getUserSignIn(): UserSignInResponse {
        TODO("Not yet implemented")
    }

    override fun getUserLogIn(UserId: Long, userLogIn: UserLoginRequest): UserLoginResponse {
        TODO("Not yet implemented")
    }

    override fun getUserUpdate(UserId: Long, userUpdate: UserUpdateRequest): UserUpdateResponse {
        TODO("Not yet implemented")
    }

}