package com.bee.newsfeed_bee.domain.dummyUser

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder,
) {

    @PostMapping("/sign-in")
    fun signIn(@RequestBody userRequest: UserRequest): ResponseEntity<Unit> {

        PasswordEncodedUserRequest(userRequest, passwordEncoder)
            .also { if (userRepository.existsByNickname(it.nickname)) throw IllegalArgumentException("중복 회원") }
            .let { userRepository.save(it.toEntity()) }

        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PostMapping("/login")
    fun login(
        @RequestBody userRequest: UserRequest,
        httpServletRequest: HttpServletRequest,
    ): ResponseEntity<Unit> {

        val user = userRepository.findByNickname(userRequest.nickname) ?: throw IllegalArgumentException("로그인 실패")
        if (!passwordEncoder.matches(userRequest.password, user.password)) throw IllegalArgumentException("로그인 실패")

        httpServletRequest.session
            .also { it.setAttribute("isLoggedIn", true) }
            .also { it.setAttribute("userId", user.id) }
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @PostMapping("/logout")
    fun logout(
        httpServletRequest: HttpServletRequest,
    ): ResponseEntity<Unit> {

        httpServletRequest.getSession(false)
            ?.invalidate()
            ?: throw IllegalStateException("이미 만료된 세션입니다.")

        return ResponseEntity.status(HttpStatus.OK).build()
    }
}
