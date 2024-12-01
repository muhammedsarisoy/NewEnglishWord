package com.example.myenglishwordworld.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myenglishwordworld.ui.home.HomeScreen
import com.example.myenglishwordworld.data.BottomItem


@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ){
        composable(route = "HomeScreen"){
            HomeScreen(navController = navController)
        }
    }
}