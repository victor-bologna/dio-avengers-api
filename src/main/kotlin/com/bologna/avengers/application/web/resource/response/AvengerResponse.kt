package com.bologna.avengers.application.web.resource.response

import com.bologna.avengers.domain.avenger.Avenger

data class AvengerResponse(
    val id: Long,
    val nick: String,
    val person: String,
    val description: String?,
    val history: String?
) {
    companion object {
        fun from(avenger: Avenger): AvengerResponse {
            return AvengerResponse(
                id = avenger.id ?: 0L,
                nick = avenger.nick,
                person = avenger.person,
                description = avenger.description,
                history = avenger.history
            )
        }
    }
}
