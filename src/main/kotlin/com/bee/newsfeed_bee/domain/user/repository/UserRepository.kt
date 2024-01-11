package com.bee.newsfeed_bee.domain.user.repository

import com.bee.newsfeed_bee.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

}