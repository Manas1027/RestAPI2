package com.example.restapi2.model

data class Rezultat(
    var id: Int,
    var creationTimeSeconds: Int,
    var modificationTimeSeconds: Int,
    var allowViewHistory: String,
    var authorHandle: String,
    var title: String,
    var locale: String,
    var rating: Int,
    var tags: List<Tags>
)