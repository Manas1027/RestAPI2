package com.example.restapi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.restapi2.model.Rezultat
import com.example.restapi2.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NetworkListener {

    private val adapter = SchoolClassAdapter()
    lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mList.adapter = adapter
        mList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        networkHelper = NetworkHelper(ApiClient.getClient())
        adapter.onItemClicked = { id ->
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
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
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}