package com.example.myenglishwordworld.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myenglishwordworld.R


@Composable
fun GameScreen(
    navController: NavHostController

){
    var text by remember { mutableStateOf(TextFieldValue("")) }

    val firaSansFamily = FontFamily(
        Font(
            R.font.font_type ,
            FontWeight.Normal
        )
    )

    Column {
        ElevatedCard(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF011B57)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .padding(16.dp).size(width = 400.dp, height = 250.dp)
        ) {

        }
        Spacer(
            modifier = Modifier.padding(8.dp)
        )

        ElevatedCard(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF011B57)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .padding(16.dp).size(width = 400.dp, height = 250.dp)
        ) {
            Column(
                modifier = Modifier.background(Color(0xFF011B57)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                OutlinedTextField(
                    value = text,
                    placeholder = {
                        Text(
                            text = "Enter your word",
                            fontFamily = firaSansFamily,
                            color = Color.White,
                            maxLines = 1,
                        )
                    },
                    onValueChange = {
                        text = it
                    },
                    modifier = Modifier.padding(16.dp).size(width = 400.dp, height = 300.dp).align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        cursorColor = Color.White
                    )
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            ElevatedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 32.dp , top = 32.dp).size(width = 150.dp, height = 65.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF011B57)
                )
            ) {
                Text(
                    text = "Help",
                    fontFamily = firaSansFamily,
                    color = Color.White,
                    maxLines = 1,

                )
            }
            ElevatedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 32.dp, top = 32.dp).size(width = 150.dp, height = 65.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF011B57)
                )
            ){
                Text(
                    text = "Guess",
                    fontFamily = firaSansFamily,
                    color = Color.White,
                    maxLines = 1,
                )
            }
        }
    }
}