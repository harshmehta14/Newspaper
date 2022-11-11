package com.example.newspaper.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
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
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Click to login", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Button(onClick = { login() }) {
                        Text(text = "Login")
                    }
                }
            }
        }
    }

    fun login(){
        WebAuthProvider.login(account)
            .withScheme("news")
            .withScope("openid profile email")
            .start(this,object : Callback<Credentials, AuthenticationException>{
                override fun onFailure(error: AuthenticationException) {
                    cachedCredentials = null
                }

                override fun onSuccess(result: Credentials) {
                    cachedCredentials = result
                    Toast.makeText(this@MainActivity,"$result", Toast.LENGTH_LONG).show()
                }
            })
    }
}
