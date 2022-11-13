package com.example.newspaper.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newspaper.R
import com.example.newspaper.presentation.screens.Screens

@Composable
fun LoginScreen(login : () ->Unit) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFC0B4A9))
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(570.dp)
            .background(color = Color(0xFFC0B4A9)), contentAlignment = Alignment.TopCenter){
            Image(
                painter = painterResource(id = R.drawable.paper),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
            )
        }

        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = "DOORSTEP",
            style = TextStyle(fontSize = 22.sp),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Button(
            onClick = {
                login.invoke()
            }, modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .border(width = 2.dp, color = Color(0xFFB17E42), shape = RoundedCornerShape(30.dp))
                .width(LocalConfiguration.current.screenWidthDp.dp - 45.dp)
                .height(LocalConfiguration.current.screenHeightDp.dp / 12),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            )
        ) {
            Text(
                text = "LOGIN",
                color = Color(0xFFB17E42),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = LocalConfiguration.current.fontScale.times(25).sp
                )
            )
        }

    }
}