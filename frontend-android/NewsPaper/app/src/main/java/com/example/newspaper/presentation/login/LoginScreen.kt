package com.example.newspaper.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(login : () ->Unit,logOut:()->Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Click to login", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Button(onClick = { login.invoke() }) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = { logOut.invoke() }) {
            Text(text = "LogOut")
        }
    }
}