package com.example.newspaper.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
import com.example.newspaper.presentation.homeScreen.DetailScreen
import com.example.newspaper.presentation.homeScreen.HomeScreen
import com.example.newspaper.presentation.homeScreen.SettingScreen
import com.example.newspaper.presentation.login.LoginScreen
import com.example.newspaper.presentation.newsApi.NewsApiScreen
import com.example.newspaper.presentation.screens.Screens
import com.example.newspaper.ui.theme.NewsPaperTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var account : Auth0
    private var cachedCredentials: Credentials? = null
    private var cachedUserProfile: UserProfile? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        account = Auth0(
            "Q0IG9Mp9lXasa9K75KysRxLT9z25qNAD",
            "dev-hv3at8fslposhz8s.us.auth0.com"
        )

        setContent {
            NewsPaperTheme {
                val navController = rememberNavController()
                var startDest = Screens.LoginScreen.route
                if (cachedCredentials != null) startDest = Screens.NewsApiScreen.route
                NavHost(navController = navController, startDestination = startDest){
                    composable(route = Screens.LoginScreen.route){
                        LoginScreen(login = { login(navController) }){
                            logOut(navController)
                        }
                    }
                    composable(route = Screens.NewsApiScreen.route){
                        NewsApiScreen(context = this@MainActivity)
                    }
                    composable(route = Screens.DetailScreen.route){
                        DetailScreen()
                    }
                    composable(route = Screens.SettingScreen.route){
                        SettingScreen(navController = navController)
                    }
                    composable(route = Screens.HomeScreen.route){
                        HomeScreen(navController = navController)
                    }
                }
            }
        }
    }

    /** Login function **/
    fun login(navController: NavController){
        WebAuthProvider.login(account)
            .withScheme("demo")
            .withScope("openid profile email")
            .start(this,object : Callback<Credentials, AuthenticationException>{
                override fun onFailure(error: AuthenticationException) {
                    cachedCredentials = null
                }

                override fun onSuccess(result: Credentials) {
                    cachedCredentials = result
                    Log.v("resutl","${result.accessToken}")
                    navController.navigate(Screens.HomeScreen.route)
                }
            })
    }

    /** LogOut function **/
    fun logOut(navController: NavController){
        WebAuthProvider.logout(account)
            .withScheme("demo")
            .start(this, object : Callback<Void?, AuthenticationException> {
                override fun onSuccess(payload: Void?) {
                    // The user has been logged out!
                    cachedCredentials = null
                    cachedUserProfile = null
                    Log.v("logout","Success")
                }

                override fun onFailure(exception: AuthenticationException) {
                    Log.v("logout","Failure")
                }
            })
    }
}
