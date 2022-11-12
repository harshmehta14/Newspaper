package com.example.newspaper.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newspaper.data.dclass.distributor.Distributor
import com.example.newspaper.presentation.screens.Screens

@Composable
fun DetailScreen(navController: NavController,viewModel: DetailViewModel = hiltViewModel()) {

    val distributor by viewModel.distributro.observeAsState()

    val settingSelected = remember {
        mutableStateOf(false)
    }
    val profileSelected = remember{
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(color = Color(0x6B7A7272))
                    .fillMaxWidth()
                    .height(50.dp)
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
                        Text(text = "CHOOSE YOUR NEWSPAPER", style = TextStyle(fontSize = 10.sp))
                        Text(text = "FOR YOUR DOORSTEP TOMORROW", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp))
                    }
                    Box(
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(10.dp)
                            )
                            .height(30.dp)
                            .width(100.dp)
                            .background(Color.Green)

                    )
                }
            }
        },floatingActionButton = {
            FloatingActionButton(
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 50.dp),
                onClick = {
                },
                shape = RoundedCornerShape(50),
                backgroundColor = Color.White
            ) {
                Icon(Icons.Filled.Home, tint = Color.Red, contentDescription = "Home")
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar(
                cutoutShape = RoundedCornerShape(50),
                content = {
                    BottomNavigation {
                        BottomNavigationItem(
                            selected = profileSelected.value,
                            selectedContentColor = Color.Red,
                            unselectedContentColor = Color.White,
                            onClick = {
                                      profileSelected.value = !profileSelected.value
                                    settingSelected.value = false
                                    navController.navigate(Screens.NewsApiScreen.route)
                            },
                            icon = {
                                Icon(Icons.Filled.Info, contentDescription = "Online News")
                            },
                            label = { Text(text = "Online News") },
                            alwaysShowLabel = false,
                            modifier = Modifier.background(Color.Black)
                        )



                        BottomNavigationItem(
                            selected = settingSelected.value,
                            selectedContentColor = Color.Red,
                            unselectedContentColor = Color.White,
                            onClick = {
                                settingSelected.value = !settingSelected.value
                                profileSelected.value = false
                                navController.navigate(Screens.SettingScreen.route)
                            },
                            icon = {
                                Icon(Icons.Filled.Settings, contentDescription = "setting")
                            },
                            label = { Text(text = "Setting") },
                            alwaysShowLabel = false,
                            modifier = Modifier.background(Color.Black)
                        )
//                        BottomNavigationItem(
//                            selected = true,
//                            selectedContentColor = Color.Red,
//                            onClick = {
//
//                            },
//                            icon = {
//                                Icon(Icons.Filled.Settings, contentDescription = "setting")
//                            },
//                            label = { Text(text = "Setting") },
//                            alwaysShowLabel = false,
//                            modifier = Modifier.background(Color.Black)
//                        )
                    }
                })
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFFFE9C8)),
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