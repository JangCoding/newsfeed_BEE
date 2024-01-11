package com.bee.newsfeed_bee.webConfig.athentication

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.servlet.HandlerInterceptor

class AuthenticationInterceptor: HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (request.method == "GET") return true

        val session = request.getSession(false) ?: throw IllegalStateException("login 사용자만 허용")
        if (session.getAttribute("isLoggedIn") == false) {
            throw IllegalStateException("login 사용자만 허용")
        }
        return true
    }
}
