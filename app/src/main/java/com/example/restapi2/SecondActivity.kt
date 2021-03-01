package com.example.restapi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.restapi2.model.Comment
import com.example.restapi2.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), NetworkListener2 {

    private val adapter = CommentsAdapter()
    lateinit var networkHelper: NetworkHelper
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        comments.adapter = adapter
        index = intent.getIntExtra("id", 0)
        networkHelper = NetworkHelper(ApiClient.getClient())

        setData()
    }

    private fun setData(){
        networkHelper.getComments(this, index)
    }

    override fun onCommentsResponse(models: List<Comment>?) {
        if (models != null) {
            adapter.models = models
        }
    }

    override fun onCommentsFailure(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}