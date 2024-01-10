package com.bee.newsfeed_bee.webConfig

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer

@Configuration
class PageConfiguration { // https://tecoble.techcourse.co.kr/post/2021-08-15-pageable/

    @Bean
    fun customizePageQueryParameter(): PageableHandlerMethodArgumentResolverCustomizer {
        return PageableHandlerMethodArgumentResolverCustomizer {
            pageableResolver -> pageableResolver.setOneIndexedParameters(true)
        }
    }
}