package com.example.restapi2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restapi2.*

class MainActivity : AppCompatActivity() {

    private val adapter = ResponseAdapter()
    lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}