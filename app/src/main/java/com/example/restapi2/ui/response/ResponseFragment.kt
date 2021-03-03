package com.example.restapi2.ui.response

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.restapi2.*
import com.example.restapi2.model.MyResponse
import com.example.restapi2.model.Rezultat
import com.example.restapi2.retrofit.ApiClient
import com.example.restapi2.ui.NetworkHelper
import kotlinx.android.synthetic.main.fragment_response.*

class ResponseFragment: Fragment(R.layout.fragment_response), ResponseView {

    private lateinit var navController: NavController
    private val adapter = ResponseAdapter()
    private lateinit var presenter: ResponsePresenter
    private val safeArgs: ResponseFragmentArgs by navArgs()
    private var name: String = ""


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        navController = Navigation.findNavController(view)

        mList.adapter = adapter
        mList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        name = safeArgs.name
        adapter.onItemClicked = { id ->
            val action = ResponseFragmentDirections.actionHomeFragmentToCommentsFragment(id)
            navController.navigate(action)
        }
        presenter = ResponsePresenter(NetworkHelper(), this)
        getData()
        view.hideKeyboard()
    }


    fun getData() {
        presenter.getResponseInfo("$name")
    }


    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

    override fun setResponseData(responseList: List<Rezultat>) {
        adapter.models = responseList
    }
}