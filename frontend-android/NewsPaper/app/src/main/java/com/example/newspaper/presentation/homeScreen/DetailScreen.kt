package com.example.newspaper.presentation.homeScreen

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newspaper.R
import com.example.newspaper.presentation.screens.Screens
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DetailScreen(navController: NavController,viewModel: DetailViewModel = hiltViewModel(),context: Context) {

    val distributor by viewModel.distributro.observeAsState()
    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        viewModel.getDistributors()
    }

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

    val index = remember {
        mutableStateOf(0)
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
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "CHOOSE YOUR NEWSPAPER", style = TextStyle(fontWeight = FontWeight.Bold,fontSize = 12.sp))
                        Text(text = "FOR YOUR DOORSTEP TOMORROW", style = TextStyle(fontSize = 10.sp))
                    }
                    Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color.White)
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
                    }
                })
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = Color(0xFFFFE9C8)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = "Choose Your NewsPapers",style = TextStyle(fontSize = 20.sp),
                color = Color(0xFF03A9F4), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(20.dp))
            distributor?.forEachIndexed { i, distributorItem ->
                Card(
                    modifier = Modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp - 50.dp)
                        .height(100.dp)
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    val selected = remember {
                        mutableStateOf(false)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable { selected.value = !selected.value },
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = if(distributorItem.newspaper_variety.get(i)==null) "NewsPaper" else distributorItem.newspaper_variety.get(i),
                            style = TextStyle(fontSize = 18.sp),
                            color = Color(0xFF03A9F4)
                        )
                        RadioButton(selected = selected.value, onClick = { selected.value = !selected.value })
                    }
                }
                Spacer(modifier = Modifier.padding(20.dp))
            }
            Spacer(modifier = Modifier.padding(50.dp))
        }
    }
}


//
//Card(
//modifier = Modifier
//.width(LocalConfiguration.current.screenWidthDp.dp - 50.dp)
//.height(100.dp)
//.background(Color.Transparent),
//shape = RoundedCornerShape(20.dp)
//) {
//    val selected = remember {
//        mutableStateOf(false)
//    }
//    Row(
//        modifier = Modifier.fillMaxSize().clickable { selected.value = !selected.value },
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            text = "Hindhu",
//            style = TextStyle(fontSize = 18.sp),
//            color = Color(0xFF03A9F4)
//        )
//        RadioButton(selected = selected.value, onClick = { selected.value = !selected.value })
//    }
//}
//Spacer(modifier = Modifier.padding(20.dp))
//
//Card(
//modifier = Modifier
//.width(LocalConfiguration.current.screenWidthDp.dp - 50.dp)
//.height(100.dp)
//.background(Color.Transparent),
//shape = RoundedCornerShape(20.dp)
//) {
//    val selected = remember {
//        mutableStateOf(false)
//    }
//    Row(
//        modifier = Modifier.fillMaxSize().clickable { selected.value = !selected.value },
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//        Text(
//            text = "Deccan Herald",
//            style = TextStyle(fontSize = 18.sp),
//            color = Color(0xFF03A9F4)
//        )
//        RadioButton(selected = selected.value, onClick = { selected.value = !selected.value })
//    }
//}
//Spacer(modifier = Modifier.padding(20.dp))
//
//Card(
//modifier = Modifier
//.width(LocalConfiguration.current.screenWidthDp.dp - 50.dp)
//.height(100.dp)
//.background(Color.Transparent),
//shape = RoundedCornerShape(20.dp)
//) {
//    val selected = remember {
//        mutableStateOf(false)
//    }
//    Row(
//        modifier = Modifier.fillMaxSize().clickable { selected.value = !selected.value },
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//        Text(
//            text = "Prajavani",
//            style = TextStyle(fontSize = 18.sp),
//            color = Color(0xFF03A9F4)
//        )
//        RadioButton(selected = selected.value, onClick = { selected.value = !selected.value })
//    }
//}
//Spacer(modifier = Modifier.padding(20.dp))
//Card(
//modifier = Modifier
//.width(LocalConfiguration.current.screenWidthDp.dp - 50.dp)
//.height(100.dp)
//.background(Color.Transparent),
//shape = RoundedCornerShape(20.dp)
//) {
//    val selected = remember {
//        mutableStateOf(false)
//    }
//    Row(
//        modifier = Modifier.fillMaxSize().clickable { selected.value = !selected.value },
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//        Text(
//            text = "Buisness times",
//            style = TextStyle(fontSize = 18.sp),
//            color = Color(0xFF03A9F4)
//        )
//        RadioButton(selected = selected.value, onClick = { selected.value = !selected.value })
//    }