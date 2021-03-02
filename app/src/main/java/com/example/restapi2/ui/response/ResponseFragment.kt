package com.example.restapi2.ui.response

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.restapi2.*
import com.example.restapi2.model.Rezultat
import com.example.restapi2.retrofit.ApiClient
import com.example.restapi2.ui.NetworkHelper
import kotlinx.android.synthetic.main.fragment_response.*

class ResponseFragment: Fragment(R.layout.fragment_response), NetworkListener {

    private lateinit var navController: NavController
    private val adapter = ResponseAdapter()
    lateinit var networkHelper: NetworkHelper
    private val safeArgs: ResponseFragmentArgs by navArgs()
    private var name: String = ""


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        navController = Navigation.findNavController(view)

        mList.adapter = adapter
        mList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        networkHelper = NetworkHelper(ApiClient.getClient())
        name = safeArgs.name
        adapter.onItemClicked = { id ->
            val action = ResponseFragmentDirections.actionHomeFragmentToCommentsFragment(id)
            navController.navigate(action)
        }
        setData()
        view.hideKeyboard()
    }
    private fun setData(){
        networkHelper.getClasses(this, "$name")
    }

    override fun onSchoolClassesResponse(models: List<Rezultat>?) {
        if (models != null) {
            adapter.models = models
        }
    }

    override fun onSchoolClassesFailure(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }


    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}