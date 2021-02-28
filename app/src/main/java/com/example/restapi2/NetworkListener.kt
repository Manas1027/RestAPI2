package com.example.restapi2

import com.example.restapi2.model.Rezultat

interface NetworkListener {
    fun onSchoolClassesResponse(models: List<Rezultat>?)
    fun onSchoolClassesFailure(message: String?)
}