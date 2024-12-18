package com.example.myenglishwordworld.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.simulateHotReload
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myenglishwordworld.R

@Composable
fun HomeScreen(
    navController: NavHostController
){

    val firaSansFamily = FontFamily(
        Font(
            R.font.font_type ,
            FontWeight.Normal
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp , top = 50.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Text(
                text = "Welcome to",
                fontSize = 36.sp,
                fontFamily = firaSansFamily,
                color = Color.White,
                maxLines = 1,
                letterSpacing = 1.2.sp,
                lineHeight = 40.sp
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Text(
                text = "Words Learner",
                fontSize = 30.sp,
                fontFamily = firaSansFamily,
                color = Color.White,
                maxLines = 1,
                letterSpacing = 1.2.sp,
                lineHeight = 40.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 200.dp , end = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ElevatedButton(
                onClick = {
                    navController.navigate("GameScreen")
                },
                modifier = Modifier.size(width = 300.dp , height = 50.dp)
                    .clip(RoundedCornerShape(8.dp)),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF011B57)
                )
            ) {
                Text(
                    text = "Start Learn",
                    fontSize = 24.sp,
                    fontFamily = firaSansFamily,
                    color = Color.White,
                    maxLines = 1,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "You will try to guess 10 words. ",
                fontSize = 16.sp,
                fontFamily = firaSansFamily,
                color = Color.White,
                maxLines = 1,
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        navController = NavHostController(LocalContext.current)
    )
}