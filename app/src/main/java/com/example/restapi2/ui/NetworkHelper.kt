package com.example.restapi2.ui

import com.example.restapi2.model.Comment
import com.example.restapi2.model.MyResponse
import com.example.restapi2.model.MyResponse2
import com.example.restapi2.model.Rezultat
import com.example.restapi2.retrofit.ApiClient
import com.example.restapi2.retrofit.ApiInterface
import com.example.restapi2.ui.response.ResponseView
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelper {

    private val apiClient: Retrofit = ApiClient.getClient()

    fun getResponse(handle: String, onSuccess: (List<Rezultat>) -> Unit,
                    onFailure: (msg: String?) -> Unit){
        val call : Call<MyResponse> = apiClient.create(ApiInterface::class.java).getClasses(handle)
        call.enqueue(object : retrofit2.Callback<MyResponse> {

            override fun onFailure(call: Call<MyResponse>?, t: Throwable?) {
                onFailure.invoke(t?.localizedMessage)
            }

            override fun onResponse(call: Call<MyResponse>?, response: Response<MyResponse>?) {
                response?.body()?.result?.let {
                    onSuccess.invoke(response.body()?.result!!)
                }
            }

        })
    }


    fun getComments(id: Int, onSuccess: (List<Comment>) -> Unit,
                    onFailure: (msg: String?) -> Unit){
        val call : Call<MyResponse2> = apiClient.create(ApiInterface::class.java).getComments(id)
        call.enqueue(object: retrofit2.Callback<MyResponse2> {

            override fun onFailure(call: Call<MyResponse2>?, t: Throwable?) {
                onFailure.invoke(t?.localizedMessage)
            }

            override fun onResponse(call: Call<MyResponse2?>, response: Response<MyResponse2>?) {
                response?.body()?.result?.let {
                    onSuccess.invoke(response?.body()?.result!!)
                }
            }
        })
    }
}