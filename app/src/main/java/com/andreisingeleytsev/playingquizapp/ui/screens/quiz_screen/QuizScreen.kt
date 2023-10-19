package com.andreisingeleytsev.playingquizapp.ui.screens.quiz_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.playingquizapp.R
import com.andreisingeleytsev.playingquizapp.common.Constants
import com.andreisingeleytsev.playingquizapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.playingquizapp.ui.theme.SecondaryColor
import com.andreisingeleytsev.playingquizapp.ui.theme.SecondaryColor2
import com.andreisingeleytsev.playingquizapp.ui.utils.QuizAppFonts
import com.andreisingeleytsev.playingquizapp.ui.utils.Routes
import com.andreisingeleytsev.playingquizapp.ui.utils.UIEvent
import kotlinx.coroutines.flow.collect

@Composable
fun QuizScreen(
    navHostController: NavHostController,
    viewModel: QuizScreenViewModel = hiltViewModel()
) {
    val timeRemaining = viewModel.timeFlow.collectAsState(initial = 0L)
    val questionItem = viewModel.currentQuestion
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UIEvent.OnBack -> navHostController.popBackStack()
                is UIEvent.OnNavigate -> {
                    navHostController.navigate(event.route)
                }
            }
        }
    }
    questionItem.value?.let { question ->
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Card(
                modifier = Modifier
                    .weight(3f)
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = stringResource(id = R.string.playing_game), style = TextStyle(
                                color = Color.Black,
                                fontFamily = QuizAppFonts.font,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            ), modifier = Modifier
                                .fillMaxWidth()
                                .align(
                                    Alignment.Center
                                )
                        )
                        IconButton(
                            onClick = { viewModel.onEvent(QuizScreenEvent.OnBack) },
                            modifier = Modifier.align(
                                Alignment.CenterStart
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f), verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = viewModel.formatTime(timeRemaining.value), style = TextStyle(
                                color = Color.Black,
                                fontFamily = QuizAppFonts.font,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            ), modifier = Modifier.weight(1f)
                        )
                        Card(
                            modifier = Modifier
                                .weight(7f),
                            shape = RoundedCornerShape(100.dp)
                        ) {
                            LinearProgressIndicator(
                                progress = viewModel.getProgressFloat(timeRemaining.value),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(10.dp),
                                trackColor = Color.LightGray,
                                color = SecondaryColor
                            )
                        }
                        Text(
                            text = viewModel.formatTime(Constants.ROUND_TIME), style = TextStyle(
                                color = Color.Black,
                                fontFamily = QuizAppFonts.font,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            ), modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
            Card(
                modifier = Modifier
                    .weight(4f)
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ), shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize()
                ) {
                    Text(
                        text = (viewModel.index.value + 1).toString() + "/20", style = TextStyle(
                            color = PrimaryColor,
                            fontFamily = QuizAppFonts.font,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        ), modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    )
                    Text(
                        text = stringResource(id = question.questionIndex), style = TextStyle(
                            color = Color.Black,
                            fontFamily = QuizAppFonts.font,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        ), modifier = Modifier
                            .fillMaxWidth()
                            .weight(3f)
                    )
                }
            }
            LazyColumn(modifier = Modifier.weight(6f)) {
                val list = question.listOfAnswers
                val pressedItem = mutableStateOf<Int?>(null)

                items(list) { answer ->
                    val index = list.indexOf(answer)
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                            .weight(1f),
                        shape = RoundedCornerShape(12.dp), colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ), border = BorderStroke(
                            2.dp, when (index) {
                                viewModel.rightAnswer.value -> Color.Green
                                viewModel.choseAnswer.value -> Color.Red
                                else -> Color.White
                            }
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = pressedItem.value == answer, onClick = {
                                    viewModel.onEvent(
                                        QuizScreenEvent.OnChoseAnswer(index)
                                    )
                                    pressedItem.value = if (pressedItem.value != answer) answer
                                    else null

                                }, colors = RadioButtonDefaults.colors(
                                    selectedColor = PrimaryColor
                                ), modifier = Modifier.padding(horizontal = 16.dp)
                            )
                            Text(
                                text = stringResource(id = answer), style = TextStyle(
                                    color = if (pressedItem.value == answer) PrimaryColor
                                    else Color.Black,
                                    fontFamily = QuizAppFonts.font,
                                    fontSize = 16.sp
                                )
                            )
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f),
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        viewModel.onEvent(QuizScreenEvent.OnContinuePressed)
                    },
                    shape = RoundedCornerShape(100.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor
                    ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.continue_title), style = TextStyle(
                            color = Color.White,
                            fontFamily = QuizAppFonts.font,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }

        }
    }
}

