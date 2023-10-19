package com.andreisingeleytsev.playingquizapp.ui.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.andreisingeleytsev.playingquizapp.ui.theme.SecondaryColor
import com.andreisingeleytsev.playingquizapp.ui.theme.SecondaryColor2
import com.andreisingeleytsev.playingquizapp.ui.utils.QuizAppFonts
import com.andreisingeleytsev.playingquizapp.ui.utils.Routes

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn() {
            items(viewModel.list) { quizItem ->
                val horizontalGradientBrush = Brush.horizontalGradient(
                    colors = listOf(
                        SecondaryColor,
                        SecondaryColor2
                    )
                )
                Button(
                    contentPadding = PaddingValues(0.dp), modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp), onClick = {
                        navHostController.navigate(
                            Routes.QUIZ_SCREEN + "/${
                                viewModel.list.indexOf(
                                    quizItem
                                )
                            }"
                        )
                    }, shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = stringResource(id = quizItem.name),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .background(brush = horizontalGradientBrush)
                            .fillMaxWidth()
                            .padding(5.dp),
                        style = TextStyle(
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontFamily = QuizAppFonts.font,
                            fontSize = 20.sp
                        )
                    )
                }
            }
        }
    }
}