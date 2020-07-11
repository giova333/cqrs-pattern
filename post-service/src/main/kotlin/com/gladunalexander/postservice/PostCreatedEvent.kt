package com.gladunalexander.postservice

data class PostCreatedEvent(val id: Long?, val text: String, val username: String)