package com.example.restapi2.model

data class Rezultat(
    var id: Int,
    var creationTimeSeconds: Long,
    var modificationTimeSeconds: Long,
    var allowViewHistory: Boolean,
    var authorHandle: String,
    var originalLocale: String,
    var title: String,
    var locale: String,
    var rating: Int,
    var tags: List<String>
)