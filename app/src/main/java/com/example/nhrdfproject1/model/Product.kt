package com.example.nhrdfproject1.model

data class Product(
    val image: String,
    val title: String,
    val price: Double,
    val description: String,
    val rating: Rating
)

data class Rating(
    val rate: Double,
    val count: Int
)