package com.example.newspaper.presentation.NewsRepository

import com.example.newspaper.data.dclass.distributor.Distributor
import com.example.newspaper.data.dclass.newsData

interface NewsRepo {

    suspend fun getNews() : newsData

    suspend fun getDistributor() : Distributor

}