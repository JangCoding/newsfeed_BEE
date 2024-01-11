package com.bee.newsfeed_bee.domain.user.controller

import com.bee.newsfeed_bee.domain.user.dto.*
import com.bee.newsfeed_bee.domain.user.model.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import kotlin.com.bee.newsfeed_bee.domain.user.dto.UserSignInRequest

@RestController
class UserController {

    @PostMapping("/signIn")
    fun signIn(@RequestBody userSignInRequest: UserSignInRequest): ResponseEntity<UserSignInResponse> {
        TODO()
    }
    @PutMapping("/put/{userId}")
    fun userUpdate(@PathVariable userId: Long,
                          @RequestBody userUpdate : UserUpdateRequest
    ): ResponseEntity<UserUpdateResponse> {
        TODO()
    }
    @PostMapping("/logIn")
    fun userLogIn(@PathVariable userId: Long,
                          @RequestBody userLogIn: UserLoginRequest
    ): ResponseEntity<UserLoginResponse> {
        TODO()
    }
}