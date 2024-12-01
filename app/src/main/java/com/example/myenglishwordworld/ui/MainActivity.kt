package com.example.myenglishwordworld.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.myenglishwordworld.ui.theme.MyappTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myenglishwordworld.R
import com.example.myenglishwordworld.ui.navigation.NavigationGraph
import com.example.myenglishwordworld.data.BottomItem

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyappTheme {

                val items = listOf(
                    BottomItem(
                        title = "Home",
                        icon = Icons.Default.Home,
                        route = "HomeScreen"
                    ),
                    BottomItem(
                        title = "Word Add",
                        icon = Icons.Default.Add,
                        route = "AddScreen"
                    ),
                    BottomItem(
                        title = "My Words",
                        icon = Icons.Default.Star,
                        route = "StarScreen"
                    ),
                )

                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomItem(
                            items = items,
                            navController = navController,
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(RoundedCornerShape(45.dp)),
                            containerColor = Color(0xFF011B57)
                        )
                    },


                ) { innerPadding ->
                    Image(
                        painter = painterResource(id =  R.drawable.background),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    NavigationGraph(
                        navController = navController,
                        startDestination = "HomeScreen",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun BottomItem(
    items: List<BottomItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.primary
) {
    var selectedBottomItem by rememberSaveable { mutableStateOf(0) }
    NavigationBar(
        modifier = modifier,
        containerColor = containerColor
    ) {
        items.forEachIndexed { index, bottomItem ->
            NavigationBarItem(
                selected = selectedBottomItem == index,
                onClick = {
                    selectedBottomItem = index
                    navController.navigate(bottomItem.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = bottomItem.icon,
                        contentDescription = bottomItem.title,
                        tint = if (selectedBottomItem == index) {
                            Color.White.copy(alpha = 1.0f)
                        } else {
                            Color.White.copy(alpha = 0.6f)
                        }
                    )
                },
                label = {
                    Text(
                        text = bottomItem.title,
                        color = if (selectedBottomItem == index) {
                            Color.White.copy(alpha = 1.0f)
                        } else {
                            Color.White.copy(alpha = 0.6f)
                        }
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White.copy(alpha = 1.0f),
                    unselectedIconColor = Color.White.copy(alpha = 0.6f),
                    selectedTextColor = Color.White.copy(alpha = 1.0f),
                    unselectedTextColor = Color.White.copy(alpha = 0.6f),
                    indicatorColor = containerColor
                )
            )
        }
    }
}