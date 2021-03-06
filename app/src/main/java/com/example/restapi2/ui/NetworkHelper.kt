package com.example.restapi2.ui

import com.example.restapi2.NetworkListener
import com.example.restapi2.NetworkListener2
import com.example.restapi2.model.MyResponse
import com.example.restapi2.model.MyResponse2
import com.example.restapi2.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelper(private val apiClient: Retrofit) {

    fun getClasses(listener: NetworkListener, handle: String){
        val call : Call<MyResponse> = apiClient.create(ApiInterface::class.java).getClasses(handle)
        call.enqueue(object : retrofit2.Callback<MyResponse> {

            override fun onFailure(call: Call<MyResponse>?, t: Throwable?) {
                listener.onSchoolClassesFailure(t?.localizedMessage)
            }

            override fun onResponse(call: Call<MyResponse>?, response: Response<MyResponse>?) {
                listener.onSchoolClassesResponse(response?.body()?.result)
            }

        })
    }


    fun getComments(listener: NetworkListener2, id: Int){
        val call : Call<MyResponse2> = apiClient.create(ApiInterface::class.java).getComments(id)
        call.enqueue(object: retrofit2.Callback<MyResponse2> {

            override fun onFailure(call: Call<MyResponse2>?, t: Throwable?) {
                listener.onCommentsFailure(t?.localizedMessage)
            }

            override fun onResponse(call: Call<MyResponse2?>, response: Response<MyResponse2>?) {
                listener.onCommentsResponse(response?.body()?.result)
            }
        })
    }
}