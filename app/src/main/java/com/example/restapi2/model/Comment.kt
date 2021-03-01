package com.example.restapi2.model

data class Comment(
    val id: Int,
    val creationTimeSeconds: Long,
    val commentatorHandle: String,
    val locale: String,
    val text: String,
    val rating: Int
)