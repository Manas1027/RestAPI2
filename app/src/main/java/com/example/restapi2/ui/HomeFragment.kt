package com.example.restapi2.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.restapi2.*
import com.example.restapi2.model.Rezultat
import com.example.restapi2.retrofit.ApiClient
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(R.layout.fragment_home), NetworkListener {

    private lateinit var navController: NavController
    private val adapter = ResponseAdapter()
    lateinit var networkHelper: NetworkHelper


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        mList.adapter = adapter
        mList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        networkHelper = NetworkHelper(ApiClient.getClient())
        adapter.onItemClicked = { id ->
//            val action = HomeFragmentDirections
//            navController.navigate(action)
        }
        setData()
    }
    private fun setData(){
        networkHelper.getClasses(this, "Fefer_Ivan")
    }

    override fun onSchoolClassesResponse(models: List<Rezultat>?) {
        if (models != null) {
            adapter.models = models
        }
    }

    override fun onSchoolClassesFailure(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}