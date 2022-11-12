package com.example.newspaper.presentation.homeScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newspaper.presentation.screens.Screens
import com.example.newspaper.R

@Composable
fun DetailScreen(navController: NavController,viewModel: DetailViewModel = hiltViewModel(),context: Context) {

    val distributor by viewModel.distributro.observeAsState()

    val settingSelected = remember {
        mutableStateOf(false)
    }
    val profileSelected = remember{
        mutableStateOf(false)
    }
    val chattSelected = remember {
        mutableStateOf(false)
    }
    val history = remember {
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
//                    Box(
//                        modifier = Modifier
//                            .clip(
//                                RoundedCornerShape(10.dp)
//                            )
//                            .height(30.dp)
//                            .width(100.dp)
//                            .background(Color.Green)
//
//                    )
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
                contentColor = Color.Black,
                content = {
                    BottomNavigation {
                        BottomNavigationItem(
                            selected = profileSelected.value,
                            selectedContentColor = Color.Red,
                            unselectedContentColor = Color.White,
                            onClick = {
                                      profileSelected.value = !profileSelected.value
                                    settingSelected.value = false
                                    chattSelected.value = false
                                    history.value = false
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
                            selected = profileSelected.value,
                            selectedContentColor = Color.Red,
                            unselectedContentColor = Color.White,
                            onClick = {
                                chattSelected.value = !chattSelected.value
                                settingSelected.value = false
                                profileSelected.value = false
                                history.value = false
                                Toast.makeText(context,"Will be available soon",Toast.LENGTH_SHORT).show()
                            },
                            icon = {
                                Icon(painter = painterResource(id = R.drawable.ic_baseline_chat_24), contentDescription = null)
                            },
                            label = { Text(text = "Chat") },
                            alwaysShowLabel = false,
                            modifier = Modifier.background(Color.Black)
                        )
                        Spacer(modifier = Modifier.padding(20.dp))
                        BottomNavigationItem(
                            selected = profileSelected.value,
                            selectedContentColor = Color.Red,
                            unselectedContentColor = Color.White,
                            onClick = {
                                history.value = !history.value
                                settingSelected.value = false
                                chattSelected.value = false
                                profileSelected.value = false
                                navController.navigate(Screens.NewsApiScreen.route)
                                Toast.makeText(context,"Will be available soon",Toast.LENGTH_SHORT).show()
                            },
                            icon = {
                                Icon(painter = painterResource(id = R.drawable.ic_baseline_chat_24), contentDescription = null)
                            },
                            label = { Text(text = "History") },
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
                                chattSelected.value = false
                                history.value = false
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

        }
    }
}