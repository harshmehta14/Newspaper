package com.example.newspaper.presentation.newsApi

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NewsApiScreen(viewModel: NewsApiViewModel = hiltViewModel()) {

    val news by viewModel.news.observeAsState()
    val context1 = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        viewModel.newS(context1)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        news?.articles?.forEach {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Card(border = BorderStroke(5.dp, color = Color.Green), shape = RoundedCornerShape(20.dp), backgroundColor = Color.Gray) {
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = if (it.title == null) "No title" else it.title)
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(text = it.description, modifier = Modifier.align(Alignment.CenterHorizontally))
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(text = "Author : "+it.author)
                    }    
                }
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}