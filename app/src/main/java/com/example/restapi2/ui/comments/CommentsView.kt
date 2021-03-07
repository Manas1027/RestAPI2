package com.example.restapi2.ui.comments

import com.example.restapi2.model.Comment

interface CommentsView {
    fun setResponseData(responseList: List<Comment>)
    fun showMessage(msg: String?)

}