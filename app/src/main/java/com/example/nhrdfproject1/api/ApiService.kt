package com.example.nhrdfproject1.api

import com.example.nhrdfproject1.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}