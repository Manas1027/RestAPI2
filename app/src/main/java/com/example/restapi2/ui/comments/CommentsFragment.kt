package com.example.restapi2.ui.comments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.restapi2.*
import com.example.restapi2.model.Comment
import com.example.restapi2.retrofit.ApiClient
import com.example.restapi2.ui.NetworkHelper
import com.example.restapi2.ui.response.ResponsePresenter
import kotlinx.android.synthetic.main.fragment_comments.*

class CommentsFragment: Fragment(R.layout.fragment_comments), CommentsView {

    private lateinit var navController: NavController
    private val adapter = CommentsAdapter()
    lateinit var presenter: CommentsPresenter
    private val safeArgs: CommentsFragmentArgs by navArgs()
    private var index = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        navController = Navigation.findNavController(view)
        index = safeArgs.id
        comments.adapter = adapter
        presenter = CommentsPresenter(NetworkHelper(), this)
        setData()
    }
    private fun setData(){
        presenter.getCommentsInfo(index)
    }

    override fun setResponseData(commentsList: List<Comment>) {
        adapter.models = commentsList
    }

    override fun showMessage(msg: String?) {
        TODO("Not yet implemented")
    }


}