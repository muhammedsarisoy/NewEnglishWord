package com.example.myenglishwordworld.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myenglishwordworld.ui.home.HomeScreen
import com.example.myenglishwordworld.data.BottomItem
import com.example.myenglishwordworld.ui.game.GameScreen
import com.example.myenglishwordworld.ui.mywordscreen.MyWordsScreen
import com.example.myenglishwordworld.ui.wordadd.WordAddScreen


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
        composable(route = "WordAddScreen"){
            WordAddScreen(navController = navController)
        }
        composable(route = "GameScreen") {
            GameScreen(navController = navController)
        }
        composable(route = "MyWordsScreen"){
            MyWordsScreen(navController = navController)
        }
    }
}