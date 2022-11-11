package com.example.newspaper.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import com.example.newspaper.R
import com.example.newspaper.presentation.login.LoginScreen
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
                NavHost(navController = navController, startDestination = Screens.LoginScreen.route){
                    composable(route = Screens.LoginScreen.route){
                        LoginScreen(login = { login(navController) }){
                            logOut(navController)
                        }
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
