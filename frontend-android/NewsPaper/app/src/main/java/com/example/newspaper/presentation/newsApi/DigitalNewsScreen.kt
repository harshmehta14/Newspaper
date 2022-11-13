package com.example.newspaper.presentation.newsApi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch
import java.util.*

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NewsApiScreen(viewModel: NewsApiViewModel = hiltViewModel(),navController: NavController) {

    val news by viewModel.news.observeAsState()
    val context1 = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        viewModel.newS(context1)
    }

    val selected = remember {
        mutableStateOf(false)
    }

    val selected1 = remember {
        mutableStateOf(false)
    }
    Scaffold(topBar = {TopAppBar(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

        }
    }
}) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFFFE9C8)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            news?.articles?.forEach {
                Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
                    Card( shape = RoundedCornerShape(20.dp), backgroundColor = Color(0xFFFFE9C8),modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp), border = BorderStroke(2.dp,Color(0xFFB17E42))) {
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Spacer(modifier = Modifier.padding(30.dp))
                            Text(text =  "${it.title}", modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 5.dp, end = 5.dp),color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                            Spacer(modifier = Modifier.padding(10.dp),)
                            Text(text = it.description,color = Color.Black, modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 5.dp, end = 5.dp),)
                            Spacer(modifier = Modifier.padding(10.dp))
                            Text(text = "Author : "+it.author, color = Color.Black,modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 5.dp, end = 5.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            top = 15.dp,
                                            bottom = 15.dp,
                                            end = 10.dp
                                        )
                                        .clickable {
                                            selected.value = !selected.value
                                        }
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(
                                            // this is basic condition for selected chip index
                                            if (selected.value) Color.White
                                            else Color.Black
                                        )
                                        .padding(15.dp)
                                ) {
                                    Text(text = "Go To Post", color = if (selected.value) Color.Black else Color(0xFFFFE9C8))
                                }
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .padding(
                                            start = 10.dp,
                                            top = 15.dp,
                                            bottom = 15.dp,
                                            end = 10.dp
                                        )
                                        .clickable {
                                            selected1.value = !selected1.value
                                        }
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(
                                            // this is basic condition for selected chip index
                                            if (selected1.value) Color.White
                                            else Color.Black
                                        )
                                        .padding(15.dp)
                                ) {
                                    Text(text = "Share", color = if (selected1.value) Color.Black else Color(0xFFFFE9C8))
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                }
            }
        }
    }
    }
