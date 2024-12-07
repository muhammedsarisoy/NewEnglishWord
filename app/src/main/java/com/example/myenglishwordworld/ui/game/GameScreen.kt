package com.example.myenglishwordworld.ui.game

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myenglishwordworld.R
import com.example.myenglishwordworld.data.WordsDataBase
import com.example.myenglishwordworld.ui.wordadd.WordAddRepository
import com.example.myenglishwordworld.ui.wordadd.WordAddViewModel
import com.example.myenglishwordworld.ui.wordadd.WordAddViewModelFactory


@Composable
fun GameScreen(
    navController: NavHostController,
    context: Context,
    viewModel: WordAddViewModel = viewModel(
        factory = WordAddViewModelFactory(WordAddRepository(WordsDataBase.getDatabase(context).wordDao()))
    )
) {
    val words by viewModel.getAllItemsLiveData().observeAsState(emptyList())
    var currentWord by remember { mutableStateOf("No Words") }
    var correctGuess by remember { mutableIntStateOf(0) }

    LaunchedEffect(words) {
        currentWord = words.randomOrNull()?.text1 ?: "No Words"
    }

    val textFieldValueSaver = Saver<TextFieldValue, String>(
        save = { it.text },
        restore = { TextFieldValue(it) }
    )
    var inputText by rememberSaveable(stateSaver = textFieldValueSaver) { mutableStateOf(TextFieldValue("")) }

    if(correctGuess == 10){
        navController.navigate("MyWordsScreen"){
            popUpTo("GameScreen"){
                inclusive = true
            }
        }
    }


    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        ElevatedCard(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF011B57)),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .padding(16.dp)
                .size(width = 400.dp, height = 250.dp)
        ) {
            Text(
                text = currentWord,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))

        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Your Guess", color = Color.White) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            ElevatedButton(
                onClick = {
                    currentWord = words.randomOrNull()?.text1 ?: "No Words"
                    inputText = TextFieldValue("")
                },
                modifier = Modifier.weight(1f),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF011B57)
                )
            ) {
                Text("Help", color = Color.White)
            }

            ElevatedButton(
                onClick = {
                    val currentText2 = words.find { it.text1 == currentWord }?.text2 ?: ""
                    if (inputText.text.trim().lowercase() == currentText2.trim().lowercase()) {
                        currentWord = words.randomOrNull()?.text1 ?: "No Words"
                        correctGuess++
                        inputText = TextFieldValue("")
                        Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Wrong Answer", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.weight(1f),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF011B57)
                )
            ) {
                Text("Guess", color = Color.White)
            }
        }
    }
}
