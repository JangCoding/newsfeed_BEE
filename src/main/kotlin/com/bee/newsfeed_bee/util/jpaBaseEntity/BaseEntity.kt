package com.bee.newsfeed_bee.util.jpaBaseEntity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.time.OffsetDateTime

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
class BaseEntity {

    @Column(updatable = false) // @CreatedDate 붙이고 var로 선언 시 에러 - 아예 생성 시 초기화 하면 해결
    val createdDateTime: OffsetDateTime = OffsetDateTime.now()

    @LastModifiedDate
    @Column
    var lastModifiedDateTime: OffsetDateTime = OffsetDateTime.now()
        protected set
}
