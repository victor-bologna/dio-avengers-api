package com.bologna.avengers.application.web.resource.request

import com.bologna.avengers.domain.avenger.Avenger
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class AvengerRequest(
    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val nick: String,
    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val person: String,
    val description: String? = "",
    val history: String? = ""
) {
    fun toAvenger() : Avenger = Avenger(
        nick = nick,
        person = person,
        description = description,
        history = history
    )

    companion object {
        fun to(id: Long, avengerRequest: AvengerRequest) : Avenger = Avenger(
            id = id,
            nick = avengerRequest.nick,
            person = avengerRequest.person,
            description = avengerRequest.description,
            history = avengerRequest.history
        )
    }
}
