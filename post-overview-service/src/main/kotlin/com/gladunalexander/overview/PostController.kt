package com.gladunalexander.overview

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(private val repository: PostRepository) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) =
            repository.findById(id)
                    .map { ResponseEntity.ok(it) }
                    .orElseGet { ResponseEntity.notFound().build() }
}