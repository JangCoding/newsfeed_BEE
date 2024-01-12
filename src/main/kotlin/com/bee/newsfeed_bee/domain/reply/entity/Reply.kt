package com.bee.newsfeed_bee.domain.reply.entity

import com.bee.newsfeed_bee.domain.exception.InputLengthException
import com.bee.newsfeed_bee.domain.exception.InvalidCredentialsException
import com.bee.newsfeed_bee.domain.feed.entity.Feed
import com.bee.newsfeed_bee.domain.reply.dto.ReplyResponse
import com.bee.newsfeed_bee.util.jpaBaseEntity.BaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.OffsetDateTime


@Entity
//@Table(name = "feed")

class Reply(
    _userName : String,

    _password : String,

    _content : String,

    @Column
    var deletedDateTime: OffsetDateTime? = null,

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    var feed: Feed
):BaseEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null

    @Column(name="user_name")
    var userName = _userName
        .also{if(it.isEmpty() || it.length > USERNAME_MAX)
            throw InputLengthException("UserName",_userName.length,1,USERNAME_MAX)
        }

    @JsonIgnore
    @Column(name = "password")
    var password = _password
        .also{if(it.length < 4 || it.length > PASSWORD_MAX)
            throw InputLengthException("Password",_password.length,PASSWORD_MIN,PASSWORD_MAX)
        }

    @Column(name = "content")
    var content = _content
        .also{if(it.isEmpty() || it.length > CONTENT_MAX)
            throw InputLengthException("Content",_content.length,1,CONTENT_MAX)
        }

    companion object{
        const val USERNAME_MAX = 20
        const val PASSWORD_MIN = 4
        const val PASSWORD_MAX = 12
        const val CONTENT_MAX = 1000
    }
}


fun Reply.toResponse(): ReplyResponse {
    return ReplyResponse(
        id= id!!,
        userName = userName,
        contents = content,
        createdAt = this.createdDateTime,
        updatedAt = this.lastModifiedDateTime,
    )
}

fun Reply.chkPassword(input:String){
    if(this.password != input)
            throw InvalidCredentialsException("Password","Reply")
}