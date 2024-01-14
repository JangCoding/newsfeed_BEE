package com.bee.newsfeed_bee.domain.feed.config

import com.bee.newsfeed_bee.domain.feed.entity.CuisineCategory
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class FeedConfig : WebMvcConfigurer {

    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(CuisineCategoryConverter())
    }

    class CuisineCategoryConverter: Converter<String, CuisineCategory> {
        override fun convert(source: String): CuisineCategory {
            return kotlin.runCatching {
                CuisineCategory.valueOf(source)
            }.getOrElse { 
                throw IllegalArgumentException("음식 카테고리 잘못 입력")
            }
        }
    }
}
