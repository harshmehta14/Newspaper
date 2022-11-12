package com.example.newspaper.data.remote

import com.example.newspaper.Constant.Constants
import com.example.newspaper.data.dclass.newsData
import retrofit2.http.GET

interface NewsApi {

    @GET(Constants.GETNEWS)
    suspend fun getNews():newsData

}