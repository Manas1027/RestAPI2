package com.example.restapi2.ui.response

import com.example.restapi2.model.Rezultat

interface ResponseView {
    fun setResponseData(responseList: List<Rezultat>)

}