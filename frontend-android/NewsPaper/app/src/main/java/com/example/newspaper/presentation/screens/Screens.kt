package com.example.newspaper.presentation.screens

sealed class Screens(val route: String){
    object NewsApiScreen : Screens("news_api_screen")
    object LoginScreen : Screens("login_screen")
    object DetailScreen : Screens("detail_screen")
    object SettingScreen : Screens("setting_screen")
    object HomeScreen : Screens("home_screen")
}
