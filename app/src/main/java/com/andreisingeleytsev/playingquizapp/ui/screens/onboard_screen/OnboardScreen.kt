package com.andreisingeleytsev.playingquizapp.ui.screens.onboard_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.andreisingeleytsev.playingquizapp.ui.utils.QuizAppFonts
import com.andreisingeleytsev.playingquizapp.R
import com.andreisingeleytsev.playingquizapp.ui.theme.PrimaryColor
import com.andreisingeleytsev.playingquizapp.ui.utils.Routes

@Composable
fun OnboardScreen(navHostController: NavHostController, viewModel: OnBoardScreenViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .padding(vertical = 30.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = stringResource(R.string.onboard_title), style = TextStyle(
                    color = Color.Black,
                    fontFamily = QuizAppFonts.font,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ), modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )
        }
        Button(
            onClick = {
                viewModel.finishOnBoard()
                navHostController.popBackStack()
                navHostController.navigate(Routes.HOME_SCREEN)
            }, colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            ), modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.start), style = TextStyle(
                    color = Color.White,
                    fontFamily = QuizAppFonts.font,
                    fontSize = 16.sp
                ), modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}