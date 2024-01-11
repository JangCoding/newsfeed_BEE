package com.bee.newsfeed_bee.domain.dummyUser

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Users(
    var nickname: String,
    var password: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun PasswordEncodedUserRequest.toEntity(): Users {
    return Users(this.nickname, this.password)
}
