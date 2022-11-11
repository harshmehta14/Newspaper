package com.example.newspaper.presentation.screens

sealed class Screens(val route: String){
    object NewsApiScreen : Screens("news_api_screen")
}
