package com.bologna.avengers.application.web

import com.bologna.avengers.application.web.resource.request.AvengerRequest
import com.bologna.avengers.application.web.resource.response.AvengerResponse
import com.bologna.avengers.domain.avenger.AvengerRepository
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

private const val API_PATH = "/api/v1/avengers"

@RestController
@RequestMapping(API_PATH)
class AvengerResource(
    private val repository: AvengerRepository
) {
    @GetMapping
    fun getAvengers(): ResponseEntity<List<AvengerResponse>> {
        return ResponseEntity.ok(repository.getAvengers().map { AvengerResponse.from(it) })
    }

    @GetMapping("{id}")
    fun getAvengers(@PathVariable("{id}") id: Long): ResponseEntity<AvengerResponse> {
        return ResponseEntity.ok(repository.getAvenger(id)?.let { AvengerResponse.from(it) })
            ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createAvenger(@Valid @RequestBody avengerRequest: AvengerRequest): ResponseEntity.BodyBuilder? {
        val createdAvenger = repository.create(avengerRequest.toAvenger())
        return ResponseEntity.created(URI("$API_PATH/${createdAvenger.id}"))
    }

    @PutMapping("{id}")
    fun updateAvenger(@Valid @RequestBody avengerRequest: AvengerRequest, @PathVariable("id") id: Long): ResponseEntity<AvengerResponse> {
        val avenger = repository.getAvenger(id)?.let { repository.update(AvengerRequest.to(id, avengerRequest)) }
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(avenger.let { AvengerResponse.from(it) })
    }

    @DeleteMapping("{id}")
    fun deleteAvenger(@PathVariable("id") id: Long): ResponseEntity<Void> {
        repository.delete(id)
        return ResponseEntity.accepted().build()
    }
}
