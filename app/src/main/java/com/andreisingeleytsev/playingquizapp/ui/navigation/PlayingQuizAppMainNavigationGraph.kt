package com.andreisingeleytsev.playingquizapp.ui.navigation


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.playingquizapp.common.Constants
import com.andreisingeleytsev.playingquizapp.ui.screens.home_screen.HomeScreen
import com.andreisingeleytsev.playingquizapp.ui.screens.onboard_screen.OnboardScreen
import com.andreisingeleytsev.playingquizapp.ui.screens.quiz_screen.QuizScreen
import com.andreisingeleytsev.playingquizapp.ui.screens.result_screen.ResultScreen
import com.andreisingeleytsev.playingquizapp.ui.utils.Routes


@Composable
fun PlayingQuizAppMainNavigationGraph(
    startDestination: String
) {
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController, startDestination = startDestination,
        modifier = Modifier.background(Color.Transparent)
    ) {
        composable(Routes.ONBOARDING_SCREEN) {
            OnboardScreen(navHostController = navHostController)
        }
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navHostController = navHostController)
        }
        composable(Routes.QUIZ_SCREEN + "/{${Constants.INDEX}}") {
            QuizScreen(navHostController = navHostController)
        }
        composable(Routes.RESULT_SCREEN){
            ResultScreen(navHostController = navHostController)
        }
    }
}
