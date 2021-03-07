package com.example.restapi2.ui.comments

import com.example.restapi2.ui.NetworkHelper

class CommentsPresenter(private val responseHelper: NetworkHelper, private val view: CommentsView) {


    fun getCommentsInfo(id: Int){
        responseHelper.getComments(id,
                {
                    view.setResponseData(it)
                },
                {
                    view.showMessage(it)
                })
    }
}