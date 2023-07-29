package com.example.fakestore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fakestore.db.FakerDb
import com.example.fakestore.models.Products
import com.example.fakestore.retrofit.FakeApi
import javax.inject.Inject

class FakeRepository @Inject constructor(private val fakeApi: FakeApi , private val fakerDb  :FakerDb) {

    private var mProducts = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>>
        get() = mProducts

    suspend fun getProducts() {
        val result = fakeApi.getProducts()
        if (result.isSuccessful && result.body() != null) {
            fakerDb.getFakerDao().addProducts(result.body()!!)  // store in Room
            mProducts.postValue(result.body())  // store in LiveData
        }
    }

}