package com.bee.newsfeed_bee.domain.feed.entity

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class CuisineCategoryConverter: AttributeConverter<CuisineCategory, String> {

    override fun convertToDatabaseColumn(enumName: CuisineCategory): String {
        return enumName.categoryKoreanName
    }

    override fun convertToEntityAttribute(dbColumnValue: String): CuisineCategory {
        return CuisineCategory.entries.first { it.categoryKoreanName == dbColumnValue }
    }
}