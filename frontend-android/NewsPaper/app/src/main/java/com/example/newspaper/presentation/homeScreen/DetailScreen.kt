package com.example.newspaper.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(color = Color(0x6B7A7272))
                    .fillMaxWidth()
                    .height(45.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "CHOOSE YOUR NEWSPAPER", style = TextStyle(fontSize = 15.sp))
                        Text(text = "FOR YOUR DOORSTEP TOMORROW", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp))
                    }
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .width(100.dp)
                            .background(Color.Green)
                            .clip(
                                RoundedCornerShape(10.dp)
                            )
                    )
                }
            }}
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFE4EDF8)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "The Times of India")
            Spacer(modifier = Modifier.padding(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .horizontalScroll(
                        rememberScrollState()
                    ),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier
                    .height(15.dp)
                    .width(15.dp)) {
                    Text(text = "SAT")
                    Divider(modifier = Modifier.width(1.dp))
                }
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = "The HINDU")
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "The HINDU")
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "The HINDU")
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "The HINDU")
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "The HINDU")
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "The HINDU")

        }
    }
}