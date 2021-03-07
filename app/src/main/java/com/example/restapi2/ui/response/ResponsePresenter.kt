package com.example.restapi2.ui.response

import com.example.restapi2.ui.NetworkHelper

class ResponsePresenter(private val responseHelper: NetworkHelper, private val view: ResponseView) {


    fun getResponseInfo(name: String){
        responseHelper.getResponse(name,
                {
                    view.setResponseData(it)
                },
                {
                    view.showMessage(it)
                })
    }
}