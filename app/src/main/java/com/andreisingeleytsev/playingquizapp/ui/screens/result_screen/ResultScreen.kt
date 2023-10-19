package com.andreisingeleytsev.playingquizapp.ui.screens.result_screen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.playingquizapp.R
import com.andreisingeleytsev.playingquizapp.data.game.model.AnswerResult
import com.andreisingeleytsev.playingquizapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.playingquizapp.ui.theme.SecondaryColor
import com.andreisingeleytsev.playingquizapp.ui.theme.SecondaryColor2
import com.andreisingeleytsev.playingquizapp.ui.utils.QuizAppFonts
import com.andreisingeleytsev.playingquizapp.ui.utils.UIEvent

@Composable
fun ResultScreen(
    navHostController: NavHostController,
    viewModel: ResultScreenViewModel = hiltViewModel()
) {
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
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = SecondaryColor
            )
        ) {
            val horizontalGradientBrush = Brush.horizontalGradient(
                colors = listOf(
                    SecondaryColor,
                    SecondaryColor2
                )
            )
            Text(
                text = stringResource(id = R.string.quiz_done),
                modifier = Modifier
                    .background(brush = horizontalGradientBrush)
                    .fillMaxSize()
                    .padding(20.dp),
                style = TextStyle(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontFamily = QuizAppFonts.font,
                    fontSize = 20.sp
                )
            )

        }
        Card(
            modifier = Modifier
                .weight(2f)
                .padding(vertical = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.my_answer),
                    style = TextStyle(
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontFamily = QuizAppFonts.font,
                        fontSize = 16.sp
                    )
                )
                LazyRow() {
                    val list = viewModel.resultList.value
                    Log.d("tag", list.size.toString())
                    items(20) { index ->
                        val answer = list[index]
                        Card(
                            modifier = Modifier
                                .padding(5.dp)
                                .size(32.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = when (answer) {
                                    is AnswerResult.Skipped -> Color.LightGray
                                    is AnswerResult.Correct -> Color.Green
                                    is AnswerResult.Incorrect -> Color.Red
                                }
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = (index + 1).toString(),
                                    style = TextStyle(
                                        color = if (answer is AnswerResult.Skipped) Color.Black
                                        else Color.White,
                                        textAlign = TextAlign.Center,
                                        fontFamily = QuizAppFonts.font,
                                        fontSize = 14.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        AnswerCard(
                            answerResult = AnswerResult.Correct,
                            count = viewModel.getCount(AnswerResult.Correct)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        AnswerCard(
                            answerResult = AnswerResult.Incorrect,
                            count = viewModel.getCount(AnswerResult.Incorrect)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        AnswerCard(
                            answerResult = AnswerResult.Skipped,
                            count = viewModel.getCount(AnswerResult.Skipped)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        AnswerCard(
                            answerResult = null,
                            count = viewModel.getCount(null)
                        )
                    }
                }
            }
        }

        Button(
            onClick = {
                      viewModel.onEvent(ResultScreenEvent.OnBack)
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = (stringResource(id = R.string.back_to)),
                style = TextStyle(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontFamily = QuizAppFonts.font,
                    fontSize = 16.sp
                )
            )
        }
        Button(
            onClick = {
                viewModel.onEvent(ResultScreenEvent.OnRestart) },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            border = BorderStroke(1.dp, PrimaryColor),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = (stringResource(id = R.string.restart)),
                style = TextStyle(
                    color = PrimaryColor,
                    textAlign = TextAlign.Center,
                    fontFamily = QuizAppFonts.font,
                    fontSize = 16.sp
                )
            )
        }
    }
}

@Composable
fun AnswerCard(answerResult: AnswerResult?, count: Int) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize(), colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
        ) {
            Card(
                shape = CircleShape, colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                )
            ) {
                Image(
                    painter = painterResource(
                        id = when (answerResult) {
                            is AnswerResult.Skipped -> R.drawable.skipped_icon
                            is AnswerResult.Correct -> R.drawable.correct_icon
                            is AnswerResult.Incorrect -> R.drawable.incorrect_icon
                            else -> R.drawable.correct_icon
                        }
                    ), contentDescription = null, modifier = Modifier
                        .padding(10.dp)
                        .size(16.dp),
                    contentScale = ContentScale.FillBounds
                )
            }
            Text(
                text = count.toString() + stringResource(id = R.string.questions),
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = QuizAppFonts.font,
                    fontSize = 14.sp
                )
            )
            Text(
                text = stringResource(
                    id = when (answerResult) {
                        is AnswerResult.Skipped -> R.string.skipped
                        is AnswerResult.Correct -> R.string.correct
                        is AnswerResult.Incorrect -> R.string.incorrect
                        else -> R.string.total
                    }
                ),
                style = TextStyle(
                    color = Color.LightGray,
                    fontFamily = QuizAppFonts.font,
                    fontSize = 16.sp
                )
            )

        }
    }
}
