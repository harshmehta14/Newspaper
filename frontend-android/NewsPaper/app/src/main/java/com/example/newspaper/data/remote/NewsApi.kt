package com.example.newspaper.data.remote

import com.example.newspaper.Constant.Constants
import com.example.newspaper.data.dclass.newsData
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsApi {

    @GET()
    suspend fun getNews(@Url anotherUrl: String):newsData

}