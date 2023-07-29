package com.example.fakestore.retrofit

import com.example.fakestore.models.Products
import retrofit2.Response
import retrofit2.http.GET

interface FakeApi {

    @GET("products")
    suspend fun getProducts() : Response<List<Products>>

}