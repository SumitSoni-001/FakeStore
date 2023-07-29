package com.example.fakestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fakestore.db.FakerDb
import com.example.fakestore.di.FakeApplication
import com.example.fakestore.viewModel.FakeViewModel
import com.example.fakestore.viewModel.FakeViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var fakeViewModel: FakeViewModel
    @Inject
    lateinit var fakeViewModelFactory: FakeViewModelFactory

    private val productText : TextView
    get() = findViewById(R.id.productText)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FakeApplication).fakeComponent.inject(this)

        val map = (application as FakeApplication).fakeComponent.getMap()

        fakeViewModel = ViewModelProvider(this , fakeViewModelFactory)[FakeViewModel::class.java]

        fakeViewModel.productsData.observe(this , Observer {
            productText.text = it.joinToString { x -> x.title + "\n\n" }
        })

    }
}