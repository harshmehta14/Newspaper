package com.example.newspaper.presentation.newsApi

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import dagger.hilt.android.lifecycle.HiltViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.example.newspaper.data.NewsRepository.NewsRepoImpl
import com.example.newspaper.data.dclass.newsData
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsApiViewModel @Inject constructor(val newsRepoImpl: NewsRepoImpl):ViewModel() {
//    private val link = "https://newsapi.org/v2/everything?q=twitter&from=2022-10-12&sortBy=publishedAt&apiKey=5b846973dc6f44f38c6a6ff7ba24a2c8"
//
    val news = MutableLiveData<newsData>()

    fun newS(context: Context) = viewModelScope.launch {
        news.value = newsRepoImpl.getNews()
        Log.v("news","${news.value}")
    }

//        val queue = Volley.newRequestQueue(context)
//        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET,link,null, {
//                Toast.makeText(context,"$it",Toast.LENGTH_SHORT).show()
//        }, {
//                Toast.makeText(context,"Didnt work",Toast.LENGTH_SHORT).show()
//        })
//        queue.add(jsonObjectRequest)
}