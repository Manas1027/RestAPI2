package com.example.restapi2.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.restapi2.*
import com.example.restapi2.model.Comment
import com.example.restapi2.retrofit.ApiClient
import kotlinx.android.synthetic.main.fragment_comments.*

class CommentFragment: Fragment(R.layout.fragment_comments), NetworkListener2 {

    private val adapter = CommentsAdapter()
    lateinit var networkHelper: NetworkHelper
    private val safeArgs: CommentsFragmentArgs by navArgs()
    private var index = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        index = safeArgs.id
        comments.adapter = adapter
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
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}