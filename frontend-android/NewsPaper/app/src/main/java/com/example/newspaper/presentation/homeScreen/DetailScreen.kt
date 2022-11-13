package com.example.newspaper.presentation.homeScreen

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newspaper.R
import com.example.newspaper.presentation.screens.Screens
import com.example.newspaper.ui.theme.Shapes
import kotlinx.coroutines.launch
import java.util.*

val days = listOf<String>("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")

@OptIn(ExperimentalMaterialApi::class)
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
                    .background(Color.Black)
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Column(modifier = Modifier.background(Color.Black)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Kabootar",
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp, color = Color(0xFFFFE9C8))
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Divider(color = Color(0xFFFFE9C8), thickness = 2.dp, modifier = Modifier.width(25.dp))
                        Text(
                            text = "${Calendar.getInstance().time}",
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color(0xFFFFE9C8))
                        )
                        Divider(color = Color(0xFFFFE9C8), thickness = 2.dp, modifier = Modifier.width(25.dp))
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
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
                Icon(Icons.Filled.Home, tint = Color.Black, contentDescription = "Home")
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
                        Row(modifier = Modifier.background(color = Color.Black)) {
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
                    }
                })
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = Color(0xFFFFE9C8)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Choose Your NewsPapers",style = TextStyle(fontSize = 18.sp),
                color = Color.Black, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(10.dp))
            distributor?.forEachIndexed { i, distributorItem ->
                ExpandableCard(title = if(distributorItem.newspaper_variety.get(i)==null) "NewsPaper" else distributorItem.newspaper_variety.get(i))
                Spacer(modifier = Modifier.padding(20.dp))
            }
            ExpandableCard(title = "Hindu")
            Spacer(modifier = Modifier.padding(20.dp))
            ExpandableCard(title = "Deccan Herald")
            Spacer(modifier = Modifier.padding(20.dp))
            ExpandableCard(title = "Economic times")
            Spacer(modifier = Modifier.padding(20.dp))
            ExpandableCard(title = "Prajavani")
            Spacer(modifier = Modifier.padding(20.dp))
            ExpandableCard(title = "Business times")
            Spacer(modifier = Modifier.padding(50.dp))
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    title: String,
    titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    padding: Dp = 12.dp
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    val selectedChipIndex = remember {
        mutableStateOf(-1)
    }

    val checkedStatus = remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp - 30.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = RoundedCornerShape(20.dp),
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xFFFFE9C8)
                )
                    Checkbox(
                        checked = checkedStatus.value,
                        onCheckedChange = { checkedStatus.value = !checkedStatus.value },
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .weight(1f),
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFFFE9C8),
                            checkmarkColor = Color.Black,
                            uncheckedColor = Color.White
                        ))
            }
            if (expandedState) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(start = 5.dp, end = 5.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    days.forEachIndexed { index, s ->
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .padding(start = 10.dp, top = 15.dp, bottom = 15.dp, end = 10.dp)
                                .clickable {
                                    selectedChipIndex.value = index
                                }
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    // this is basic condition for selected chip index
                                    if (selectedChipIndex.value == index) Color.White
                                    else Color(0xFFFFE9C8)
                                )
                                .padding(15.dp)
                        ) {
                            Text(text = s, color = if (selectedChipIndex.value == index) Color.Black else Color.Black)
                        }
                    }
                }
            }
        }
    }
}

