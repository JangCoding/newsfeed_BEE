package com.bee.newsfeed_bee.domain.dummyUser

import org.springframework.security.crypto.password.PasswordEncoder

class PasswordEncodedUserRequest(
    userRequest: UserRequest,
    passwordEncoder: PasswordEncoder,
) {
    val nickname: String = userRequest.nickname
    val password: String = passwordEncoder.encode(userRequest.password)
}
