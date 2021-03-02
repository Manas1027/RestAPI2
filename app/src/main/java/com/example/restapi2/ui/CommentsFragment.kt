package com.example.restapi2.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.restapi2.*
import com.example.restapi2.model.Comment
import com.example.restapi2.retrofit.ApiClient
import kotlinx.android.synthetic.main.fragment_comments.*
import kotlinx.android.synthetic.main.fragment_home.*

class CommentsFragment: Fragment(R.layout.fragment_comments), NetworkListener2 {

    private lateinit var navController: NavController
    private val adapter = CommentsAdapter()
    lateinit var networkHelper: NetworkHelper
    private val safeArgs: CommentFragmentArgs by navArgs()
    private var index = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        navController = Navigation.findNavController(view)
        //index = safeArgs.id
        comments.adapter = adapter
        comments.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
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