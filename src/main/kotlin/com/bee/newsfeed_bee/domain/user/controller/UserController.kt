package com.bee.newsfeed_bee.domain.user.controller

import com.bee.newsfeed_bee.domain.user.model.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @PostMapping("/signIn")
    fun userSignIn(): ResponseEntity<User> {
        return TODO()
    }
}

    @PostMapping("/logIn")
    fun userLogIn(): ResponseEntity<User> {
        return TODO()
    }

    @PutMapping("/update")
    fun userUpdate(): ResponseEntity<User> {
        return TODO()
    }
    