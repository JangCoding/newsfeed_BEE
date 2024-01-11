package com.bee.newsfeed_bee.domain.dummyUser

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users, Long> {

    fun existsByNickname(nickname: String): Boolean

    fun countByNicknameAndPassword(nickname: String, password: String): Int

    fun findByNickname(nickname: String): Users?
}
