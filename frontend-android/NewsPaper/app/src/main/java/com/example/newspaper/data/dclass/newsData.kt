package com.example.newspaper.data.dclass

data class newsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)