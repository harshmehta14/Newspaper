package com.example.newspaper.presentation.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.newspaper.R
import com.example.newspaper.presentation.screens.Screens

@Composable
fun HomeScreen(navController: NavController) {
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) { 
                Text(text = "We Deliver at your", style = TextStyle(fontSize = 18.sp))
                Text(
                    text = "DOORSTEP",
                    style = TextStyle(fontSize = 22.sp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Button(
            onClick = {
                navController.navigate(Screens.LoginScreen.route)
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
                text = "Let's Get Started",
                color = Color(0xFFB17E42),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = LocalConfiguration.current.fontScale.times(25).sp
                )
            )
        }

    }
}

@Composable
private fun ChattingGuys () {

    val compositionResult: LottieCompositionResult = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            R.raw.news

        )
    )

    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    LottieAnimation(compositionResult.value, progress)

}
