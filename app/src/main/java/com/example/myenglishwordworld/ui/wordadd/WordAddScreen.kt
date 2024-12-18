package com.example.myenglishwordworld.ui.wordadd

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myenglishwordworld.R
import com.example.myenglishwordworld.data.Words
import com.example.myenglishwordworld.data.WordsDao
import com.example.myenglishwordworld.data.WordsDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executor


@Composable
fun WordAddScreen(
    navController: NavHostController,
    context: Context
){

    val textFieldValueSaver = Saver<TextFieldValue, String>(
        save = { it.text },
        restore = { TextFieldValue(it) }
    )


    var text1 by rememberSaveable(stateSaver = textFieldValueSaver) { mutableStateOf(TextFieldValue("")) }
    var text2 by rememberSaveable(stateSaver = textFieldValueSaver) { mutableStateOf(TextFieldValue("")) }
    val database = WordsDataBase.getDatabase(context)
    val repository = WordAddRepository(database.wordDao())
    val viewModel: WordAddViewModel = viewModel(factory = WordAddViewModelFactory(repository))


    val firaSansFamily = FontFamily(
            Font(
                R.font.font_type ,
                FontWeight.Normal
            )
        )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Add Word",
            fontSize = 36.sp,
            fontFamily = firaSansFamily,
            color = Color.White,
            maxLines = 1,
        )

        ElevatedCard(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF011B57)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            modifier = Modifier
                .padding(16.dp)
                .size(width = 300.dp, height = 300.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                OutlinedTextField(
                    value = text1,
                    label = { Text(text = "Enter Word") },
                    placeholder = { Text(text = "Please Enter Word") },
                    modifier = Modifier.padding(16.dp),
                    onValueChange = {
                        text1 = it
                    }
                    ,
                    maxLines = 1,
                    textStyle = androidx.compose.ui.text.TextStyle(
                        color = Color.White
                    )
                )

                Spacer(
                    modifier = Modifier.padding(6.dp)
                )

                OutlinedTextField(
                    value = text2,
                    label = { Text(text = "Enter Other Word") },
                    placeholder = { Text(text = "Please Other Word") },
                    modifier = Modifier.padding(16.dp),
                    onValueChange = {
                        text2 = it
                    },
                    maxLines = 1,
                    textStyle = androidx.compose.ui.text.TextStyle(
                        color = Color.White
                    )
                )
                Spacer(
                    modifier = Modifier.padding(6.dp)
                )

                ElevatedButton(
                    onClick = {
                        val item = Words(
                            wordId = 0,
                            text1 = text1.text,
                            text2 = text2.text
                        )
                        viewModel.saveItem(item)
                        text1 = TextFieldValue("")
                        text2 = TextFieldValue("")
                        Toast.makeText(context, "Word Added", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.size(width = 250.dp, height = 50.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color.White
                    ),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF011B57))
                )
                {
                    Text(text = "Add Word" , color = Color.White  , fontSize = 16.sp , fontWeight = FontWeight.Bold, fontFamily = firaSansFamily)
                }
            }
        }
    }
}


