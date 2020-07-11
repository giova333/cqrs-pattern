package com.gladunalexander.overview

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CommentServiceApplication

fun main(args: Array<String>) {
    runApplication<CommentServiceApplication>(*args)
}
