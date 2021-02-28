package com.example.restapi2

import com.example.restapi2.model.SchoolClass
import com.example.restapi2.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelper(private val apiClient: Retrofit) {

    fun getClasses(listener: NetworkListener, handle: String){
        val call : retrofit2.Call<SchoolClass> = apiClient.create(ApiInterface::class.java).getClasses(handle)
        call.enqueue(object : retrofit2.Callback<SchoolClass> {

            override fun onFailure(call: retrofit2.Call<SchoolClass>?, t: Throwable?) {
                listener.onSchoolClassesFailure(t?.localizedMessage)
            }

            override fun onResponse(call: Call<SchoolClass>?, response: Response<SchoolClass>?) {
                listener.onSchoolClassesResponse(response?.body()?.result)
            }

        })
    }
}