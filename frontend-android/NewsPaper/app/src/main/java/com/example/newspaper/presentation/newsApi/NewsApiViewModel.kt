package com.example.newspaper.presentation.newsApi

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class NewsApiViewModel():ViewModel() {
    private val link = "https://newsapi.org/v2/everything?q=twitter&from=2022-10-12&sortBy=publishedAt&apiKey=5b846973dc6f44f38c6a6ff7ba24a2c8"


}