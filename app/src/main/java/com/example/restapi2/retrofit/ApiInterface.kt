package com.example.restapi2.retrofit

import com.example.restapi2.model.SchoolClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api/user.blogEntries")
    fun getClasses(@Query("handle") handle: String): Call<SchoolClass>
}