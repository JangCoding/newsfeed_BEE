package com.bee.newsfeed_bee

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class NewsFeedBeeApplication

fun main(args: Array<String>) {
    runApplication<NewsFeedBeeApplication>(*args)
}
