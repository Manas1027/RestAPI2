package com.example.restapi2.ui

import com.example.restapi2.model.Comment
import com.example.restapi2.model.Rezultat

interface NetworkListener {
    fun onSchoolClassesResponse(models: List<Rezultat>?)
    fun onSchoolClassesFailure(message: String?)
}

interface NetworkListener2 {
    fun onCommentsResponse(models: List<Comment>?)
    fun onCommentsFailure(message: String?)
}