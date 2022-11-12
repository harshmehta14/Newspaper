package com.example.newspaper.module

import com.example.newspaper.data.NewsRepository.NewsRepoImpl
import com.example.newspaper.data.remote.NewsApi
import com.example.newspaper.presentation.NewsRepository.NewsRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {
    @Provides
    @Singleton
    fun provideNewsApi(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://node-backend.harshmehta13.repl.co/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson():Gson = GsonBuilder().create()

    @Provides
    fun provideNewsService(retrofit: Retrofit) = retrofit.create(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApi) : NewsRepo{
        return NewsRepoImpl(api)
    }
}