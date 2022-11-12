package com.example.newspaper.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newspaper.R

@Composable
fun LoginScreen(login : () ->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().background(Color(0xEEFFFFFF)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.news),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth().height(560.dp)
            )
        }
//        Spacer(modifier = Modifier.padding(20.dp))
//        Text(text = "Click to login", fontSize = 20.sp, fontWeight = FontWeight.Bold,color = Color(0xFF03A9F4))
        Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = { login.invoke() }, modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(LocalConfiguration.current.screenWidthDp.dp - 80.dp)
            .height(LocalConfiguration.current.screenHeightDp.dp / 12),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            )
        ) {
            Text(text = "Login",fontSize = 20.sp, color = Color(0xFF03A9F4), fontWeight = FontWeight.Bold)
        }
//        Spacer(modifier = Modifier.padding(20.dp))
//        Button(onClick = { logOut.invoke() }) {
//            Text(text = "LogOut")
//        }
    }
}