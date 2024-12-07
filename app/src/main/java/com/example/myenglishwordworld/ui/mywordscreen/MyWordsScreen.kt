package com.example.myenglishwordworld.ui.mywordscreen

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myenglishwordworld.data.Words
import com.example.myenglishwordworld.data.WordsDataBase
import com.example.myenglishwordworld.ui.wordadd.WordAddRepository
import com.example.myenglishwordworld.ui.wordadd.WordAddViewModel
import com.example.myenglishwordworld.ui.wordadd.WordAddViewModelFactory


@Composable
fun MyWordsScreen(
    navController: NavHostController,
    context: Context,
    viewModel: WordAddViewModel = viewModel(
        factory = WordAddViewModelFactory(WordAddRepository(WordsDataBase.getDatabase(context).wordDao()))
    )
) {

    val words by viewModel.getAllItemsLiveData().observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ElevatedCard(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF011B57)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .padding(16.dp)
                .size(width = 400.dp, height = 800.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp)
                    ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(words.size) { word ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = words[word].text1,
                                color = Color.White,
                                modifier = Modifier.weight(1f).padding(end = 8.dp)
                            )
                            Text(
                                text = words[word].text2,
                                color = Color.White,
                                modifier = Modifier.weight(1f).padding(end = 8.dp)
                            )
                            IconButton(
                                onClick = {
                                    viewModel.deleteItemById(words[word].wordId)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = Color.White
                                )
                            }
                        }
                        Divider(
                            color = Color.White,
                            thickness = 1.dp
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyWordsScreenPreview() {
    MyWordsScreen(navController = NavHostController(LocalContext.current), context = LocalContext.current)
}



