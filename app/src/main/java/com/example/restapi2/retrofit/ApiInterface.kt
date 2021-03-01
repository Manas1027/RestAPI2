package com.example.restapi2.retrofit

import com.example.restapi2.model.MyResponse
import com.example.restapi2.model.MyResponse2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api/user.blogEntries")
    fun getClasses(@Query("handle") handle: String): Call<MyResponse>

    @GET("/api/blogEntry.comments")
    fun getComments(@Query("blogEntryId") id: Int): Call<MyResponse2>
}