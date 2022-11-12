package com.example.newspaper.presentation.NewsRepository

import com.example.newspaper.data.dclass.newsData

interface NewsRepo {

    suspend fun getNews() : newsData

}