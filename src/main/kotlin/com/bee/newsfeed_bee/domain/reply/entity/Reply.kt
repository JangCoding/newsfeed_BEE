package com.bee.newsfeed_bee.domain.reply.entity

import com.bee.newsfeed_bee.domain.feed.entity.Feed
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.OffsetDateTime


@Entity
//@Table(name = "feed")

class Reply(
    @Column(name="username")
    var userName : String,

    @JsonIgnore
    @Column(name = "password")
    var password : String,

    @Column(name = "contents")
    var contents : String,

    @Column(name = "created_date_time")
    var createdAt: OffsetDateTime = OffsetDateTime.now(),

    @Column(name = "last_modified_time")
    var updatedAt : OffsetDateTime ?= null,

    @Column(name = "deleted_date_time")
    var deletedAt : OffsetDateTime ?= null,

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    var feed: Feed
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null
}

fun Reply.toResponse(): ReplyResponse {
    return ReplyResponse(
        id= id!!,
        userName = userName,
        contents = contents,
        createdAt =createdAt,
        updatedAt=updatedAt,
    )
}