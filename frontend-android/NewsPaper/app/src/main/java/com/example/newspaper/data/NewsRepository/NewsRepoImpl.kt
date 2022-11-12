package com.example.newspaper.data.NewsRepository

import com.example.newspaper.data.remote.NewsApi
import com.example.newspaper.presentation.NewsRepository.NewsRepo
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(
    private val api : NewsApi
):NewsRepo {

}