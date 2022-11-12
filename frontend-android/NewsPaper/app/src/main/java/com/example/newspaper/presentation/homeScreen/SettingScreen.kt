package com.example.newspaper.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SettingScreen(navController:NavController,logOut:()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .width(LocalConfiguration.current.screenWidthDp.dp - 40.dp)
                .height(LocalConfiguration.current.screenHeightDp.dp / 12)
                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start
        ) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    }
                    .height(30.dp)
                    .width(30.dp),
                tint = Color.White
            )
            Text(text = "Settings", style = TextStyle(color = Color.White, fontSize = 30.sp), modifier = Modifier.padding(start = 80.dp))
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Divider(modifier = Modifier
            .width(220.dp)
            .height(3.dp)
            .background(Color.White))
        Spacer(modifier = Modifier.padding(15.dp))
        Row(
            modifier = Modifier
                .clickable {
                    logOut.invoke()
                }
                .height(LocalConfiguration.current.screenHeightDp.dp / 12)
                .width(
                    LocalConfiguration.current.screenWidthDp.dp - 40.dp
                )
                .border(width = 2.dp, color = Color.Red, shape = RoundedCornerShape(10.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "LOGOUT",
                modifier = Modifier.padding(start = 15.dp),
                style = TextStyle(color = Color.White, fontSize = 25.sp)
            )
        }
    }
}