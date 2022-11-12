package com.example.newspaper.data.dclass.distributor

data class DistributorItem(
    val __v: Int,
    val _id: String,
    val address: String,
    val email: String,
    val name: String,
    val newspaper_variety: List<String>,
    val phno: String,
    val signup_date: String
)