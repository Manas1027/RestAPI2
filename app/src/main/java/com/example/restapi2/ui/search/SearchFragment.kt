package com.example.restapi2.ui.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.restapi2.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment: Fragment(R.layout.fragment_search) {

    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        navController = Navigation.findNavController(view)

        btnOK.setOnClickListener{
            val name = etName.text.toString()
            val action = SearchFragmentDirections.actionSearchFragmentToHomeFragment(name)
            navController.navigate(action)


        }

        KeyEvent.KEYCODE_ENTER

    }

}