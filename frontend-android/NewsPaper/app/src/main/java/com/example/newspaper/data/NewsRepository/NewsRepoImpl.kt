package com.example.newspaper.data.NewsRepository

import com.example.newspaper.Constant.Constants
import com.example.newspaper.data.dclass.distributor.Distributor
import com.example.newspaper.data.dclass.newsData
import com.example.newspaper.data.remote.NewsApi
import com.example.newspaper.presentation.NewsRepository.NewsRepo
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(
    private val api : NewsApi
):NewsRepo {
    override suspend fun getNews(): newsData {
        return api.getNews(Constants.GETNEWS)
    }

    override suspend fun getDistributor(): Distributor {
        return api.getDistributors()
    }

}